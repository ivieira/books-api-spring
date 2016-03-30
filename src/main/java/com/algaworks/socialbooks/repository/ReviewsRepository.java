package com.algaworks.socialbooks.repository;

import com.algaworks.socialbooks.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review, Long> {

}
