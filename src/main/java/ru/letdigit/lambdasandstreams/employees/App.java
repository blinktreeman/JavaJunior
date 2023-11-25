package ru.letdigit.lambdasandstreams.employees;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>>
 * с отделами и сотрудниками внутри отдела
 * 2.5 * Из списка сотрудников с помощью стрима создать Map<String, Double>
 * с отделами и средней зарплатой внутри отдела
 */
public class App {
    public static void main(String[] args) {
        Company company = Company.getInstance();

        // 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println("Departments:");
        Company.getEmployees()
                .stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        // 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        double SALARY_MIN = 10_000;

        List<Employee> salaryUpList = Company.getEmployees().stream()
                .filter(e -> e.getSalary() < SALARY_MIN)
                .map(SalaryService::salaryUp).toList();
        System.out.println("Employees salary up:");
        salaryUpList.forEach(System.out::println);

        // 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>>
        // с отделами и сотрудниками внутри отдела

    }
}
