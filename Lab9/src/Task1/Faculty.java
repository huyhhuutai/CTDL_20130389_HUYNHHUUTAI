package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	// Getter và setter cho name, address, và courses...

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course maxPracticalCourse = null;
		int maxStudentCount = 0;

		for (Course course : courses) {
			if (course.getType().equals("thực hành")) {
				int currentStudentCount = course.getStudents().size();
				if (currentStudentCount > maxStudentCount) {
					maxStudentCount = currentStudentCount;
					maxPracticalCourse = course;
				}
			}
		}

		return maxPracticalCourse;
	}

	// Phương thức 2
	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> studentMap = new HashMap<>();

		for (Course course : courses) {
			List<Student> students = course.getStudents();
			for (Student student : students) {
				int year = student.getYear();
				if (!studentMap.containsKey(year)) {
					studentMap.put(year, new ArrayList<>());
				}
				studentMap.get(year).add(student);
			}
		}

		return studentMap;
	}

	// Phương thức 3
	public Set<Course> filterCourses(String type) {
		Set<Course> filteredCourses = new TreeSet<>(
				Comparator.comparingInt(course -> ((Course) course).getStudents().size()).reversed());

		for (Course course : courses) {
			if (course.getType().equals(type)) {
				filteredCourses.add(course);
			}
		}

		return filteredCourses;
	}

	// Các phương thức khác giữ nguyên...
	public static void main(String[] args) {
		// Tạo đối tượng Faculty
		Faculty faculty = new Faculty();
		faculty.setName("Khoa CNTT");
		faculty.setAddress("Địa chỉ Khoa CNTT");

		// Tạo danh sách sinh viên
		Student student1 = new Student(1, "Nguyen Van A", 2020);
		Student student2 = new Student(2, "Tran Thi B", 2021);
		Student student3 = new Student(3, "Le Van C", 2020);

		// Tạo danh sách học phần
		Course course1 = new Course(101, "Lập trình Java", "thực hành");
		course1.addStudent(student1);
		course1.addStudent(student2);

		Course course2 = new Course(102, "Cấu trúc dữ liệu", "lý thuyết");
		course2.addStudent(student2);
		course2.addStudent(student3);

		Course course3 = new Course(103, "Web Development", "thực hành");
		course3.addStudent(student1);
		course3.addStudent(student3);

		// Thêm các học phần vào khoa
		faculty.setCourses(Arrays.asList(course1, course2, course3));

		// Chạy thử các phương thức
		Course maxPracticalCourse = faculty.getMaxPracticalCourse();
		System.out.println("Học phần thực hành có nhiều sinh viên đăng ký nhất: " + maxPracticalCourse);

		Map<Integer, List<Student>> studentMap = faculty.groupStudentsByYear();
		System.out.println("Danh sách sinh viên theo năm vào học: " + studentMap);

		Set<Course> filteredCourses = faculty.filterCourses("thực hành");
		System.out.println(
				"Các học phần thực hành được sắp xếp theo số lượng sinh viên đăng ký giảm dần: " + filteredCourses);
	}
}
