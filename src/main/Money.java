package main;

public class Money {
	private int amount;
	private String currency;
	
	public Money(int _amount, String _currency) {
		setAmount(_amount);
		setCurrency(_currency);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public Money add (Money m) throws Exception {
		if(m.getCurrency() != getCurrency()) {
			throw new Exception("currency not equals");
		}
		return new Money(getAmount() + m.getAmount(), getCurrency());
	}
	
	public Money add (int amout, String currency) throws Exception {
		if(currency != getCurrency()) {
			throw new Exception("currency not equals");
		}
		return new Money(getAmount() + amout, currency);
	}
}
