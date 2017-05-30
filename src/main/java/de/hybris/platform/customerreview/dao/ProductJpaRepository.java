package de.hybris.platform.customerreview.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import de.hybris.platform.customerreview.model.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long>{

}
