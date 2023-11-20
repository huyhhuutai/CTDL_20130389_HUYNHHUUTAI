package Task1;

import java.util.*;

class Student {
    private int id;
    private String name;
    private int year;

    public Student(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    // Getter và setter cho id, name, và year...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

