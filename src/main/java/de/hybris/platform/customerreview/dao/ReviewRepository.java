package de.hybris.platform.customerreview.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import de.hybris.platform.customerreview.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}