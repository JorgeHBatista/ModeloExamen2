package employees;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Employee implements EmployeeOperations {

    private final String name;
    private final String surname;
    private final Date startingDate;
    private final Date departureDate;
    private final String gender;
    private final String city;
    private final String position;
    private final double baseSalary;
    private double finalSalary;
    private int seniority;
    private boolean rotationEnabled;

    public Employee(String name, String surname, Date startingDate, Date departureDate, String gender, String city, String position, double baseSalary) {
        this.name = name;
        this.surname = surname;
        this.startingDate = startingDate;
        this.departureDate = departureDate;
        this.gender = gender;
        this.position = position;
        this.city = city;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getSeniority() {
        return seniority;
    }

    public boolean getRotationEnabled() {
        return this.rotationEnabled;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public void setRotationEnabled(boolean rotationEnabled) {
        this.rotationEnabled = rotationEnabled;
    }

    @Override
    public void computeFinalSalary() {
        this.setFinalSalary(this.getBaseSalary() * 0.83);
    }

    @Override
    public void computeSeniority() {
        long diffInMilliseconds = departureDate.getTime() - startingDate.getTime();
        this.setSeniority((int) TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS));
    }

    @Override
    public void enableRotation() {
        switch (this.getPosition()) {
            case "engineer":
            case "Engineer":
            case "ENGINEER":
                if (this.getSeniority() >= 365*2) {
                    this.setRotationEnabled(true);
                } else {
                    this.setRotationEnabled(false);
                }

                break;
            default:

        }
    }

    public String toJson() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return  "\t\t{" +
                "\n\t\t\t\"Name\": \"" + this.getName() +
                "\",\n\t\t\t\"Surname\": \"" + this.getSurname() +
                "\",\n\t\t\t\"Starting date\": \"" + dateFormat.format(this.getStartingDate()) +
                "\",\n\t\t\t\"Departure date\": \"" + dateFormat.format(this.getDepartureDate()) +
                "\",\n\t\t\t\"Gender\": \"" + this.getGender() +
                "\",\n\t\t\t\"City\": \"" + this.getCity() +
                "\",\n\t\t\t\"Position\": \"" + this.getPosition() +
                "\",\n\t\t\t\"Base Salary\": \"" + this.getBaseSalary() +
                "\",\n\t\t\t\"Final Salary\": \"" + this.getFinalSalary() +
                "\",\n\t\t\t\"Seniority\": \"" + this.getSeniority() +
                "\",\n\t\t\t\"Rotation\": \"" + (this.getRotationEnabled() ? "Enable" : "Disable") +
                "\"\n\t\t}";
    }
}
