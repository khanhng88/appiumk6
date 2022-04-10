package lab08;

public class FullTimeEmployee extends Employee{
    public FullTimeEmployee(String name) {
        super(name);
    }

    @Override
    public int salaryValue() {
        return 50000;
    }
}
