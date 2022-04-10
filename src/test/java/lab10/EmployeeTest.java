package lab10;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new FullTimeEmployee("Mike"));
        employeeList.add(new FullTimeEmployee("Lona"));
        employeeList.add(new FullTimeEmployee("Jose"));

        employeeList.add(new ContractorEmployee("Anne"));
        employeeList.add(new ContractorEmployee("Joan"));

        int total = 0;
        for (Employee employee : employeeList) {
            System.out.println("Employee name " + employee.getEmployeeName());
            System.out.println("Employee salary " + employee.salaryValue());
            System.out.println("----------------------------------------");
            total+=employee.salaryValue();
        }
        System.out.println("Total salary " + total);
    }
}
