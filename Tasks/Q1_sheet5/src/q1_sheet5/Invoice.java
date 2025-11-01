/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1_sheet5;

/**
 *
 * @author ZBook
 */
public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
     public int getCustomerId() {
        return customer.getId();
    }
     
     public double getAmountAfterDiscount(){
         double discountAmount = amount * (customer.getDiscount() / 100);
         return amount - discountAmount;
     }
     
      @Override
    public String toString() {
        return "Invoice no.: " + id + "\n" +
               "Customer: " + customer.toString() + "\n" +
               "Amount: " + amount + "\n" +
               "Amount after discount: " + getAmountAfterDiscount();
}

}