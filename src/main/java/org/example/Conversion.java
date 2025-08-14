package org.example;

import com.google.gson.annotations.SerializedName;

public class Conversion {
    @SerializedName("base_code")
    private String fromCurrency;
    @SerializedName("target_code")
    private String toCurrency;
    @SerializedName("conversion_result")
    private double amount;

    public Conversion(String fromCurrency, String toCurrency, double amount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Tu conversion:" + "\n" +
                "De: " + fromCurrency + "\n" +
                "A: " + toCurrency + "\n" +
                "Total: " + amount +
                '.';
    }
}
