package com.sv;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        monthlyMortgagePayment();
//        fizzBang(50);
        System.out.println(getYearlyGrossSalary(37.5, 25.50));

    }

    private static String getYearlyGrossSalary(double workHoursPerWeek,
                                               double hourlyGrossPayRate) {
        final double WEEKS_PER_YEAR = 52.4;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMaximumFractionDigits(2);

        return currency.format(workHoursPerWeek * hourlyGrossPayRate * WEEKS_PER_YEAR);
    }

    private static void fizzBang(int finalNumber) {
        final int FIZZ = 3;
        final int BANG = 5;
        final int FIZZ_BANG = 15;
        String result;
        for (int i = 1; i <= finalNumber; i++) {
            result = i % FIZZ_BANG == 0 ? "FIZZ BANG!!!" :
                    i % BANG == 0 ? "BANG!" :
                            i % FIZZ == 0 ? "FIZZ" : String.valueOf(i);
            System.out.println(result);
        }
    }
    private static void fizzBang() {
        fizzBang(100);
    }

    private static void monthlyMortgagePayment() {
        Scanner scanner = new Scanner(System.in);
        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;
        System.out.println("~~~ My Simple Mortgage Calculator ~~~");

        int principal = 0;
        while(true) {
            System.out.print("\nPRINCIPAL ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000 ) {
                break;
            }
            System.out.println("Enter an amount between $1000 and $1,000," +
                    "000");
        }

        double monthlyInterestRate = 0;
        while (true) {
            System.out.print("\nAnnual Interest Rate (%): ");
            double annualInterestRate = scanner.nextDouble();
            if (annualInterestRate >= 0.25 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter an interest rate between 0.25% and " +
                    "30%");
        }

        int years = 0;
        int months = 0;
        while(true) {
            System.out.print("\nLength (Years): ");
            years = scanner.nextInt();
            if (years > 0 && years < 50) {
                months = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter years between 1 and 50");
        }

        double monthlyPayment =
                principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, months)) /
                        (Math.pow(1 + monthlyInterestRate, months) - 1));

        NumberFormat df = NumberFormat.getCurrencyInstance();
        String amount = df.format(monthlyPayment);

        System.out.println("\nYour monthly payment with be " + amount);

    }
}
