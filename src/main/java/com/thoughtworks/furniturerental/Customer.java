package com.thoughtworks.furniturerental;

import com.thoughtworks.furniturerental.statements.HtmlStatement;
import com.thoughtworks.furniturerental.statements.TextStatement;

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

    public String textStatement()
    {
        TextStatement textStatement = new TextStatement(getName(),rentals);
       return textStatement.statement();
    }

    public String htmlStatement()
    {
        HtmlStatement htmlStatement = new HtmlStatement(getName(),rentals);
        return htmlStatement.statement();
    }


    // Creates a full statement for customers

}

