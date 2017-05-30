package de.hybris.platform.customerreview.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =CountReviewValidator.class)
public @interface CountReviewValidation {
    String message() default "Make sure that 'Rating From' less than 'Rating To'";
	
    Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
