package de.hybris.platform.customerreview.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product_review")
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonBackReference
	Product product;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_comment_id")
	@JsonBackReference
	CustomerComment customerComment;
	
	@Column(name="rating")
	int rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerComment getCustomerComment() {
		return customerComment;
	}

	public void setCustomerComment(CustomerComment customerComment) {
		this.customerComment = customerComment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
