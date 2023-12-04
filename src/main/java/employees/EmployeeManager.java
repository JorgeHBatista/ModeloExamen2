package employees;

import ports.ConsoleLogger;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeManager {

    ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void createEmployees(ConsoleLogger consoleLogger, int numberOfEmployees) {
        for (int i = 0; i < numberOfEmployees; i++ ) {
            consoleLogger.write("Introduce the name of the employee " + (i+1) + ": ");
            String name = consoleLogger.askString();
            consoleLogger.write("Introduce the surname of the employee " + (i+1) + ": ");
            String surname = consoleLogger.askString();
            consoleLogger.write("Introduce the starting date of the employee " + (i+1) + ": ");
            Date startingDate= consoleLogger.askDate();
            consoleLogger.write("Introduce the departure date of the employee " + (i+1) + ": ");
            Date departureDate = consoleLogger.askDate();
            consoleLogger.write("Introduce the gender of the employee " + (i+1) + ": ");
            String gender = consoleLogger.askString();
            consoleLogger.write("Introduce the city of the employee " + (i+1) + ": ");
            String city = consoleLogger.askString();
            consoleLogger.write("Introduce the position of the employee " + (i+1) + ": ");
            String position = consoleLogger.askString();
            consoleLogger.write("Introduce the base salary of the employee " + (i+1) + ": ");
            double baseSalary = consoleLogger.askDouble();
            Employee employee = new Employee(name, surname, startingDate, departureDate, gender, city, position, baseSalary);
            employee.computeFinalSalary();
            employee.computeSeniority();
            employee.enableRotation();
            employees.add(employee);
        }
    }

    public String employeesToJson() {
        String employeesJson = "{\n\t\"Employees\": [\n";
        int iterator = 1;
        for (Employee employee : employees) {
            employeesJson += employee.toJson() + ",\n";
        }
        employeesJson = employeesJson.substring(0, employeesJson.length() - 2);
        employeesJson += "\n\t]\n}";
        return employeesJson;
    }
}
