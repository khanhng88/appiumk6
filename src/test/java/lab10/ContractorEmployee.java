package lab10;

public class ContractorEmployee extends Employee {
    public ContractorEmployee(String name) {
        super(name);
    }

    @Override
    public int salaryValue() {
        return 40000;
    }
}
