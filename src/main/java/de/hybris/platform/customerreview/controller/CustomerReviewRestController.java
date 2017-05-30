package de.hybris.platform.customerreview.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.model.Customer;
import de.hybris.platform.customerreview.model.CustomerComment;
import de.hybris.platform.customerreview.model.Review;
import de.hybris.platform.customerreview.model.ReviewCountReport;

@RestController
@EnableAutoConfiguration
@RequestMapping("/hd")
public class CustomerReviewRestController {

    @Autowired
    private CustomerReviewService customerReviewService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerReviewRestController.class);


	@RequestMapping(path="/review", method = RequestMethod.GET)
	public Iterable<Review> findReviews() throws IOException {
		return customerReviewService.findReviews();
	}
	
	@RequestMapping(path="/customer", method = RequestMethod.GET)
	public Iterable<Customer> findCustomers() throws IOException {
		return customerReviewService.findCustomers();
	}
	
	@RequestMapping(path="/comment", method = RequestMethod.GET)
	public Iterable<CustomerComment> findComments() throws IOException {
		List<CustomerComment> comments = customerReviewService.findComments();
		return comments;
	}
	
	@RequestMapping(path="/words", method = RequestMethod.GET)
	public Iterable<String> findCurseWords() throws IOException {
		List<String> words = customerReviewService.findCurseWords();
		return words;
	}

	@RequestMapping(path="/count", method = RequestMethod.GET)
	public Iterable<ReviewCountReport> getReviewCount(@RequestParam(value="from", defaultValue="0") Integer ratingFrom,
										   @RequestParam(value="to",   defaultValue="9") Integer ratingTo) throws IOException {
		return customerReviewService.getReviewCount(ratingFrom, ratingTo);

	}
}
