package Task2;



public class TeskCompOder {
	public static void main(String[] args) {
		// Create some products
		Product product1 = new Product("1", "Product 1", 10.0, "Type A");
		Product product2 = new Product("2", "Product 2", 20.0, "Type B");
		Product product3 = new Product("3", "Product 3", 30.0, "Type A");

		// Create some order items
		OrderItem item1 = new OrderItem(product1, 2);
		OrderItem item2 = new OrderItem(product2, 1);
		OrderItem item3 = new OrderItem(product3, 3);

		// Create an array of order items
		OrderItem[] orderItems = { item1, item2, item3 };

		// Create an order
		OrderItem order = new OrderItem(orderItems);

		// Calculate the total cost of the order
		double totalCost = order.cost();
		System.out.println("Total Cost of the Order: $" + totalCost);

		// Check if the order contains a specific product
		boolean containsProduct = order.contains(product2);
		System.out.println("Order contains Product 2: " + containsProduct);

		// Filter products by type
		String filterType = "Type A";
		Product[] filteredProducts = order.filter(filterType);
		System.out.println("Products of Type " + filterType + " in the Order:");
		for (Product product : filteredProducts) {
			System.out.println(product.getName());
		}
	}

}
