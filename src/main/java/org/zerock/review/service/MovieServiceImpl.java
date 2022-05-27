package org.zerock.review.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.review.dto.MovieDTO;
import org.zerock.review.dto.PageRequestDTO;
import org.zerock.review.dto.PageResultDTO;
import org.zerock.review.entity.Movie;
import org.zerock.review.entity.MovieImage;
import org.zerock.review.repository.MovieImageRepository;
import org.zerock.review.repository.MovieRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final MovieImageRepository imageRepository;

    @Transactional
    @Override
    public Long register(MovieDTO movieDTO) {

        Map<String , Object> entityMap = dtoToEntity(movieDTO);

        Movie movie = (Movie) entityMap.get("movie");

        List<MovieImage> movieImageList = (List<MovieImage>) entityMap.get("imgList");

        movieRepository.save(movie);

        movieImageList.forEach(movieImage -> {
            imageRepository.save(movieImage);
        });

        return movie.getMno();
    }

    @Override
    public PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO) {

        //검색 X
        if(requestDTO.getKeyword() == null) {
            Pageable pageable = requestDTO.getPageable(Sort.by("mno").descending());

            Page<Object[]> result = movieRepository.getListPage(pageable);

            for (Object ob : result) {
                System.out.println(result.toString());
            }

            Function<Object[], MovieDTO> fn = (arr -> entitiesToDTO(
                    (Movie) arr[0],
                    (List<MovieImage>) (Arrays.asList((MovieImage) arr[1])),
                    (Double) arr[2],
                    (Long) arr[3])
            );
            return new PageResultDTO<>(result, fn);

        }else{
            //검색 O
            log.info("SearchPage..............................");

            Function<Object[], MovieDTO> fn = (arr -> entitiesToDTO(
                    (Movie) arr[0],
                    (List<MovieImage>) (Arrays.asList((MovieImage)arr[1])),
                    (Double) arr[2],
                    (Long)arr[3])
            );

            Page<Object[]> result = movieRepository.searchPage(
                    requestDTO.getKeyword(),
                    requestDTO.getPageable(Sort.by("mno").descending())
            );

            for (Object ob : result) {
                System.out.println(ob.toString());
            }

            return new PageResultDTO<>(result, fn);
        }

    }

    @Override
    public MovieDTO getMovie(Long mno) {

        List<Object[]> result = movieRepository.getMovieWithAll(mno);

        //Movie 엔티티는 가장 앞에 존재 모든 Row가 동일한 값
        Movie movie = (Movie) result.get(0)[0];

        //영화의 이미지 개수만큼 MovieImage객체 필요
        List<MovieImage> movieImageList = new ArrayList<>();

        result.forEach(arr ->{
            MovieImage movieImage = (MovieImage) arr[1];
            movieImageList.add(movieImage);
        });

        //평균 평점 - 모든 Row가 동일한 값
        Double avg = (Double) result.get(0)[2];
        //리뷰 개수 - 모든 Row가 동일한 값
        Long reviewCnt = (Long) result.get(0)[3];

        return entitiesToDTO(movie, movieImageList, avg, reviewCnt);
    }
}
