package de.hybris.platform.customerreview.modelui;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.hybris.platform.customerreview.model.Product;
import de.hybris.platform.customerreview.validation.CommentValidation;

public class CommentForm {

    @NotNull
    @Size(min=2, max=30)
    private String customer;

    @NotNull
    private Product product;
    
    @NotNull
    @Min(1)
    @Max(9)
    private Integer rating;

    @NotNull
    @Size(min=2, max=999)
    @CommentValidation
    private String comment;
    
    
    
    public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public String toString() {
        return "(customer: " + this.customer + ", product: " + this.product + ", rating: " + this.rating + ", comment: " + this.comment + ")";
    }
}
