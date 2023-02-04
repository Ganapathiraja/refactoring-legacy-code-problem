package com.thoughtworks.furniturerental.statements;

import com.thoughtworks.furniturerental.Rental;
import com.thoughtworks.furniturerental.Rentals;
import com.thoughtworks.furniturerental.util.CustomerResultUtils;

public class TextStatement {


    private String name;
    private Rentals rentals;
    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement()
    {

        String result = "Rental Record for " + name + "\n";

        int totalFrequentRenterPoints = rentals.getTotalFrequentRenterPoints();

        for (Rental rental : rentals) {
            result += "\t" + rental.getFurniture().getTitle() + "\t" +
                    rental.amount() + "\n";
        }

        double totalAmount = rentals.getTotalAmount();


        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }


    private String getRentalRecordName() {
        return "Rental Record for " + name + "\n";
    }


}
