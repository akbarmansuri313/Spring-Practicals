package com.rays.ioc;

public class OrderConstructor {
	
	private Payment payment;
	private Inventory inventory;
	
	public OrderConstructor(Payment payment, Inventory inventory) {
		
		this.payment = payment;
		this.inventory = inventory;
	}
		public void bookATicket(int items) {
			
			int price = 150;
			
			double totalAmount = items * price;
			
			double updateBalnce  = payment.makePayment(totalAmount);
			
			int updateStock = inventory.sold(items);
			
			System.out.println("Booked Ticket");
			System.out.println("Total Amount Paid :" + totalAmount);
			System.out.println("Remaning Balance :" + updateBalnce);
			System.out.println("Updated Stock " + updateStock);
			
			
		}
		
	

}
