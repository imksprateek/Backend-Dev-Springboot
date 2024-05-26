package com.ksprateek.springdemo.mvc;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    //First name is not mandatory
    private String firstName;

    //Make lastName field mandatory and specify size a minimum of 1
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName = "";

    //Let's define freePasses value to be greater than 0 and less than 10
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value =10, message = "must be less than or equal to 10")
    private int freePasses;

    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(@Min(value = 0, message = "must be greater than or equal to zero") @Max(value = 10, message = "must be less than or equal to 10") int freePasses) {
        this.freePasses = freePasses;
    }

    //Getters and setters for the fields
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
}
