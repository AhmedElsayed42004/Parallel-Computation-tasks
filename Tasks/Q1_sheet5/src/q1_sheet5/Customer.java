/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1_sheet5;

/**
 *
 * @author ZBook
 */
public class Customer {
    private int id;
    private String name;
    private int discount;

    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }
    
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public String toStrin(){
        return name + "(" + id + ")(" + discount + "%)";
    }
    
}
