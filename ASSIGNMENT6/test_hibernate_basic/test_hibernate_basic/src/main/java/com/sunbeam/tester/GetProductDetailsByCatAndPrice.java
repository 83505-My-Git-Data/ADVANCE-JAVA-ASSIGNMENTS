package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import static com.sunbeam.utils.HibernateUtils.getFactory;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

public class GetProductDetailsByCatAndPrice {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in);)
		{
			ProductDao pd = new ProductDaoImpl();
			System.out.println("Enter begin end price n category");
			pd.getProductDetailsByCatAndPrice(Category.valueOf(sc.next().toUpperCase()),
					sc.nextDouble(), sc.nextDouble()).forEach(System.out::println);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
