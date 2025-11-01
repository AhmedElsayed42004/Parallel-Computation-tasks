/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q1_sheet5;

/**
 *
 * @author ZBook
 */
public class Q1_sheet5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Customer customer = new Customer(1, "Ahmed Elsayed", 10);

        Invoice invoice = new Invoice(101, customer, 1000.0);

        System.out.println("Customer Details:");
        System.out.println("ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Discount: " + customer.getDiscount() + "%");
        System.out.println("Customer String Representation: " + customer.toString());
        System.out.println();

        System.out.println("Invoice Details:");
        System.out.println("Invoice ID: " + invoice.getId());
        System.out.println("Customer ID from Invoice: " + invoice.getCustomerId());
        System.out.println("Amount: " + invoice.getAmount());
        System.out.println("Amount After Discount: " + invoice.getAmountAfterDiscount());
        System.out.println("Invoice String Representation: ");
        System.out.println(invoice.toString());
    }
}
