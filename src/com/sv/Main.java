package com.sv;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        monthlyPayment();
        fizzBang(50);

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

    private static void monthlyPayment() {
        Scanner scanner = new Scanner(System.in);
        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;
        System.out.println("My Simple Mortgage Calculator");

        System.out.print("Principal ($): ");
        int principal = scanner.nextInt();

        System.out.print("Interest (%): ");
        double interest =
                scanner.nextDouble()/PERCENT/MONTHS_IN_YEAR;

        System.out.print("Length (Years): ");
        int years = scanner.nextInt();
        int months = years * MONTHS_IN_YEAR;

        double monthlyPayment =
                principal * (interest * (Math.pow(1 + interest, months)) /
                        (Math.pow(1 + interest, months) - 1));

        NumberFormat df = NumberFormat.getCurrencyInstance();
        String amount = df.format(monthlyPayment);

        System.out.println(amount);

        int income = 100_001;
        boolean hasHighIncome = (income > 100_000);

        System.out.println(hasHighIncome);
    }
}
