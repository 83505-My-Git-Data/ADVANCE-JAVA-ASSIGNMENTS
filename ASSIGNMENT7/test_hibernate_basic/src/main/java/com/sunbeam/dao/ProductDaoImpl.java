package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.*;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getProductDetailsById(long productId) {
		Product product = null;
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, productId);

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		}
		return product;
	}

	@Override
	public String insertData(Product product) {
		String msg = "Product Registration Failed!";
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			Serializable productId = session.save(product);

			tx.commit();
			msg = "Product registered successfully , with ID" + productId;

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		}
		return msg;
	}

	@Override
	public List<Product> getProductDetailsByCatAndPrice(Category category, double startPrice, double endPrice) {

		String jpql ="Select p from Product p where price between :start and :end and p.c = :cat";
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql,Product.class)
					.setParameter("start",startPrice)
					.setParameter("end",endPrice)
					.setParameter("cat",category).getResultList();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return products;
	}

	@Override
	public String applyDiscountByCat(double discount, Category category) {
		int count =0;
		String msg = "Applying Discount Failed!";
		String jpql="update Product p set p.price=p.price-:disc where p.category=:cat";
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql).setParameter("disc", discount).setParameter("cat", category)
					.executeUpdate();
			
			tx.commit();/*
						 * session.flush() -> dirty chking -> entity marked for removal -> DML : delete
						 * , session.close() -> L1 cache is destroyed n cn rets to DBCP user - TRANSIENT
						 */
			msg ="Applied Discount to Price - " + rows;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return msg;
	}
	
	@Override
	public String purchaseProduct(Long ProductId, int qty) {
		String mesg = "purchase product failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Product product = session.get(Product.class, ProductId);
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
	public String deleteByName(String productName) {
		String mesg = "product delete Failed !";
		String jpql = "select p from Product p where p.name=:nm";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Product product = session.createQuery(jpql, Product.class).setParameter("nm", productName).getSingleResult();
			session.delete(product);
			mesg = "Product Deleted Succesfully!";
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
