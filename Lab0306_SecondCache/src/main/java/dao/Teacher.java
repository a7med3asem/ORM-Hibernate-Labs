package dao;

import java.io.Serializable;
import java.util.Date;

public class Teacher extends Person implements Serializable {
    private Date hireDate;

    public Teacher(String firstName, String lastName, Date hireDate) {
        super(firstName, lastName);
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
