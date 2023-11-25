package ru.letdigit.lambdasandstreams.employees;

public class SalaryService {
    public static Employee salaryUp(Employee employee) {
        double MULTIPLYING_FACTOR = 1.2;

        double newSalary = employee.getSalary() * MULTIPLYING_FACTOR;
        employee.setSalary(newSalary);
        return employee;
    }
}
