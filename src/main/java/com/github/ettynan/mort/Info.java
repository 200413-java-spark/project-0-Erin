package com.github.ettynan.mort;

import java.util.Scanner;


/**
 * Java class to gather information from the user for mortgage calculation
 */
public class Info{
    protected int years;
    protected double downPay;
    protected double interest;
    protected Integer zip;
    protected Scanner scanner = new Scanner(System.in);


    public Info(){
        this.downPay = this.getDownPay(scanner);
        this.years = this.getYears(scanner);
        this.interest = this.getInterest(scanner);
        this.zip = this.getZipCode(scanner);
    }

    public double getDownPay(Scanner scanner){
        double number = 0;
        do {
            System.out.println("Enter the down payment amount: ");
            while (!scanner.hasNextInt()){
                String input = scanner.next();
                System.out.printf("\"%s\" invalid. Numbers only please.\n", input);
            }
            number = scanner.nextInt();
            System.out.printf("Down payment is $%.2f\n", number);
        } while (number < 0);
        return number;
    }

    public int getYears(Scanner scanner){
        int number = 0;
        do {
            System.out.println("Enter the term length: ");
            while (!scanner.hasNextInt()){
                String input = scanner.next();
                System.out.printf("\"%s\" invalid. Numbers only please.\n", input);
            }
            number = scanner.nextInt();
            System.out.printf("Term length is %d\n", number, " years.");
        } while (number < 0);
        return number;
    }

    public Integer getZipCode(Scanner scanner){
        Integer number = 0;
        do {
            System.out.println("Enter the zipcode: ");
            while (!scanner.hasNextInt()){
                String input = scanner.next();
                System.out.printf("\"%s\" invalid. Numbers only please.\n", input);
            }
            number = scanner.nextInt();
            System.out.printf("Zipcode is %d\n", number);
        } while (number < 0);
        return number;
    }

    public double getInterest(Scanner scanner){
        double number = 0.0;
        do {
            System.out.println("Enter the interest rate: ");
            while (!scanner.hasNextDouble()){
                String input = scanner.next();
                System.out.printf("\"%s\" invalid. Numbers only please.\n", input);
            }
            number = scanner.nextDouble();
            System.out.printf("Interest rate is %.2f\n", number);
        } while (number < 0);
        return number;
    }



}