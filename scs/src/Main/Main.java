package Main;

import Bank.Account;
import Bank.Card;
import Bank.CreditAccount;
import Item.ConcretePriceVisitor;
import Item.ConcreteWeightVisitor;
import Item.UnitPricedItem;
import SupermarketData.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Global system
		SCSController scsController = new SCSController(new Address(0.0, 0.0), new ManhattanDistance(), new ConcretePriceVisitor(), new ConcreteWeightVisitor());

		// Bank system
		scsController.addCreditAccount(0.0, 50.0);
		Account account = scsController.getAccount(0);
		Card card = account.createCard();

		CustomerData customerData = new CustomerData(
				"Bob",
				"Boop",
				scsController.getCustomerPlan(0),
				new Address(3.0, 14.0)
		);

		scsController.addCustomer(card, customerData.getId());

		System.out.println(scsController.getCustomer(0));
		// Supermarket system

		// Use case
		System.out.println("Hello World!");
		UnitPricedItem cookie = new UnitPricedItem("cookie", "sweets", 1.0, 1.0);
		UnitPricedItem cookie2 = new UnitPricedItem("cookie", "sweets", 1.0, 1.0);
		UnitPricedItem cookie3 = new UnitPricedItem("cookie", "sweets", 1.0, 1.0);
		System.out.println(cookie3.getId());

		CreditAccount creditAccount = new CreditAccount(0.0, 1000.0);
		System.out.println(creditAccount.getId());
	}

}
