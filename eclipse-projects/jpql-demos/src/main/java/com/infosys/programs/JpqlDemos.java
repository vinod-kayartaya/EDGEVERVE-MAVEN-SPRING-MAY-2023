package com.infosys.programs;

import com.infosys.entity.Customer;
import com.infosys.entity.Employee;
import com.infosys.entity.Product;
import com.infosys.entity.Shipper;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JpqlDemos {

	static EntityManager em;

	public static void main(String[] args) {
		em = JpaUtil.entityManager();

		demo11();

		em.close();
	}

	static void demo11() {
		String ql = "from Employee";
		TypedQuery<Employee> qry = em.createQuery(ql, Employee.class);
		qry.getResultStream()
			.filter(e->e.getManager()!=null)
			.forEach(e->System.out.printf("%s %s reports to %s %s%n", 
						e.getFirstname(), e.getLastname(), 
						e.getManager().getFirstname(), e.getManager().getLastname()));
	}

	static void demo10() {
		String city = KeyboardUtil.getString("Enter city: ");
		String ql = "select li.orderId, ord.customer.companyName, sum(li.unitPrice*li.quantity*(1-li.discount)) "
				+ "from Order ord join ord.lineItems as li "
				+ "where lower(ord.customer.address.city) = lower(?1) "
				+ "group by li.orderId";
		
		TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
		qry.setParameter(1, city);
		
		for(Object[] r: qry.getResultList()) {
			System.out.printf("%d %s--> $%.2f%n", r[0], r[1], r[2]);
		}
	}

	static void demo9() {
		String ql = "select c.categoryName, count(p) from Category c join c.productList p group by c.categoryName";
		TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
		
		qry.getResultStream()
				.forEach(r -> System.out.printf("%s has %d products%n", r[0], r[1]));
	}

	static void demo8() {
		int pageNum = KeyboardUtil.getInt("Enter page number: ");
		int pageSize = KeyboardUtil.getInt("Enter no.of records per page: ");
		String ql = "from Product order by productId";
		TypedQuery<Product> qry = em.createQuery(ql, Product.class);

		qry.setFirstResult((pageNum - 1) * pageSize); // OFFSET in SQL
		qry.setMaxResults(pageSize); // LIMIT in SQL

		qry.getResultList().forEach(JpqlDemos::printProduct);
	}

	static void demo7() {
		String categoryName = KeyboardUtil.getString("Enter category name to search products: ");
		String ql = "from Product where upper(category.categoryName) = upper(?1)";
		TypedQuery<Product> qry = em.createQuery(ql, Product.class);
		qry.setParameter(1, categoryName);
		qry.getResultList().forEach(JpqlDemos::printProduct);
	}

	static void demo6() {
		String city = KeyboardUtil.getString("Enter city to search customers: ");
		String ql = "from Customer c1 where lower(c1.address.city) = lower(:CUSTOMER_CITY)";
		TypedQuery<Customer> qry = em.createQuery(ql, Customer.class);
		qry.setParameter("CUSTOMER_CITY", city);
		qry.getResultStream()
				.map(c -> "%s (%s, %s)".formatted(c.getCompanyName(), c.getContactName(), c.getContactTitle()))
				.forEach(System.out::println);

	}

	static void demo5a() {
		double min = KeyboardUtil.getDouble("Enter minimum price: ");
		double max = KeyboardUtil.getDouble("Enter maximum price: ");
		String ql = "from Product where unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice"; // positional
																											// parameters
		TypedQuery<Product> qry = em.createQuery(ql, Product.class);
		qry.setParameter("MIN_PRICE", min);
		qry.setParameter("MAX_PRICE", max);

		qry.getResultList().forEach(JpqlDemos::printProduct);
	}

	static void demo5() {
		double min = KeyboardUtil.getDouble("Enter minimum price: ");
		double max = KeyboardUtil.getDouble("Enter maximum price: ");
		String ql = "from Product where unitPrice between ?1 and ?2 order by unitPrice"; // positional parameters
		TypedQuery<Product> qry = em.createQuery(ql, Product.class);
		qry.setParameter(1, min);
		qry.setParameter(2, max);

		qry.getResultList().forEach(JpqlDemos::printProduct);
	}

	static void demo4() {
		String ql = "select productName, unitPrice from Product where unitsInStock=0";
		TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
		System.out.println("Following products are out of stock: ");
		for (Object[] data : qry.getResultList()) {
			System.out.printf("%s --> $%.2f%n", data[0], data[1]);
		}
	}

	static void demo3() {
		String ql = "select productName from Product where unitsInStock=0";
		// productName and unitsInStock are the properties of Product entity
		TypedQuery<String> qry = em.createQuery(ql, String.class);
		System.out.println("Following products are out of stock: ");
		qry.getResultList().forEach(System.out::println);
	}

	static void demo2() {
		// display the list of all discontinued products
		String ql = "from Product where discontinued=1";
		TypedQuery<Product> qry = em.createQuery(ql, Product.class);
		System.out.println("Following products have been discontinued:");
		qry.getResultList().forEach(JpqlDemos::printProduct);

	}

	static void demo1() {
		String ql = "from Shipper"; // notice Shipper is an entity class name and not the table name
		TypedQuery<Shipper> qry = em.createQuery(ql, Shipper.class);
		qry.getResultList().forEach(System.out::println);
	}

	static void printProduct(Product p) {
		System.out.printf("%3d %-35s (%-15s) $%10.2f%n", p.getProductId(), p.getProductName(),
				p.getCategory().getCategoryName(), p.getUnitPrice());
	}

}
