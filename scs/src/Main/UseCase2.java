package Main;

import Bank.Account;
import Bank.Customer;
import Bank.POS;
import Item.ConcretePriceVisitor;
import Item.ConcreteWeightVisitor;
import Item.LineItem;
import SupermarketData.Address;
import SupermarketData.EuclideanDistance;

import java.util.ArrayList;
import java.util.List;

public class UseCase2 {
	public static void main(String[] args) {
		System.out.println("---------- Use Case 2: Debit account & Refused payment -----------");

		// Initiate the supermarket system
		SCSController scsController = new SCSController(new Address(0.0, 0.0), new EuclideanDistance(), new ConcretePriceVisitor(), new ConcreteWeightVisitor());

		// Add items to the supermarket
		scsController.addUnitPricedItem("Television", "Electronic", 500.0, 30.0);
		scsController.addUnitPricedItem("Milk", "Dairy", 1.5, 1.0);
		scsController.addWeightPricedItem("Apple" , "Fruits", 1.5);
		scsController.addWeightPricedItem("Potato", "Vegetables", 0.7);

		// Add a customer
		scsController.addDebitAccount(800.0); // Create their account
		Account account = scsController.getAccount(0); // Get their account
		scsController.addCustomerData("Theo", "Raine", scsController.getCustomerPlan(2), new Address(7.0, 10.0)); // Create a customer data that uses the Prime Plan
		scsController.addCustomer(account.createCard(), 0); // Add them to the list

		Customer customer = scsController.getCustomer(0); // Get the customer
		scsController.payAnnualFee(customer); // Pay the fee of the plan

		// Create a cart
		List<LineItem> cart = new ArrayList<>();
		scsController.addUnitPricedLineItemToCart(cart, 0, 2); // Add 2 televisions to the cart
		scsController.addUnitPricedLineItemToCart(cart, 1, 5); // Add 5 milk bottles to the cart
		scsController.addWeightPricedLineItemToCart(cart, 2, 2.0); // Add 3.0kg of apples to the cart
		scsController.addWeightPricedLineItemToCart(cart, 3, 1.2); // Add 1.2kg of potatoes to the cart

		// Get the total price with the cash register (and print them) without delivery fee
		CashRegister cashRegister = scsController.getCashRegister();
		double totalPrice = cashRegister.scanCart(cart, customer.getCustomerDataId(), false);

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
