package com.infosys.programs;

import com.infosys.entity.LineItem;
import com.infosys.entity.Order;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;

public class GetOneOrder {

	public static void main(String[] args) {
		
		try(EntityManager em = JpaUtil.entityManager()){
			
			int orderId = KeyboardUtil.getInt("Enter order id to search: ");
			Order ord1 = em.find(Order.class, orderId);
			
			if(ord1==null) {
				System.out.println("Invalid order id!");
				return;
			}
			
			System.out.printf("Order ID         : %d%n", ord1.getOrderId());
			System.out.printf("Ordered date     : %s%n", ord1.getOrderDate());
			System.out.printf("Required date    : %s%n", ord1.getRequiredDate());
			System.out.printf("Shipped date     : %s%n", ord1.getShippedDate());
			System.out.printf("Customer         : %s (%s - %s)%n", 
					ord1.getCustomer().getCompanyName(),
					ord1.getCustomer().getContactName(),
					ord1.getCustomer().getContactTitle());
			System.out.printf("Employee         : %s%s %s (%s)%n", 
					ord1.getEmployee().getTitleOfCourtesy(),
					ord1.getEmployee().getFirstname(),
					ord1.getEmployee().getLastname(),
					ord1.getEmployee().getTitle());
			System.out.printf("Frieght charges  : $%.2f%n", ord1.getFreight());
			System.out.printf("Shipped by       : %s (%s)%n", 
					ord1.getShippedBy().getCompanyName(), 
					ord1.getShippedBy().getPhone());
			System.out.printf("Shipped to       : %s%n", ord1.getShipToName());
			System.out.printf("                   %s%n", ord1.getShipToAddress().getStreetAddress());
			System.out.printf("                   %s%n", ord1.getShipToAddress().getCity());
			System.out.printf("                   %s%n", ord1.getShipToAddress().getRegion());
			System.out.printf("                   %s%n", ord1.getShipToAddress().getPostalCode());
			System.out.printf("                   %s%n", ord1.getShipToAddress().getCountry());
			
			System.out.println();
			System.out.println("Products in this order are: ");
			System.out.printf("%-35s %10s %5s %10s %10s%n", "Name", "Price", "Qty", "Discount", "Amount");
			System.out.println("--------------------------------------------------------------------------");
			for(LineItem li: ord1.getLineItems()) {
				System.out.printf("%-35s %10.2f %5d %10.2f %10.2f%n",
						li.getProductId(), // to be changed to product name
						li.getUnitPrice(),
						li.getQuantity(),
						li.getDiscount(),
						li.getUnitPrice()*li.getQuantity()*(1-li.getDiscount()));
						
			}
			System.out.println("--------------------------------------------------------------------------");
			
			
		}// em.close()
		
	}
}
