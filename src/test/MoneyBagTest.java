package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Money;
import main.MoneyBag;

@DisplayName("Unit Test MoneyBag")
public class MoneyBagTest {

	private static MoneyBag baseMoney;
	
	@BeforeAll()
	static void beforeAll() throws Exception {
		ArrayList<Money> baseMoneyList = new ArrayList<Money>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Money(10, "EUR"));
				add(new Money(10, "USD"));
			}
		};
		baseMoney = new MoneyBag(baseMoneyList);
	}
	
	@Test
	@DisplayName("normalize ok")
	void testNormalizeOk() throws Exception {
		ArrayList<Money> expectedMoneyList = new ArrayList<Money>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Money(10, "EUR"));
				add(new Money(10, "EUR"));
			}
		};
		MoneyBag moneyExpected = new MoneyBag(expectedMoneyList);
		
		ArrayList<Money> normalize = baseMoney.normalize("EUR");
		
		assertArrayEquals(moneyExpected.getMoneyBag().toArray(), normalize.toArray());
	}
	
	@Test
	@DisplayName("normalize not ok")
	void testNormalizeNotOk() throws Exception {
		assertThrows(Exception.class, () -> {
			 baseMoney.normalize("ABC");
	    }, "currency is not in the possible currency list");
	}
	
	@Test
	@DisplayName("add")
	void testAdd() throws Exception {
		ArrayList<Money> expectedMoneyList = new ArrayList<Money>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Money(10, "EUR"));
				add(new Money(10, "USD"));
				add(new Money(10, "EUR"));
			}
		};
		MoneyBag moneyExpected = new MoneyBag(expectedMoneyList);
		
		ArrayList<Money> result = baseMoney.add(new Money(10, "EUR"), baseMoney.getMoneyBag());
		
		assertArrayEquals(moneyExpected.getMoneyBag().toArray(), result.toArray());
	}
	
	@Test
	@DisplayName("subb")
	void testSubb() throws Exception {
		ArrayList<Money> expectedMoneyList = new ArrayList<Money>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Money(10, "USD"));
			}
		};
		MoneyBag moneyExpected = new MoneyBag(expectedMoneyList);
		
		ArrayList<Money> result = baseMoney.subb(new Money(10, "EUR"), baseMoney.getMoneyBag());

		assertArrayEquals(moneyExpected.getMoneyBag().toArray(), result.toArray());
	}
}
