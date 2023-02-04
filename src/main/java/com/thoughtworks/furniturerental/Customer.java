package com.thoughtworks.furniturerental;

import com.thoughtworks.furniturerental.util.CustomerResultUtils;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement()
    {

        String result = getRentalRecordName();

        int totalFrequentRenterPoints = rentals.getTotalFrequentRenterPoints();

        for (Rental rental : rentals) {
            result += CustomerResultUtils.getCurrentAmount(rental, rental.amount());
        }

        double totalAmount = rentals.getTotalAmount();


        result += CustomerResultUtils.getAmountOwned(totalAmount);
        result += CustomerResultUtils.getFrequentRenterPoints(totalFrequentRenterPoints);
        return result;
    }


    // Creates a full statement for customers
    private String getRentalRecordName() {
        return "Rental Record for " + getName() + "\n";
    }

    public String htmlStatement() {

        StringBuilder result = new StringBuilder();
        result.append("<h1>").append(getRentalRecordName()).append("</h1>");

        int totalFrequentRenterPoints = rentals.getTotalFrequentRenterPoints();
        for (Rental rental : rentals) {
            //show figures for this rental
            result.append("<div>").append(CustomerResultUtils.getCurrentAmount(rental, rental.amount())).append("</div>");
        }

        double totalAmount = rentals.getTotalAmount();

        result.append("<b>").append(CustomerResultUtils.getAmountOwned(totalAmount)).append("</b>");
        result.append("<b>").append(CustomerResultUtils.getFrequentRenterPoints(totalFrequentRenterPoints)).append("</b>");
        return result.toString();
    }

}

