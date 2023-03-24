package org.example;

public class Employee extends Person implements DataHandler {
    String employeeId;
    String clockedIn;
    String hiredData;

    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredData) {
        super(firstName, lastName, address, phoneNumber, email);
        this.employeeId = employeeId;
        this.clockedIn = clockedIn;
        this.hiredData = hiredData;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(String clockedIn) {
        this.clockedIn = clockedIn;
    }

    public String getHiredData() {
        return hiredData;
    }

    public void setHiredData(String hiredData) {
        this.hiredData = hiredData;
    }

    public String getInfo() {
        return "Employee Info: " +
                "Employee ID: " + employeeId + "    " +
                "Employee Name: " + getName() + "    " +
                "Time Clocked In: " + clockedIn;
    }

    public String getFileData() {
        return employeeId + "," + getName() + "," + clockedIn;
    }

    public static Employee parse(String data) {
        String[] employeeList = data.split(",");
        return new Employee(employeeList[1], employeeList[2], employeeList[4], employeeList[5], employeeList[3], employeeList[0], employeeList[6], employeeList[7]);
    }
}
