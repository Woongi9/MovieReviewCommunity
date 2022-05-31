package org.zerock.review.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.review.entity.Member;
import org.zerock.review.entity.Movie;
import org.zerock.review.entity.Review;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @Test
//    public void insertMovieReviews() {
//        IntStream.rangeClosed(1,200).forEach(i->{
//            //영화 번호
//            long mno = (long) (Math.random() * 100) + 1;
//
//            //리뷰어 번호
//            long mid = (long) (Math.random() * 100) + 1;
//            Member member = Member.builder().mid(mid).build();
//
//            Review movieReview = Review.builder()
//                    .member(member)
//                    .movie(Movie.builder().mno(mno).build())
//                    .grade((int) (Math.random() * 5) + 1)
//                    .text("이 영화를 본 후 느낌 ... : " + i)
//                    .build();
//
//            reviewRepository.save(movieReview);
//
//        });
//    }
//
//    @Test
//    public void testGetMovieReviews() {
//        Movie movie = Movie.builder().mno(99L).build();
//
//        List<Review> result = reviewRepository.findByMovie(movie);
//
//        result.forEach(movieReview -> {
//            System.out.print(movieReview.getReviewnum());
//            System.out.print("\t" + movieReview.getGrade());
//            System.out.print("\t" + movieReview.getText());
//            System.out.print("\t" + movieReview.getMember().getEmail());
//            System.out.println("------------------------------");
//        });
//    }
}