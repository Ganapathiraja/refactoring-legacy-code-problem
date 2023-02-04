package com.thoughtworks.furniturerental;

public class Rental {

    private final int daysRented;
    private final Furniture furniture;

    public Rental(Furniture furniture, int daysRented) {
        this.furniture = furniture;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    // reason to put up here is that it's all about rental and these are part of rental calculation
    public double amount()
    {
        double thisAmount = 0;
        switch (furniture.getPriceCode()) {
            case Furniture.REGULAR:
                thisAmount += 200;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 150;
                break;
            case Furniture.NEW_LAUNCH:
                thisAmount += daysRented * 300;
                break;
            case Furniture.CHILDREN:
                thisAmount += 150;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 150;
                break;
        }
        return thisAmount;
    }

    public int frequentRenterPoints()
    {
        int frequentRenterPoints = 1;
        // add frequent renter points
        // add bonus for a two days new launch rental
        if ((furniture.getPriceCode() == Furniture.NEW_LAUNCH) && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}