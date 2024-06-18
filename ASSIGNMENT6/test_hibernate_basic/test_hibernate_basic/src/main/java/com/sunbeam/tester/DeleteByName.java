package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class DeleteByName {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in))
		{
			ProductDao pd = new ProductDaoImpl();
			System.out.println("Enter the Name of the Product to Delete: ");
			System.out.println(pd.deleteByName(sc.next())); 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
