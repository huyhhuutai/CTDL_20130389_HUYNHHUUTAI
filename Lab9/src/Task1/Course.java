package Task1;

import java.util.ArrayList;
import java.util.List;

class Course {
    private int id;
    private String title;
    private String type;
    private List<Student> students;

    public Course(int id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = new ArrayList<>();
    }

    // Getter và setter cho id, title, type, và students...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", students=" + students +
                '}';
    }
}
