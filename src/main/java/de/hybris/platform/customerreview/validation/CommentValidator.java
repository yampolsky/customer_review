package de.hybris.platform.customerreview.validation;

import java.io.IOException;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.util.StringUtils;

public class CommentValidator implements ConstraintValidator<CommentValidation, String>{

	@Autowired
    private CustomerReviewService customerReviewService;
	
	
	public CommentValidator(CustomerReviewService customerReviewService) {
		super();
		this.customerReviewService = customerReviewService;
	}

	@Override
	public void initialize(CommentValidation arg0) {
	}

	@Override
	public boolean isValid(String comment, ConstraintValidatorContext arg1) {
		try {
			List<String> words = customerReviewService.findCurseWords();
			return !StringUtils.stringContainsItemFromList(comment, words);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
