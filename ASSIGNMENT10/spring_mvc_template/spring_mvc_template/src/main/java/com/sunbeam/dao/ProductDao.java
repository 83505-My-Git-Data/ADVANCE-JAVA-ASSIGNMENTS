package com.sunbeam.dao;

import java.util.List;
import com.sunbeam.entites.Product;


public interface ProductDao {
//add a product

List<Product> getProductsByPrice(Double max,Double min);

}
