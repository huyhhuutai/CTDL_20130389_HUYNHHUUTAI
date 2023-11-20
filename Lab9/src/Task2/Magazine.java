package Task2;

class Magazine extends Publication {
	private String magazineName;

	public Magazine(String title, int numberOfPages, int publicationYear, String author, double price,
			String magazineName) {
		super(title, numberOfPages, publicationYear, author, price);
		this.magazineName = magazineName;
	}

	@Override
	public String getType() {
		return "Magazine";
	}

	public String getMagazineName() {
		return magazineName;
	}

	@Override
	public String toString() {
		return "Magazine{" + "magazineName='" + magazineName + '\'' + super.toString() + '}';
	}
}