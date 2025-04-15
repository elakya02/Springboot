package com.backendtutorial.MVCValidation.Entity;

import com.backendtutorial.MVCValidation.Validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    public Customer() {
    }

    private String firstName;

    @NotNull(message = "is Required")
    @Size(min = 1 ,message = "is required")
    private String lastName;

    public int getFreepass() {
        return Freepass;
    }

    public void setFreepass(int freepass) {
        Freepass = freepass;
    }

    @Min(value = 0 , message = "The value should be greater than 0")
    @Max(value = 10 , message = "The value must be less than 10")
    private int Freepass;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}" , message = "the length should be 5 / digits")
    private String PostalCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @CourseCode
    private String courseCode;

    public Customer(String firstName) {
        this.firstName = firstName;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }
}
