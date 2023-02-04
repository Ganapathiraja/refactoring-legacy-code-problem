package com.thoughtworks.furniturerental;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void test() {

        int expected = 3;

        assertEquals(expected, 1 + 2);
    }
    @Test
    public void happyPathCustomerWithAllFurnitureTypes()
    {
        Furniture chairFurniture = new Furniture("Chair", Furniture.REGULAR);
        Furniture tableFurniture = new Furniture("Table", Furniture.NEW_LAUNCH);
        Furniture sofaFurniture = new Furniture("Sofa", Furniture.CHILDREN);

        Rental chairRental = new Rental(chairFurniture, 10);
        Rental tableRental = new Rental(tableFurniture, 10);
        Rental sofaRental = new Rental(sofaFurniture, 10);

        Customer customer = new Customer("Ganapathi");
        customer.addRental(chairRental);
        customer.addRental(tableRental);
        customer.addRental(sofaRental);

        String statement = customer.statement();
        System.out.println(statement);

        assertEquals("Rental Record for Ganapathi\n" +
                "\tChair\t1400.0\n" +
                "\tTable\t3000.0\n" +
                "\tSofa\t1200.0\n" +
                "Amount owed is 5600.0\n" +
                "You earned 4 frequent renter points",statement);

    }

    @Test
    public void happyPathCustomerWithAllFurnitureTypesWithHtmlEnabled()
    {
        Furniture chairFurniture = new Furniture("Chair", Furniture.REGULAR);
        Furniture tableFurniture = new Furniture("Table", Furniture.NEW_LAUNCH);
        Furniture sofaFurniture = new Furniture("Sofa", Furniture.CHILDREN);

        Rental chairRental = new Rental(chairFurniture, 10);
        Rental tableRental = new Rental(tableFurniture, 10);
        Rental sofaRental = new Rental(sofaFurniture, 10);

        Customer customer = new Customer("Ganapathi");
        customer.addRental(chairRental);
        customer.addRental(tableRental);
        customer.addRental(sofaRental);

        String statement = customer.htmlStatement();
        System.out.println(statement);

        assertEquals("<h1>Rental Record for Ganapathi\n" +
                "</h1><div>\tChair\t1400.0\n" +
                "</div><div>\tTable\t3000.0\n" +
                "</div><div>\tSofa\t1200.0\n" +
                "</div><b>Amount owed is 5600.0\n" +
                "</b><b>You earned 4 frequent renter points</b>",statement);

    }
}