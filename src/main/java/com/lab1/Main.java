package com.lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter k: ");
            int k = scanner.nextInt();
            System.out.println("Enter x (-1, 1): ");
            double x = scanner.nextDouble();
            if (x <= -1 || x >= 1) {
                throw new Exception("x should be in (-1, 1)");
            }

            double eps = Math.pow(10, -k);
            double actualValue = calculateActualValue(x);
            double calculatedValue = calculateTailor(eps, x);

            System.out.printf("Counted result: %.3f \n", calculatedValue);
            System.out.printf("Function result: %.3f \n", actualValue);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static double calculateActualValue(double x) {
        return 1 / Math.sqrt(1 + x);
    }

    static double calculateTailor(double eps, double x) {
        double elem = 100;
        double result = 0;
        int n = 0;
        while (Math.abs(elem) >= Math.abs(eps)) {
            elem = (Math.pow(-1, n) * calculateFactorial(2 * n) * Math.pow(x, n)) /
            (Math.pow(calculateFactorial(n), 2) * Math.pow(4, n));
            result += elem;
            n++;
        }
        return result;
    }

    static int calculateFactorial(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
