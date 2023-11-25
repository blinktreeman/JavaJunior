# GeekBrains Java Junior Course
## Семинар №1
### Задание №1
`App.java`:
```java
package ru.letdigit.lambdasandstreams.numbers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * 1.1 Найти максимальное
 * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 */

public class App {
    public static void main(String[] args) {
        int MAX_NUMBERS_VALUE = 1_000_000;
        int AMOUNT_OF_NUMBERS = 1_000;
        Random rnd = new Random();

        // 1. Создаем список рандомных чисел
        List<Integer> numbers = Stream
                .generate(() -> rnd.nextInt(MAX_NUMBERS_VALUE))
                .limit(AMOUNT_OF_NUMBERS)
                .toList();

        // 1.1 Максимальное значение
        int maxNumber = numbers
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
        System.out.printf("Max value: %d\n", maxNumber);

        // 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        int MORE_THAN_VALUE = 500_000;
        int ARG_01 = 5;
        int ARG_02 = 150;

        int sumOfNumbers = numbers
                .stream()
                .filter(x -> x > MORE_THAN_VALUE)
                .map(x -> x * ARG_01 - ARG_02)
                .reduce(0, Integer::sum);
        System.out.printf("Sum of numbers: %d\n", sumOfNumbers);

        // 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        int LESS_THEN_VALUE = 100_000;
        int EXPONENT = 2;

        long lessThanAmount = numbers
                .stream()
                .map(x -> (long) Math.pow(x, EXPONENT))
                .filter(x -> x < LESS_THEN_VALUE)
                .count();
        System.out.printf("Number of numbers less than 100000: %d\n", lessThanAmount);
    }
}

/*
Output:

Max value: 999673
Sum of numbers: 2026151455
Number of numbers less than 100000: 1
 */
```
### Задание №2  
`App.java`:
```java
package ru.letdigit.lambdasandstreams.employees;

import java.util.List;

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
 */
```
Директория пакета: [Package](ru/letdigit/lambdasandstreams/employees)
