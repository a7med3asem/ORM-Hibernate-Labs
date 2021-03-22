package dao;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private String department;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
