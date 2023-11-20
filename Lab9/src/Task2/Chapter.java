package Task2;

public class Chapter {
	private String title;
    private int numberOfPages;

    public Chapter(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages1() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
    
    // Phương thức mới thêm vào
    public int getNumberOfPages() {
        return numberOfPages;
    }
}
