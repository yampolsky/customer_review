package de.hybris.platform.customerreview.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import de.hybris.platform.customerreview.model.CustomerComment;

public interface CommentJpaRepository  extends JpaRepository<CustomerComment, Long> {

}
