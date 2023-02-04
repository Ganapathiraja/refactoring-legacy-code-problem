package com.thoughtworks.furniturerental;

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

    public String statement()
    {
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;
        String result = getRentalRecordName();

        for (Rental rental : rentals)
        {
            double amount = amountForRental(rental);
            totalFrequentRenterPoints += frequentRenterPoints(rental);
            //show figures for this rental
            result += getCurrentAmount(rental, amount);
            totalAmount += amount;
        }

        result += getAmountOwned(totalAmount);
        result += getFrequentRenterPoints(totalFrequentRenterPoints);
        return result;
    }

    double amountForRental(Rental rental)
    {
        double thisAmount = 0;
        switch (rental.getFurniture().getPriceCode()) {
            case Furniture.REGULAR:
                thisAmount += 200;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 150;
                break;
            case Furniture.NEW_LAUNCH:
                thisAmount += rental.getDaysRented() * 300;
                break;
            case Furniture.CHILDREN:
                thisAmount += 150;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 150;
                break;
        }
        return thisAmount;
    }
    int frequentRenterPoints(Rental rental)
    {
        int frequentRenterPoints = 1;
        // add frequent renter points
        // add bonus for a two days new launch rental
        if ((rental.getFurniture().getPriceCode() == Furniture.NEW_LAUNCH) && rental.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    // Creates a full statement for customers
    private String getRentalRecordName() {
        return "Rental Record for " + getName() + "\n";
    }
    private static String getCurrentAmount( Rental each, double thisAmount) {
        return "\t" + each.getFurniture().getTitle() + "\t" +
                thisAmount + "\n";
    }
    private static String getAmountOwned(double totalAmount) {
        return "Amount owed is " + totalAmount + "\n";

    }
    private static String getFrequentRenterPoints(int frequentRenterPoints) {
        return  "You earned " + frequentRenterPoints
                + " frequent renter points";
    }


    public String htmlStatement()
    {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();
        result.append("<h1>").append(getRentalRecordName()).append("</h1>");

        for (Rental rental : rentals)
        {
            double amount = amountForRental(rental);
            frequentRenterPoints += frequentRenterPoints(rental);
            //show figures for this rental
            result.append("<div>").append(getCurrentAmount(rental, amount)).append("</div>");
            totalAmount += amount;
        }

        result.append("<b>").append(getAmountOwned(totalAmount)).append("</b>");
        result.append("<b>").append(getFrequentRenterPoints(frequentRenterPoints)).append("</b>");
        return result.toString();
    }

}

