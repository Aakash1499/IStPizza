package edu.psu.abington.ist.ist242;

import java.util.ArrayList;
import java.util.Iterator;

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private Customer cust;
    private double price;
    private String order;
    private int custIntOrder;

    public int getCustIntOrder() {
        return custIntOrder;
    }

    public void setCustIntOrder(int custIntOrder) {
        this.custIntOrder = custIntOrder;
    }

    public Order(){

    }
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private ArrayList<Menu> menuItem;

    //Constructor Method
    public Order(int _orderId){
        this.orderId = _orderId;
    }

    //Setters and Getters
    public int getorderId() {
        return orderId;
    }
    public void setorderId(int _orderId) {
        this.orderId = _orderId;
    }

    public static void printOrder(ArrayList<Order> oList, ArrayList <Customer> cList){
        Customer cust = new Customer();
        double bill = 0.00;
        //Customer.printCustomer(cList);


        int num = cust.getNum();
        Iterator itr = cList.iterator();
            while(itr.hasNext()) {
                Customer customer = (Customer) itr.next();
                if (customer.getCustomerId() == num) {
                    System.out.println("Customer Id:" + customer.getCustomerId());
                    System.out.println("Customer Name:" + customer.getCustomerName());
                    System.out.println("Customer Phone:" + customer.getCustomerPhoneNumber());
                }else{
                    continue;
                }
            }

        for (Order ord: oList){
            System.out.println("Ordered: " + ord.getOrder());

            if(ord.getOrder().equals("Veg Pizza")){
                bill += 3.50;
            }else if(ord.getOrder().equals("Plain Pizza")){
                bill += 2.00;
            }else if(ord.getOrder().equals("Meat Pizza")){
                bill += 3.00;
            }else if(ord.getOrder().equals("Extra Pizza")){
                bill += 4.00;
            }
        }

        System.out.println("Total: $" + bill);
    }
}
