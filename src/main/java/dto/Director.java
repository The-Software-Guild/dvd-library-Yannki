package dto;

import java.util.Date;

public class Director {
    private String firstName;
    private String lastName;
    private Date DoB;

    public Director(){}

    public Director(String firstName, String lastName, Date DoB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DoB = DoB;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }
}
