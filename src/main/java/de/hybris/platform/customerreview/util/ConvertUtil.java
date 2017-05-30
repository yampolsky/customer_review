package de.hybris.platform.customerreview.util;

import de.hybris.platform.customerreview.model.Customer;
import de.hybris.platform.customerreview.model.CustomerComment;
import de.hybris.platform.customerreview.model.Review;
import de.hybris.platform.customerreview.modelui.CommentForm;

public class ConvertUtil {

	public static Review from(CommentForm form, Customer customer)
	{
        CustomerComment customerComment = new CustomerComment();
        customerComment.setCustomer(customer);
        customerComment.setComment(form.getComment());
         
        Review review = new Review();
        review.setProduct(form.getProduct());
        review.setCustomerComment(customerComment);
        review.setRating(form.getRating());
        
        return review;
	}
}
