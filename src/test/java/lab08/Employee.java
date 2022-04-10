package lab08;

public class Employee {
    private String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public int salaryValue(){
        return 1000;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
