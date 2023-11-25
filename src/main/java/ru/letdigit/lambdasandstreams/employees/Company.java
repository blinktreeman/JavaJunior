package ru.letdigit.lambdasandstreams.employees;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {
    private static Company instance;
    @Getter
    @Setter
    private static List<Employee> employees = new ArrayList<>();

    private Company() {
        employees = Arrays.asList(
                new Employee("Ivanov", 30, 5000, "sales"),
                new Employee("Petrov", 35, 11000, "sales"),
                new Employee("Sidorov", 40, 12000, "sales"),
                new Employee("Ivanov", 45, 13000, "sales"),
                new Employee("Petrov", 50, 8000, "administration"),
                new Employee("Sidorov", 20, 7000, "administration"),
                new Employee("Ivanov", 25, 16000, "administration"),
                new Employee("Petrov", 27, 17000, "administration"),
                new Employee("Sidorov", 29, 18000, "administration"),
                new Employee("Ivanov", 43, 19000, "administration")
        );
    }

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }
}
