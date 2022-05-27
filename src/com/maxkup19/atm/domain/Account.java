package com.maxkup19.atm.domain;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double balance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double calcWithdraw(double amount){
        balance = balance - amount;
        return balance;
    }

    public double calcDeposit(double amount){
        balance = balance + amount;
        return balance;
    }


    public void getWithdrawalInput(){
        System.out.println("Account balance: " + moneyFormat.format(balance));
        System.out.print("Amount you want to withdraw from your balance: ");
        double amount = input.nextDouble();

        if ((balance - amount) >= 0){
            calcWithdraw(amount);
            System.out.println("New Account balance: " + moneyFormat.format(balance));
        }
        else {
            System.out.println("Balance can`t be negative");
        }
    }

    public void getDepositInput(){
        System.out.println("Account balance: " + moneyFormat.format(balance));
        System.out.print("Amount you want to deposit from your balance: ");
        double amount = input.nextDouble();

        if ((balance + amount) >= 0){
            calcDeposit(amount);
            System.out.println("New Account balance: " + moneyFormat.format(balance));
        }
        else {
            System.out.println("Balance can`t be negative");
        }
    }
}
