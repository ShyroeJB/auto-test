package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Money;

@DisplayName("Unit Test Money")
public class MoneyTest {

	private static Money baseMoney;
	
	@BeforeAll()
	static void beforeAll() throws Exception {
		baseMoney = new Money(10, "EUR");
	}
	
	@Test
	@DisplayName("Test Add Money with data Ok")
	void testAddMoneyWithDataOk() throws Exception {
		Money newAmount = baseMoney.add(10, "EUR");
		
		Money expected = new Money(20, "EUR");
		assertEquals(expected.getAmount(), newAmount.getAmount());
		assertEquals(expected.getCurrency(), newAmount.getCurrency());
	}
	
	@Test
	@DisplayName("Test Add Money with data negative Ok")
	void testAddMoneyWithDataNegativeOk() throws Exception {
		Money newAmount = baseMoney.add(-5, "EUR");
		
		Money expected = new Money(5, "EUR");
		assertEquals(expected.getAmount(), newAmount.getAmount());
		assertEquals(expected.getCurrency(), newAmount.getCurrency());
	}
	
	@Test
	@DisplayName("Test Add Money with data not Ok")
	void testAddMoneyWithDataNotOk() {
		assertThrows(Exception.class, () -> {
			baseMoney.add(10, "USD");
	    }, "currency not equal");
	}
	
	@Test
	@DisplayName("Test Add Money with money Ok")
	void testAddMoneyWithMoneyOk() throws Exception {
		Money newAmount = baseMoney.add(new Money(10, "EUR"));
		
		Money expected = new Money(20, "EUR");
		assertEquals(expected, newAmount);
	}
	
	@Test
	@DisplayName("Test Add Money with money not Ok")
	void testAddMoneyWithMoneyNotOk() {
		assertThrows(Exception.class, () -> {
			baseMoney.add(new Money(10, "USD"));
	    }, "currency not equal");
	}
	
	@Test
	@DisplayName("Test Add Money data cunrrency failded")
	void testAddMoneyDataCurrencyFailed() {
		assertThrows(Exception.class, () -> {
			baseMoney.add(10, "ABC");
	    }, "currency is not in the possible currency list");
	}
	
	@Test
	@DisplayName("Test Add Money cunrrency failded")
	void testAddMoneyCurrencyFailed() {
		assertThrows(Exception.class, () -> {
			baseMoney.add(new Money(10, "ABC"));
	    }, "currency is not in the possible currency list");
	}
	
	@Test
	@DisplayName("Test Add Money data amount negative failed")
	void testAddMoneyDataAmountNegative() {
		assertThrows(Exception.class, () -> {
			baseMoney.add(-20, "EUR");
	    }, "amount is not positive");
	}
	
	@Test
	@DisplayName("Test Add Money amount negative failed")
	void testAddMoneyAmountNegative() {
		assertThrows(Exception.class, () -> {
			baseMoney.add(new Money(-20, "EUR"));
	    }, "amount is not positive");
	}
	
}
