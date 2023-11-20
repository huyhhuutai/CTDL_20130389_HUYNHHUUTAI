package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReferenceBook extends Publication {
    private String field;
    private List<Chapter> chapters;

    public ReferenceBook(String title, int numberOfPages, int publicationYear, String author, double price,
                         String field) {
        super(title, numberOfPages, publicationYear, author, price);
        this.field = field;
        this.chapters = new ArrayList<>();
    }

    @Override
    public String getType() {
        return "Reference Book";
    }

    // Phương thức thêm chương sách
    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    // Phương thức tìm chương sách nhiều trang nhất
    public Chapter findLongestChapter() {
        if (chapters.isEmpty()) {
            return null;
        }

        Chapter longestChapter = chapters.get(0);
        for (Chapter chapter : chapters) {
            if (chapter.getNumberOfPages() > longestChapter.getNumberOfPages()) {
                longestChapter = chapter;
            }
        }

        return longestChapter;
    }

    @Override
    public String toString() {
        return "ReferenceBook{" + "field='" + field + '\'' + super.toString() + ", chapters=" + chapters + '}';
    }

    public void sortPublications(List<Publication> publications) {
        // Sắp xếp tăng dần theo tiêu đề
        Collections.sort(publications, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));

        // Sau đó, sắp xếp giảm dần theo năm xuất bản
        Collections.sort(publications, Collections.reverseOrder());
    }

    // Phương thức thống kê số lượng ấn phẩm theo năm xuất bản
    public Map<Integer, Integer> countPublicationsByYear(List<Publication> publications) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Publication publication : publications) {
            int year = publication.getPublicationYear();
            countMap.put(year, countMap.getOrDefault(year, 0) + 1);
        }

        return countMap;
    }
}
