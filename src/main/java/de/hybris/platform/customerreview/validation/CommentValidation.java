package de.hybris.platform.customerreview.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommentValidator.class)
public @interface CommentValidation {
	
	String message() default "Invalid comment";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
