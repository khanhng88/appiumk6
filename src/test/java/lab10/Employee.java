package lab10;

public abstract class Employee {
    private String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public abstract int salaryValue();

    public String getEmployeeName() {
        return employeeName;
    }
}
