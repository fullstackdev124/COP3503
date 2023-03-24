package org.example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    Scanner scnr;

    public List<Employee> readEmployeeData(String employeeFileName) {
        List<Employee> list = new ArrayList<Employee>();

        try {
            scnr = new Scanner(new FileReader(employeeFileName));
            String line;

            // if header, ignore line
            if (scnr.hasNextLine() && !(line=scnr.nextLine()).startsWith("employee_id"))
                list.add(Employee.parse(line));

            while (scnr.hasNextLine()) {
                list.add(Employee.parse(scnr.nextLine()));
            }

            scnr.close();
        } catch (IOException e) {
            logger("Error in Loading Employee Data -> " + e.toString());
        }

        return list;
    }

    public List<Ticket> readTicketData(String ticketFileName) {
        List<Ticket> list = new ArrayList<Ticket>();

        try {
            scnr = new Scanner(new FileReader(ticketFileName));
            String line;

            // if header, ignore line
            if (scnr.hasNextLine() && !(line=scnr.nextLine()).startsWith("customer_id"))
                list.add(Ticket.parse(line));

            while (scnr.hasNextLine()) {
                list.add(Ticket.parse(scnr.nextLine()));
            }

            scnr.close();
        } catch (IOException e) {
            logger("Error in Loading Employee Data -> " + e.toString());
        }

        return list;
    }

    public void writeData(String workOrderFileName, List<WorkOrder> workOrderList) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(workOrderFileName));

            // print header
            writer.println("employee_id,employee_first_name,employee_last_name,clocked_in,customer_id,customer_first_name,customer_last_name,customer_account_number,ticket_id,ticket_createdAt,workorder_createdAt");

            // print data
            for (WorkOrder order : workOrderList) {
                writer.println(order.getFileData());
                logger(order.getInfo());
            }

            // close writer
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger("Error in Writing Work Order Data -> " + e.toString());
        }
    }

    public void logger(String log) {
        System.out.println(log);
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true));

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            writer.println(formatter.format(new Date()) + ": " + log);

            // close writer
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger("Error in Writing Log -> " + e.toString());
        }
    }
}
