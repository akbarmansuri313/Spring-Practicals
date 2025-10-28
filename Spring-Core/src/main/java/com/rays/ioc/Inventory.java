package com.rays.ioc;

public class Inventory {
	
	 int stock = 0;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	 
	public int sold (int quantity) {
		
		 stock -= quantity;
		 return stock;
	}

}
