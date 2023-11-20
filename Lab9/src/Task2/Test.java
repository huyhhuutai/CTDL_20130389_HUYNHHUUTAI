package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		// Tạo đối tượng ReferenceBook
		ReferenceBook referenceBook = new ReferenceBook("Java Programming", 500, 2020, "John Doe", 30.0, "Programming");

		// Thêm chương sách vào ReferenceBook
		referenceBook.addChapter(new Chapter("Introduction", 20));
		referenceBook.addChapter(new Chapter("Data Types", 50));

		// Hiển thị thông tin về ReferenceBook
		System.out.println(referenceBook);

		// Tìm chương sách nhiều trang nhất
		Chapter longestChapter = referenceBook.findLongestChapter();
		if (longestChapter != null) {
			System.out.println("Chương sách nhiều trang nhất: " + longestChapter.getTitle() + ", Số trang: "
					+ longestChapter.getNumberOfPages());
		} else {
			System.out.println("ReferenceBook không có chương sách.");
		}

		// Tạo danh sách các ấn phẩm
		List<Publication> publications = new ArrayList<>();
		publications.add(referenceBook);

		// Tạo đối tượng ReferenceBook khác
		ReferenceBook anotherReferenceBook = new ReferenceBook("Python Basics", 400, 2021, "Jane Doe", 25.0,
				"Programming");
		anotherReferenceBook.addChapter(new Chapter("Getting Started", 30));
		anotherReferenceBook.addChapter(new Chapter("Advanced Topics", 70));

		// Thêm ReferenceBook khác vào danh sách
		publications.add(anotherReferenceBook);

		// Hiển thị danh sách ấn phẩm trước khi sắp xếp
		System.out.println("Danh sách ấn phẩm trước khi sắp xếp:");
		for (Publication publication : publications) {
			System.out.println(publication);
		}

		// Sắp xếp và hiển thị danh sách ấn phẩm
		ReferenceBook catalog = new ReferenceBook("Catalog", 0, 2023, "Catalog Author", 0.0, "Catalog Field");
		catalog.sortPublications(publications);

		System.out.println("Danh sách ấn phẩm sau khi sắp xếp:");
		for (Publication publication : publications) {
			System.out.println(publication);
		}

		// Thống kê số lượng ấn phẩm theo năm xuất bản
		Map<Integer, Integer> publicationCountByYear = catalog.countPublicationsByYear(publications);
		System.out.println("Thống kê số lượng ấn phẩm theo năm xuất bản:");
		for (Map.Entry<Integer, Integer> entry : publicationCountByYear.entrySet()) {
			System.out.println("Năm " + entry.getKey() + ": " + entry.getValue() + " ấn phẩm");
		}
	}
}
