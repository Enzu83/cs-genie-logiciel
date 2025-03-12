public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		UnitPricedItem cookie = new UnitPricedItem("cookie", 1.0, 1.0);
		UnitPricedItem cookie2 = new UnitPricedItem("cookie", 1.0, 1.0);
		UnitPricedItem cookie3 = new UnitPricedItem("cookie", 1.0, 1.0);
		System.out.println(cookie3.getId());

		CreditAccount account = new CreditAccount(0.0, 1000.0);

		System.out.println(account.getId());
	}

}
