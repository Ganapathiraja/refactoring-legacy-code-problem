package com.thoughtworks.furniturerental.statements;

import com.thoughtworks.furniturerental.Rental;
import com.thoughtworks.furniturerental.Rentals;
import com.thoughtworks.furniturerental.util.CustomerResultUtils;

public class HtmlStatement {

    private String name;
    private Rentals rentals;
    public HtmlStatement(String name,Rentals rentals)
    {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {

        StringBuilder result = new StringBuilder();
        result.append("<h1>").append("Rental Record for " + name + "\n").append("</h1>");

        for (Rental rental : rentals) {
            //show figures for this rental
            result.append("<div>").append("\t" + rental.getFurniture().getTitle() + "\t" +
                    rental.amount() + "\n").append("</div>");
        }

        double totalAmount = rentals.getTotalAmount();

        result.append("<b>").append("Amount owed is " + totalAmount + "\n").append("</b>");
        result.append("<b>").append("You earned " + rentals.getTotalFrequentRenterPoints()
                + " frequent renter points").append("</b>");
        return result.toString();
    }
}
