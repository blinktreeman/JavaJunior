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
        int maxNumber = numbers.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.printf("Max value: %d\n", maxNumber);

        // 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        int MORE_THAN_VALUE = 500_000;
        int ARG_01 = 5;
        int ARG_02 = 150;

        int sumOfNumbers = numbers.stream()
                .filter(x -> x > MORE_THAN_VALUE)
                .map(x -> x * ARG_01 - ARG_02)
                .reduce(0, Integer::sum);
        System.out.printf("Sum of numbers: %d\n", sumOfNumbers);

        // 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        int LESS_THEN_VALUE = 100_000;
        int EXPONENT = 2;

        long lessThanAmount = numbers.stream()
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