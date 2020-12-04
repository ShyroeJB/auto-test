package main;

import java.util.ArrayList;

public class MoneyBag {
	private ArrayList<Money> moneys;
	private static ArrayList<String> possibleCurrency= new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("EUR");
			add("USD");
			add("CHF");
			add("GBP");
		}
	};
	
	public MoneyBag() {
		moneys = new ArrayList<Money>();
	}
	
	public MoneyBag(ArrayList<Money> _moneys) {
		moneys = new ArrayList<Money>();
		moneys = _moneys;
	}
	
	public ArrayList<Money> getMoneyBag() {
		return moneys;
	}
	
	public ArrayList<Money> normalize(String currency) throws Exception {
		if(!possibleCurrency.contains(currency)) {
			throw new Exception("currency is not in the possible currency list");
		}
		
		ArrayList<Money> normaizeMoneys = new ArrayList<Money>();
		for( Money value : moneys ) {
			normaizeMoneys.add(new Money(value.getAmount(), currency));
        }
		
		return normaizeMoneys;
	}
	
	public ArrayList<Money> add(Money newMoney, ArrayList<Money> list) {
		list.add(newMoney);
		return list;
	}
	
	public ArrayList<Money> subb(Money oldMoney, ArrayList<Money> list) {
		list.remove(oldMoney);
		return list;
	}
}
