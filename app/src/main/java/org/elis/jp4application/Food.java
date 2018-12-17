package org.elis.jp4application;

public class Food {
    private String name;
    private double price;
    private double quantita;

    public Food(String name,double price, double quantita){ //string per un prezzo????WTF
        setName(name);
        setPrice(price);
        setQuantita(quantita);

    }


    public void setName(String name){

        this.name = name;
    }

    public void setPrice(double price){

        this.price = price;
    }


    public String getName (){

        return name;
    }

    public double getPrice ()
    {
        return price;
    }

    public double getQuantita (){

        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public void increaseQuantita(double quantita) {
        this.quantita = quantita ++;

    }

    public void decreaseQuantita() {
        this.quantita = quantita --;
    }


}
