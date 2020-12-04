package main;

import java.util.ArrayList;

public class Money {
	private int amount;
	private String currency;
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
	
	public Money(int _amount, String _currency) throws Exception {
		if(_amount < 0) {
			throw new Exception("amount is not positive");
		}
		if(!possibleCurrency.contains(_currency)) {
			throw new Exception("currency is not in the possible currency list");
		}
		setAmount(_amount);
		setCurrency(_currency);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) throws Exception {
		if(amount < 0) {
			throw new Exception("amount is not positive");
		}
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) throws Exception {
		if(!possibleCurrency.contains(currency)) {
			throw new Exception("currency is not in the possible currency list");
		}
		this.currency = currency;
	}
	
	public Money add (Money m) throws Exception {
		int additionAmount = getAmount() + m.getAmount();
		
		if(additionAmount < 0) {
			throw new Exception("amount is not positive");
		}
		if(!possibleCurrency.contains(m.getCurrency())) {
			throw new Exception("currency is not in the possible currency list");
		}
		if(m.getCurrency() != getCurrency()) {
			throw new Exception("currency not equals");
		}
		
		return new Money(additionAmount, getCurrency());
	}
	
	public Money add (int amout, String currency) throws Exception {
		int additionAmount = getAmount() + amout;
		
		if(additionAmount < 0) {
			throw new Exception("amount is not positive");
		}
		if(!possibleCurrency.contains(currency)) {
			throw new Exception("currency is not in the possible currency list");
		}
		if(currency != getCurrency()) {
			throw new Exception("currency not equals");
		}
		
		return new Money(additionAmount, currency);
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof Money)
        {
        	Money temp = (Money) obj;
            if(this.getAmount() == temp.getAmount() && this.getCurrency().equals(temp.getCurrency()))
                return true;
        }
        return false;
    }
}
