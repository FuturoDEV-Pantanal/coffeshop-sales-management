package cashier;

import java.util.ArrayList;

public class Cashier {
    //atributos
    private ArrayList<String> sales; //Espresso.
    private double totalPrice;
    
    //construtor
    public Cashier(){
        this.sales = new ArrayList<>();
        this.totalPrice = 0;
    }

    //getters       
    public double getTotalPrice(){
        return totalPrice;
    }
    public ArrayList<String> getSales(){
        return sales;
    }

    //setters
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
    
    public static void addOrder(Cashier cashier,String order){
        cashier.sales.add(order);
    }


}
