package org.example;

public class Customer extends Person implements DataHandler{
    String customerId;
    String accountNumber;

    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber) {
        super(firstName, lastName, address, phoneNumber, email);
        this.customerId = customerId;
        this.accountNumber = accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getInfo() {
        return "Customer Info: " +
                "Customer ID: " + customerId + "    " +
                "Customer Name: " + getName() + "    " +
                "Account Number: " + accountNumber;
    }

    public String getFileData() {
        return customerId + "," + getName() + "," + accountNumber;
    }
}
