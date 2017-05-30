package de.hybris.platform.customerreview;

import java.io.IOException;
import java.util.List;

import de.hybris.platform.customerreview.model.Customer;
import de.hybris.platform.customerreview.model.CustomerComment;
import de.hybris.platform.customerreview.model.Product;
import de.hybris.platform.customerreview.model.Review;
import de.hybris.platform.customerreview.model.ReviewCountReport;


public interface CustomerReviewService {
	void create(Review review);
	
	List<Review> findReviews();

	List<Customer> findCustomers() throws IOException;

	List<CustomerComment> findComments() throws IOException;

	List<String> findCurseWords() throws IOException;

	List<Product> findProducts()throws IOException;
	
	List<String> findProductsDesc()throws IOException;

	Customer findCustomerByName(String customer);

	Iterable<ReviewCountReport> getReviewCount(Integer ratingFrom, Integer ratingTo);
}
