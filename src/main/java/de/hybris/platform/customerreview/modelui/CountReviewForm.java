package de.hybris.platform.customerreview.modelui;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import de.hybris.platform.customerreview.validation.CountReviewValidation;

@CountReviewValidation
public class CountReviewForm {

	@NotNull
    @Min(1)
    @Max(9)
	int ratingFrom;
	
	@NotNull
    @Min(1)
    @Max(9)
	int ratingTo;

	public int getRatingFrom() {
		return ratingFrom;
	}

	public void setRatingFrom(int ratingFrom) {
		this.ratingFrom = ratingFrom;
	}

	public int getRatingTo() {
		return ratingTo;
	}

	public void setRatingTo(int ratingTo) {
		this.ratingTo = ratingTo;
	}
	
}
