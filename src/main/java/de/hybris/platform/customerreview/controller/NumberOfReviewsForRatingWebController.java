package de.hybris.platform.customerreview.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.model.Customer;
import de.hybris.platform.customerreview.model.Product;
import de.hybris.platform.customerreview.model.Review;
import de.hybris.platform.customerreview.modelui.CommentForm;
import de.hybris.platform.customerreview.util.ConvertUtil;

@Controller
public class NumberOfReviewsForRatingWebController extends WebMvcConfigurerAdapter  {

	@Autowired
    private CustomerReviewService customerReviewService;
	
	private List<Product> products;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/countReviewResults").setViewName("countReviewResults");
    }

    @GetMapping("/count1")
    public String showForm(CommentForm form) {
        return "countReview";
    }

    @PostMapping("count1")
    public String checkCommentsInfo(@Valid CommentForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "countReviews";
        }

        String customer = form.getCustomer();
        //if customer with the Name exists than use it otherwise create new Customer
        Customer customerObj = customerReviewService.findCustomerByName(customer);
        if(customerObj == null)
        {
        	customerObj = new Customer();
        	customerObj.setName(customer);
        	customerObj.setLoginName(customer);
        }
        
        Review review = ConvertUtil.from(form, customerObj);
        
        customerReviewService.create(review);
        
        return "redirect:/countReviewResults";
    }
    
   
}
