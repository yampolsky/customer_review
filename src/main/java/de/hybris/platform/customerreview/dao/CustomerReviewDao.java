package de.hybris.platform.customerreview.dao;

import java.io.IOException;
import java.util.List;

import de.hybris.platform.customerreview.model.Customer;
import de.hybris.platform.customerreview.model.CustomerComment;
import de.hybris.platform.customerreview.model.Product;
import de.hybris.platform.customerreview.model.Review;
import de.hybris.platform.customerreview.model.ReviewCountReport;

public interface CustomerReviewDao {
	
    void create(Review review);

    void update(Review review);

    Review getReviewById(int id);
    
    void delete(int id);

    List<Review> findReview();

	List<Customer> findCustomers() throws IOException;

	List<CustomerComment> findComments() throws IOException;

	List<String> findCurseWords() throws IOException;

	List<Product> findProducts();

	List<String> findProductsDesc();

	Customer findCustomerByName(String name);

	List<ReviewCountReport> getReviewCountReport(Integer ratingFrom, Integer ratingTo);

}
