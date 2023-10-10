package Task2;


import java.util.Arrays;

public class OrderItem {
	private OrderItem[] items;

	// Constructor to initialize the Order with an array of OrderItems
	public Order(OrderItem[] items) {
		this.items = items;
	}

	// Method to calculate the total cost of the order
	public double cost() {
		double totalCost = 0.0;
		for (OrderItem item : items) {
			totalCost += item.getSubtotal();
		}
		return totalCost;
	}

	// Method to check if the order contains a specific product
	public boolean contains(Product p) {
		// Sort the items array based on the product ID for binary search
		Arrays.sort(items, (a, b) -> a.getProduct().getId().compareTo(b.getProduct().getId()));

		// Use binary search to find the product
		int left = 0;
		int right = items.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			Product midProduct = items[mid].getProduct();
			int comparisonResult = p.getId().compareTo(midProduct.getId());

			if (comparisonResult == 0) {
				// Product found
				return true;
			} else if (comparisonResult < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		// Product not found
		return false;
	}

	// Method to filter products based on the given type using linear search
	public Product[] filter(String type) {
		int count = 0;
		for (OrderItem item : items) {
			if (item.getProduct().getType().equals(type)) {
				count++;
			}
		}

		Product[] filteredProducts = new Product[count];
		int index = 0;
		for (OrderItem item : items) {
			if (item.getProduct().getType().equals(type)) {
				filteredProducts[index] = item.getProduct();
				index++;
			}
		}

		return filteredProducts;
	}
}
