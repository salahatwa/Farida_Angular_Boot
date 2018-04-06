package com.igi.utils;

public enum BusinessServiceCategory {
	Subscriber(0), Agent(1), Wallet(2), Person(3), Merchants(4), Utilities(5), Government(6), PSP_Teller(7), HUB(
			8), PARTNER(9);

	private final int id;

	BusinessServiceCategory(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}