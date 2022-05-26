package org.zerock.review.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.review.entity.Movie;
import org.zerock.review.entity.QMember;
import org.zerock.review.entity.QMovie;
import org.zerock.review.entity.QReview;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class SearchMovieRepositoryImpl extends QuerydslRepositorySupport implements SearchMovieRepository{

    public SearchMovieRepositoryImpl(){
        super(Movie.class);
    }

    @Override
    public Movie search1() {
        log.info("search1 ..............................");

        QMovie movie = QMovie.movie;
        QReview review = QReview.review;
        QMember member = QMember.member;

        JPQLQuery<Movie> jpqlQuery = from(movie);
        jpqlQuery.leftJoin(movie).on(review.movie.eq(movie));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(review, movie.mno, review.count());
        tuple.groupBy(review);

        log.info("------------------------------");
        log.info(tuple);
        log.info("------------------------------");

        List<Tuple> result = tuple.fetch();
        log.info(result);

        return null;
    }

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {

        log.info("searchPage..............................");

        QMovie movie = QMovie.movie;
        QReview review = QReview.review;

        JPQLQuery<Movie> jpqlQuery = from(movie);
        jpqlQuery.leftJoin(movie).on(review.movie.eq(movie));
        jpqlQuery.leftJoin(review).on(review.movie.eq(movie));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(movie, review.count());

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = movie.mno.gt(0L);

        if (type != null) {

            String[] typeArr = type.split("");

            //검색 조건 작성
            BooleanBuilder conditionBuilder = new BooleanBuilder();

            for (String t : typeArr) {
                switch (t){
                    case "t" :
                        conditionBuilder.or(movie.title.contains(keyword));
                        break;
                }
            }
            booleanBuilder.and(conditionBuilder);
        }

        tuple.where(booleanBuilder);

        //Order by
        Sort sort = pageable.getSort();

        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;

            String prop = order.getProperty();

            PathBuilder orderByExpression = new PathBuilder(Movie.class, "movie");

            tuple.orderBy(new OrderSpecifier(direction, orderByExpression.get(prop)));
        });

        tuple.groupBy(movie);

        //page 처리
        tuple.offset(pageable.getOffset());
        tuple.limit(pageable.getPageSize());

        List<Tuple> result = tuple.fetch();

        log.info(result);

        long count = tuple.fetchCount();

        log.info("COUNT : " + count);

        return new PageImpl<Object[]>(
                result.stream().map(t -> t.toArray()).collect(Collectors.toList()),
                pageable,
                count);
    }
}
