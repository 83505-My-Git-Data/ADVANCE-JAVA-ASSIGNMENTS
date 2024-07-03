package com.sunbeam.dao;

import org.hibernate.*;

import static com.sunbeam.utils.HibernateUtils.*;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao {

	String mesg;

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		String mesg = "adding new product failed";
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			Category category = session.get(Category.class, categoryId);

			if (category != null) {
				// valid category - persistent
				// 4.establish bi dir association between Category n Product
				category.addProduct(newProduct); // stse of the category(persistent) is changed.
				// session.persist
				mesg = "added the product successfully!";
			}

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		}
		return mesg;
	}

	@Override
	public Product getProductDetails(Long productId) {
		// TODO Auto-generated method stub
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		}
		return null;
	}
	
	
	public List<Product> getAllProducts() {
		List<Product> products = null;
		String jpql = "select p from Product p";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return products;
	}

	@Override
	public String purchaseProduct(Long productId, int qty) {
		String mesg = "purchase product failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Product product = session.get(Product.class, productId);
			if (product != null && product.getAvailableQuantity() >= qty) {
				product.setAvailableQuantity(product.getAvailableQuantity() - qty);
				mesg = "product purchased!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}
	
	@Override
	public Product searchByCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String deleteByProduct(String prodName) {
		String msg = "Product Deleted Succesfully!";
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}
}
