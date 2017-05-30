package de.hybris.platform.customerreview.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.hybris.platform.customerreview.dao.CommentJpaRepository;
import de.hybris.platform.customerreview.dao.CustomerJpaRepository;
import de.hybris.platform.customerreview.dao.CustomerReviewDao;
import de.hybris.platform.customerreview.dao.ProductJpaRepository;
import de.hybris.platform.customerreview.dao.ReviewRepository;
import de.hybris.platform.customerreview.model.Customer;
import de.hybris.platform.customerreview.model.CustomerComment;
import de.hybris.platform.customerreview.model.Product;
import de.hybris.platform.customerreview.model.Review;
import de.hybris.platform.customerreview.model.ReviewCountReport;

@Repository
public class DefaultCustomerReviewDao implements CustomerReviewDao {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private CustomerJpaRepository customerJpaRepository;
	
	@Autowired
	private CommentJpaRepository commentJpaRepository;
	
	@Autowired
	ProductJpaRepository productJpaRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Review review) {
		entityManager.persist(review);
	}

	@Override
	public void update(Review review) {
		entityManager.merge(review);
	}

	@Override
	public Review getReviewById(int id) {
		return entityManager.find(Review.class, id);
	}

	@Override
	public void delete(int id) {
		Review review = getReviewById(id);
		if (review != null) {
			entityManager.remove(review);
		}
	}

	@Override
	public List<Review> findReview() {
		return reviewRepository.findAll();
		/*
		//TypedQuery<Review> tq = entityManager.createQuery("select review from Review", Review.class);
		TypedQuery<Review> tq = entityManager.createQuery("from Review", Review.class);
		List<Review> reviews = tq.getResultList();
		return reviews;
		*/
	}
	
	@Override
	public List<Customer> findCustomers() throws IOException {
		return customerJpaRepository.findAll();
	}

	@Override
	public List<CustomerComment> findComments() throws IOException {
		List<CustomerComment> comments = commentJpaRepository.findAll();
		return comments;
	}
	
	@Override
	public List<String> findCurseWords() throws IOException {
		TypedQuery<String> tq = entityManager.createQuery("select word from CurseWord", String.class);
		List<String> words = tq.getResultList();
		return words;
	}

	@Override
	public List<Product> findProducts() {
		return productJpaRepository.findAll();
	}

	@Override
	public List<String> findProductsDesc() {
		TypedQuery<String> tq = entityManager.createQuery("select description from Product", String.class);
		List<String> productDescs = tq.getResultList();
		return productDescs;
	}

	@Override
	public Customer findCustomerByName(String name) {
		TypedQuery<Customer> tq = entityManager.createQuery("select c from Customer c where c.name= ?1", Customer.class);
		tq.setParameter(1, name);
		List<Customer> customers = tq.getResultList();
		return customers!=null && customers.size()>0 ?customers.get(0) : null;
	}
	
	@Override
	public List<ReviewCountReport> getReviewCountReport(Integer ratingFrom, Integer ratingTo)
	{
		/*
		SELECT p.ID , p.DESCRIPTION, count(pr.id)
		FROM PRODUCT_REVIEW pr
		LEFT JOIN PRODUCT  p on p.id=pr.PRODUCT_ID
		WHERE
		pr.RATING >=1 AND pr.RATING <=6
		GROUP BY pr.PRODUCT_ID;
		*/
		String hql =  " select p.id, p.description, count(r.id) " 
					+ " from Review r "
					+ " inner join r.product p "
					+ " where r.rating>=?1 and r.rating<=?2 "
					+ " group by p.id";
		/*		
		TypedQuery<ReviewCountReport> tq = entityManager.createQuery(hql, ReviewCountReport.class);
		tq.setParameter(1, ratingFrom);
		tq.setParameter(2, ratingTo);
		List<ReviewCountReport> report = tq.getResultList();
		*/

		Query q = entityManager.createQuery(hql);
		q.setParameter(1, ratingFrom);
		q.setParameter(2, ratingTo);
		@SuppressWarnings("unchecked")
		List<Object[]> listResult = q.getResultList();
		List<ReviewCountReport>report = new ArrayList<>();
		for(Object[] row : listResult)
		{
			Long productId = (Long) row[0];
			String productDesc = (String) row[1];
			Long reviewCount = (Long) row[2];
			report.add(new ReviewCountReport(productId, productDesc, reviewCount));
		}
		return report;
	}
}
