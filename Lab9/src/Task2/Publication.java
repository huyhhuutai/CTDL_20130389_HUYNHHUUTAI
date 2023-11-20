package Task2;

public class Publication {
	private String title;
	private int numberOfPages;
	private int publicationYear;
	private String author;
	private double price;

	public Publication(String title, int numberOfPages, int publicationYear, String author, double price) {
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.publicationYear = publicationYear;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	// Phương thức xác định loại ấn phẩm
	public String getType() {
		return "Unknown";
	}

	// Phương thức kiểm tra ấn phẩm có thời gian xuất bản cách đây 10 năm hay không
	public boolean isPublishedLastDecade() {
		int currentYear = 2021; // Năm hiện tại, có thể thay đổi theo thời điểm chạy chương trình
		return (currentYear - publicationYear) <= 10;
	}

	// Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
	public boolean hasSameTypeAndAuthor(Publication other) {
		return this.getType().equals(other.getType()) && this.author.equals(other.author);
	}

	@Override
	public String toString() {
		return "Publication{" + "title='" + title + '\'' + ", numberOfPages=" + numberOfPages + ", publicationYear="
				+ publicationYear + ", author='" + author + '\'' + ", price=" + price + '}';
	}
}
