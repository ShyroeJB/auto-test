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
	static void beforeAll() {
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
		assertEquals(expected.getAmount(), newAmount.getAmount());
		assertEquals(expected.getCurrency(), newAmount.getCurrency());
	}
	
	@Test
	@DisplayName("Test Add Money with money not Ok")
	void testAddMoneyWithMoneyNotOk() throws Exception {
		assertThrows(Exception.class, () -> {
			baseMoney.add(new Money(10, "USD"));
	    }, "currency not equal");
	}
	
}
