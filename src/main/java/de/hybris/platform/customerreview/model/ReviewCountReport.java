package de.hybris.platform.customerreview.model;

public class ReviewCountReport {
	
	Long productId;
	String productDesc;
	Long reviewCount;
	
	public ReviewCountReport()
	{
		super();
	}
	
	public ReviewCountReport(Long productId, String productDesc, Long reviewCount) {
		super();
		this.productId = productId;
		this.productDesc = productDesc;
		this.reviewCount = reviewCount;
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Long getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Long reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	
	

}
