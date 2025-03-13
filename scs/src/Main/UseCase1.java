package Main;

import Bank.*;
import Item.*;
import SupermarketData.*;

import java.util.ArrayList;
import java.util.List;

public class UseCase1 {
	public static void main(String[] args) {
		System.out.println("---------- Use Case 1: Credit account & Successful payment -----------");

		// Initiate the supermarket system
		SCSController scsController = new SCSController(new Address(0.0, 0.0), new ManhattanDistance(), new ConcretePriceVisitor(), new ConcreteWeightVisitor());

		// Add items to the supermarket
		scsController.addUnitPricedItem("Television", "Electronic", 500.0, 30.0);
		scsController.addUnitPricedItem("Milk", "Dairy", 1.5, 1.0);
		scsController.addWeightPricedItem("Apple" , "Fruits", 1.5);
		scsController.addWeightPricedItem("Potato", "Vegetables", 0.7);

		// Add a customer
		scsController.addCreditAccount(1000.0, 600.0); // Create their account
		Account account = scsController.getAccount(0); // Get their account
		scsController.addCustomerData("Madeline", "Raine", scsController.getCustomerPlan(1), new Address(3.0, 14.0)); // Create a customer data that uses the Prime Plan
		scsController.addCustomer(account.createCard(), 0); // Add them to the list

		Customer customer = scsController.getCustomer(0); // Get the customer

		// Create a cart
		List<LineItem> cart = new ArrayList<>();
		scsController.addUnitPricedLineItemToCart(cart, 0, 1); // Add one television to the cart
		scsController.addWeightPricedLineItemToCart(cart, 2, 3.0); // Add 3.0kg of apples to the cart
		scsController.addWeightPricedLineItemToCart(cart, 3, 2.5); // Add 2.5kg of potatoes to the cart

		// Get the total price with the cash register (and print them), including delivery fee and the customer plan
		CashRegister cashRegister = scsController.getCashRegister();
		double totalPrice = cashRegister.scanCart(cart, customer.getCustomerDataId(), true);

		// Customer initiates the payment process
		POS pos = scsController.getPOS();
		customer.insertCard(pos); // Customer inserts their card in the POS (then the POS checks the card)
		customer.typePIN(pos, customer.getCard().getPin()); // Customer types the PIN of their card (then the POS checks the PIN)

		// POS asks authorization to its TAS
		if (pos.askAuthorization()) {
			// POS initiates the transaction. TAS and Bank communicate to perform (or not) the transaction
			pos.startTransaction(totalPrice);
		}

		// Finally, the POS ejects the card
		pos.ejectCard();
	}
}
