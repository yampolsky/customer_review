package de.hybris.platform.customerreview.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.hybris.platform.customerreview.model.Customer;

@Transactional
public interface CustomerJpaRepository extends JpaRepository<Customer, Long>{

}
