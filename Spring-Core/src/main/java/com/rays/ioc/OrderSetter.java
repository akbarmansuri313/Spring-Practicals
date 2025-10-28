package com.rays.ioc;

public class OrderSetter {
	
	private Payment payment;
	private Inventory inventory;
	
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void bookATicket(int item) {
		
		int price = 10;
		
		double totalAmount = item * price ;
		
		double updateBalance = payment.makePayment(totalAmount);
		
		double updateStock = inventory.sold(item);
		
		System.out.println("total amount paid : " + totalAmount);
		System.out.println("updated balance : " + updateBalance);
		System.out.println("updated stock : " + updateStock);
		System.out.println("total book item : " + item);
	}


}
