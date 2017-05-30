package de.hybris.platform.customerreview.impl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.dao.CustomerReviewDao;
import de.hybris.platform.customerreview.model.Customer;
import de.hybris.platform.customerreview.model.CustomerComment;
import de.hybris.platform.customerreview.model.Product;
import de.hybris.platform.customerreview.model.Review;
import de.hybris.platform.customerreview.model.ReviewCountReport;

@Service
@Transactional
public class DefaultCustomerReviewService implements CustomerReviewService {

    @Autowired
    private CustomerReviewDao customerReviewDao;

    @Override
    public void create(Review review) {
    	customerReviewDao.create(review);
    }

	@Override
	public List<Review> findReviews() {
		return customerReviewDao.findReview();
	}
	
	@Override
	public List<Customer> findCustomers() throws IOException {
		return customerReviewDao.findCustomers();
	}

	@Override
	public List<CustomerComment> findComments() throws IOException {
		List<CustomerComment> comments = customerReviewDao.findComments();
		return comments;
	}
	
	@Override
	public List<String> findCurseWords() throws IOException {
		return customerReviewDao.findCurseWords();
	}

	@Override
	public List<Product> findProducts() throws IOException {
		return customerReviewDao.findProducts();
	}

	@Override
	public List<String> findProductsDesc() throws IOException {
		return customerReviewDao.findProductsDesc();
	}

	@Override
	public Customer findCustomerByName(String customer) {
		return customerReviewDao.findCustomerByName(customer);
	}

	@Override
	public Iterable<ReviewCountReport> getReviewCount(Integer ratingFrom, Integer ratingTo) {
		return customerReviewDao.getReviewCountReport(ratingFrom, ratingTo);
	}
}
