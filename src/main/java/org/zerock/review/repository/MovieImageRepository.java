package org.zerock.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.review.entity.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
