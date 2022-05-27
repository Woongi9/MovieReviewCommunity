package org.zerock.review.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.review.entity.Movie;

public interface SearchMovieRepository {

    Movie search1();

    Page<Object[]> searchPage(String keyword, Pageable pageable);
}
