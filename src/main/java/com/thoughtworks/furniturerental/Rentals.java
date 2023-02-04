package com.thoughtworks.furniturerental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : this) {
            totalFrequentRenterPoints += rental.frequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

    public double getTotalAmount()
    {
        double totalAmount = 0;
        for (Rental rental : this)
        {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

}
