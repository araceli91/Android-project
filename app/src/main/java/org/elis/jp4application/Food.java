package org.elis.jp4application;


import org.json.JSONException;
import org.json.JSONObject;

public class Food {
    private String name;
    private double price;
    private double quantita;

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    private boolean availability;

    public Food(String name, double price, double quantita) {
        setName(name);
        setPrice(price);
        setQuantita(quantita);

    }

    public Food(JSONObject jsonObject) {
        try {
            name = jsonObject.getString("name");
            price = jsonObject.getDouble("price");
            quantita = 0;
            availability = jsonObject.getBoolean("available");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPrice(double price) {

        this.price = price;
    }


    public String getName() {

        return name;
    }

    public double getPrice()

    {
        return price;
    }

    public double getQuantita() {

        return quantita;
    }

    public void setQuantita(double quantita) {

        this.quantita = quantita;
    }

    public void increaseQuantita() {
        this.quantita++;
    }

    public void decreaseQuantita() {
        if (quantita == 0) return;
        this.quantita--;
    }

    }
