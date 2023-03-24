package org.example;

public class Ticket implements DataHandler{
    Customer customer;
    String createdAt;
    String ticketId;

    public Ticket(Customer customer, String createdAt, String ticketId) {
        this.customer = customer;
        this.createdAt = createdAt;
        this.ticketId = ticketId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getInfo() {
        return customer.getInfo() + "    " +
                "Ticket ID: " + ticketId + "    " +
                "Created At: " + createdAt;
    }

    public String getFileData() {
        return customer.getFileData() + "," + ticketId + "," + createdAt;
    }

    public static Ticket parse(String data) {
        String[] ticketList = data.split(",");
        return new Ticket(new Customer(ticketList[1], ticketList[2], ticketList[4], ticketList[5], ticketList[3], ticketList[0], ticketList[6]), ticketList[8], ticketList[7]);
    }
}
