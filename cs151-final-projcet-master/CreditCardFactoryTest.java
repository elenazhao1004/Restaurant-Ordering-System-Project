package cs151hw4ry;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreditCardFactoryTest {

    @Test
    public void testCreateCard() {
        String[] cardNumbers = { 
                "341234567890123", 
                "6011123456789012", 
                "5112345678901234", 
                "4123456789012" };
        String[] cardTypes = { 
                "AmericanExpress", 
                "Discover", 
                "MasterCard", 
                "VISA" };

        for (int i = 0; i < cardNumbers.length; i++) {
            CreditCard card = CreditCardFactory.createCard(cardNumbers[i]);
            assertEquals(cardTypes[i], card.getType());
        }

        assertNull(CreditCardFactory.createCard("123"));
    }

}
