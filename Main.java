package edu.psu.abington.ist.ist242;

/*
Project: Lab 9
Purpose Details: Pizza ordering application
Course: IST 242
Author: Aakash Patel
Date Developed: 3/14/19
Last Date Changed: 3/13/19
Rev: 2
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class Main {
    int cCount = 1;
    public static void main(String[] args) {

        Main main = new Main();
        Customer customer = new Customer();
        Order order1 = new Order();

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char ORDE_PRNT = 'A';
        final char HELP_CODE = '?';

        char userAction;
        final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder, 'A'- Print Order, List 'T'ransaction or 'E'xit: ";
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

        Menu menu1 = new Menu(1, "[P]lain Pizza", 2.00,"Plain Pizza for $2.00");
        Menu menu2 = new Menu(2, "[M]eat Pizza", 3.00,"Meat Pizza for $3.00");
        Menu menu3 = new Menu(3, "[E]xtra Cheese Pizza", 4.00,"Extra Cheese Pizza for $4.00");
        Menu menu4 = new Menu(4, "[V] egetarian Pizza", 3.50,"Vegetarian Pizza for $3.50");

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);

        Random rand = new Random();

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch(userAction) {
                case CUST_CODE : cList.add(main.addCustomer());
                    break;
                case CUST_PRNT : Customer.printCustomer(cList);
                    break;
                case MENU_CODE : Menu.listMenu(mList);
                    break;
                case ORDE_CODE :
                    Customer cust = new Customer();
                    int i = 0;
                    boolean flag = true;
                    int cust_ans_id;
                    Order order = new Order(i++);
                    Scanner scnr = new Scanner(System.in);
                    System.out.println("Please enter your Customer ID: ");
                    cust_ans_id = scnr.nextInt();

                    boolean checker;
                    checker = main.checker(cust_ans_id,cList);
                    if(checker == true){
                        System.out.println("Customer found and Verified!");
                    }else{
                        System.out.println("Customer not found!, Please enter in queue.");
                        cList.add(main.addCustomer());
                    }

                    System.out.println("How many things would you like to Order?");
                    int ord_num = scnr.nextInt();
                    scnr.nextLine();
                    System.out.println("What would you like to order, we currently have: ");
                    for (Menu menu: mList){
                        System.out.println(menu.getmenuItem());
                    }
                    while(i <= ord_num) {
                        oList.add(main.addOrder());
                        i++;
                    }
                    break;
                case ORDE_PRNT :
                   // Customer cusNum = new Customer();
                    Order.printOrder(oList,cList);
                    break;
                case TRAN_CODE :
                    Customer cu = new Customer();
                    String payMethod = "";
                    Scanner input = new Scanner(System.in);
                    System.out.print("How would you like to pay for this order: ");
                    payMethod = input.nextLine();
                    payMethod.toUpperCase();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPizza Palace");
                    switch(payMethod) {
                        case "CHECK": Transaction trans1 = new Transaction(1, order1, PaymentType.check);
                        tList.add(trans1); break;
                        case "CASH": Transaction trans2 = new Transaction(1, order1, PaymentType.cash);
                            tList.add(trans2); break;
                        case "CREDIT": Transaction trans3 = new Transaction(1, order1, PaymentType.credit);
                            tList.add(trans3); break;
                    }
                    //add cusotmer
                    Customer.printCustomer(cList);
                    Order.printOrder(oList,cList);
                    Transaction.listTransactions(tList);
                    System.out.println("Bill Paid!");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\tThank you for Visiting Pizza Palace\n\n");


                    main.removeCustomer(cList,cu.getNum());
                    cList.clear();
                    oList.clear();
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
        System.out.println("Thank you for Shopping at Pizza Palace!");
    }

    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    public Customer addCustomer(){
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.print("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        return cust;
    }

    public Order addOrder(){
        Order ord = new Order();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Order: ");
        ord.setOrder(scnr.nextLine());
        return ord;
    }

    public boolean checker(int a, ArrayList<Customer> cList) {
        Iterator itr = cList.iterator();
        boolean result = false;
        // while(!result) {
        while(itr.hasNext()) {
            Customer cust = (Customer) itr.next();
            if(cust.getCustomerId() == a){
                result = true;
                break;
            }else{
                result = false;
            }
        }
        return result;
    }

    public void removeCustomer(ArrayList<Customer> cList, int a){
        Iterator itr = cList.iterator();
        while(itr.hasNext()) {
            Customer cust = (Customer) itr.next();
            if(cust.getCustomerId() == a){
                itr.remove();
                break;
            }else{
                continue;
            }
        }
    }
}

