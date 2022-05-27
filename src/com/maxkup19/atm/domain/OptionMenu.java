package com.maxkup19.atm.domain;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException{
        int x = 1;

        do {
            try {
                data.put(12345678, 1234);
                data.put(87654321, 4321);

                System.out.println("Welcome to ATM Project");

                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e){
                System.out.println("\nInvalid character(s). Only numbers accepted.\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()){
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {

                    getChecking();
                }
            }
            if(x != 1) System.out.println("Wrong account number or/and PIN.\n");
        } while (x == 2);
    }

    public void getChecking(){
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice:");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Balance " + moneyFormat.format(getBalance()));
                getChecking();
            }
            case 2 -> {
                getWithdrawalInput();
                getChecking();
            }
            case 3 -> {
                getDepositInput();
                getChecking();
            }
            case 4 -> System.out.println("Thanks for using our ATM");
            default -> {
                System.out.println("Invalid choice");
                getChecking();
            }
        }
    }
}
