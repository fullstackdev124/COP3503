package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    String employeeFileName = "employee_data.csv";
    String ticketFileName = "ticket_data.csv";
    String workOrderFileName = "work_order.csv";
    List<Employee> employeeList;
    List<Ticket> ticketList;
    List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

    public static void main(String[] args) {
        Main main = new Main();
        main.createWorkOrders();
    }

    private String now() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        return formatter.format(new Date());
    }

    public void createWorkOrders() {
        FileHandler handler = new FileHandler();

        // step1
        handler.logger("Project 3 Work Order Generator\n");

        // step2
        handler.logger("Loading Employee Data");
        employeeList = handler.readEmployeeData(employeeFileName);

        // step3
        handler.logger("Loading Ticket Data");
        ticketList = handler.readTicketData(ticketFileName);

        // step4
        handler.logger("Creating Working Orders");
        int employerCount = employeeList.size();
        int ticketCount = ticketList.size();
        if (employerCount > ticketCount)
            handler.logger("Ticket is less than Employers");
        else {
            int tickets_per_employer = ticketCount / employerCount;
            int i = 0, j = 0, k;
            while (i < employerCount) {
                Employee employee = employeeList.get(i);

                k = 0;
                while (k < tickets_per_employer) {
                    Ticket ticket = ticketList.get(j+k);
                    workOrderList.add(new WorkOrder(employee, ticket, now()));
                    k++;
                }
                j += k;

                // last employer
                if (i == employerCount-1) {
                    if (j < ticketCount-1) {
                        // if remain ticket, assign remaining tickets to last employer
                        for (k=j; k<ticketCount; k++)
                            workOrderList.add(new WorkOrder(employee, ticketList.get(k), now()));
                    }
                }

                i++;
            }
        }

        // step5
        handler.logger("Writing Work Order Data to File");
        handler.writeData(workOrderFileName, workOrderList);

        handler.logger("Work Orders Created. Program Exiting");
    }
}
