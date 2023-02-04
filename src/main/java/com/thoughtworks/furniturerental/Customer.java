package com.thoughtworks.furniturerental;

import com.thoughtworks.furniturerental.util.CustomerResultUtils;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;
        String result = getRentalRecordName();

        for (Rental rental : rentals) {
            double amount = rental.amount();
            totalFrequentRenterPoints += rental.frequentRenterPoints();
            result += CustomerResultUtils.getCurrentAmount(rental, amount);
            totalAmount += amount;
        }
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

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            double amount = rental.amount();
            frequentRenterPoints += rental.frequentRenterPoints();
            //show figures for this rental
            result.append("<div>").append(CustomerResultUtils.getCurrentAmount(rental, amount)).append("</div>");
            totalAmount += amount;
        }

        result.append("<b>").append(CustomerResultUtils.getAmountOwned(totalAmount)).append("</b>");
        result.append("<b>").append(CustomerResultUtils.getFrequentRenterPoints(frequentRenterPoints)).append("</b>");
        return result.toString();
    }

}

