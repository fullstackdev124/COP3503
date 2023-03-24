package org.example;

public class WorkOrder implements DataHandler{
    Employee employee;
    Ticket ticket;
    String createdAt;

    public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
        this.employee = employee;
        this.ticket = ticket;
        this.createdAt = createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getInfo() {
        return employee.getInfo() + "    " +
                ticket.getInfo()  + "    " +
                "WorkOrder Info: " + "Created At: " + createdAt;
    }

    public String getFileData() {
        return employee.getFileData() + "," + ticket.getFileData() + "," + createdAt;
    }
}
