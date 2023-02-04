package com.thoughtworks.furniturerental.util;

import com.thoughtworks.furniturerental.Rental;

public class CustomerResultUtils
{
    public static String getCurrentAmount(Rental rental, double thisAmount) {
        return "\t" + rental.getFurniture().getTitle() + "\t" +
                thisAmount + "\n";
    }

    public static String getAmountOwned(double totalAmount) {
        return "Amount owed is " + totalAmount + "\n";

    }

    public static String getFrequentRenterPoints(int points) {
        return  "You earned " + points
                + " frequent renter points";
    }
}
