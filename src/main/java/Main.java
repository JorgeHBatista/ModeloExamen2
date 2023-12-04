import employees.EmployeeManager;
import ports.ConsoleLogger;
import ports.FileManager;

public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        consoleLogger.write("How many employees do you want to introduce?");
        int numberOfEmployees = consoleLogger.askPositiveInt();
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.createEmployees(consoleLogger, numberOfEmployees);
        FileManager fileManager = new FileManager("employees.json", 0);
        fileManager.write(employeeManager.employeesToJson());
        fileManager.closeWriter();
    }
}
