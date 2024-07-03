package com.sunbeam.dao;
import java.util.List;

import org.hibernate.SessionFactory;

import com.sunbeam.entites.Product;


public class ProductDaoImpl implements ProductDao {

private SessionFactory factory;
@Override
public List<Product> getProductsByPrice(Double max, Double min) {
	String jpql ="select p from Product p where price between :min and :max1";
	return factory.getCurrentSession().createQuery(jpql, com.sunbeam.entites.Product.class).setParameter("min",min).setParameter("max",max).getResultList();
}
	

}
