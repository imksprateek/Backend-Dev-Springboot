package com.ksprateek.springdemo.mvc;
import jakarta.validation.constraints.*;

public class Customer {
    //First name is not mandatory
    private String firstName;

    //Make lastName field mandatory and specify size a minimum of 1
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName = "";

    //Let's define freePasses value to be greater than 0 and less than 10
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value =10, message = "must be less than or equal to 10")
    private Integer freePasses;

    //In the regular expression below, '^' indicates start of the string, '[a-zA-Z0-9]' indicates it contains a-z or A-Z or 0-9, '{5}' indicates the length should be 5, '$' indicates end of the string
    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}$", message = "only 5 chars/digits")
    private String postalCode;


//    Getters and Setters
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
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
