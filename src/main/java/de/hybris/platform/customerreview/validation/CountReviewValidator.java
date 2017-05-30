package de.hybris.platform.customerreview.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.hybris.platform.customerreview.modelui.CountReviewForm;

public class CountReviewValidator implements ConstraintValidator<CountReviewValidation, CountReviewForm> {

	@Override
	public void initialize(CountReviewValidation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(CountReviewForm form, ConstraintValidatorContext arg1) {
		return (form.getRatingFrom()<form.getRatingTo());
	}

}
