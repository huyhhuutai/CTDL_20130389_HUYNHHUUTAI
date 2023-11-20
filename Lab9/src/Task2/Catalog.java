package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
	 private List<Publication> publications;

	    public Catalog() {
	        this.publications = new ArrayList<>();
	    }

	    // Phương thức thêm ấn phẩm
	    public void addPublication(Publication publication) {
	        publications.add(publication);
	    }

	    // Các phương thức khác...

	    // Phương thức sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản
	    public void sortPublications() {
	        // Sắp xếp tăng dần theo tiêu đề
	        Collections.sort(publications, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));

	        // Sau đó, sắp xếp giảm dần theo năm xuất bản
	        Collections.sort(publications, Collections.reverseOrder());
	    }

	    // Phương thức thống kê số lượng ấn phẩm theo năm xuất bản
	    public Map<Integer, Integer> countPublicationsByYear() {
	        Map<Integer, Integer> countMap = new HashMap<>();

	        for (Publication publication : publications) {
	            int year = publication.getPublicationYear();
	            countMap.put(year, countMap.getOrDefault(year, 0) + 1);
	        }

	        return countMap;
	    }
	}

