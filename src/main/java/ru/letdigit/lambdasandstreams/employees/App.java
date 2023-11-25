package ru.letdigit.lambdasandstreams.employees;

import java.util.List;
import java.util.Map;
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

        List<Employee> salaryUpList = Company.getEmployees()
                .stream()
                .filter(e -> e.getSalary() < SALARY_MIN)
                .map(SalaryService::salaryUp)
                .toList();
        System.out.println("Employees salary up:");
        salaryUpList.forEach(System.out::println);

        // 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>>
        // с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> employeesByDepartment = Company.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
        System.out.println("Employees by departments: ");
        employeesByDepartment.entrySet().forEach(System.out::println);

    }
}

/*
Output:

Departments:
sales
administration

Employees salary up:
Employee{name='Ivanov', age=30, salary=6000.0, department='sales'}
Employee{name='Petrov', age=50, salary=9600.0, department='administration'}
Employee{name='Sidorov', age=20, salary=8400.0, department='administration'}

Employees by departments:
administration=[
Employee{name='Petrov', age=50, salary=9600.0, department='administration'},
Employee{name='Sidorov', age=20, salary=8400.0, department='administration'},
Employee{name='Ivanov', age=25, salary=16000.0, department='administration'},
Employee{name='Petrov', age=27, salary=17000.0, department='administration'},
Employee{name='Sidorov', age=29, salary=18000.0, department='administration'},
Employee{name='Ivanov', age=43, salary=19000.0, department='administration'}
]
sales=[
Employee{name='Ivanov', age=30, salary=6000.0, department='sales'},
Employee{name='Petrov', age=35, salary=11000.0, department='sales'},
Employee{name='Sidorov', age=40, salary=12000.0, department='sales'},
Employee{name='Ivanov', age=45, salary=13000.0, department='sales'}
]
 */