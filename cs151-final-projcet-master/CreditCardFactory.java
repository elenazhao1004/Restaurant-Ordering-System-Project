/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

/**
 * This is the factory class to create a credit card instance.
 *
 * @author Jing Zhao
 */
public class CreditCardFactory extends CreditCard {
    /**
     * Constructor.
     *
     * @param creditCardNum
     *      the credit card number.
     */
    public CreditCardFactory(String creditCardNum) {
        super(creditCardNum);
    }

    static CreditCard createCard(String CreditCardNum) {
        if (VISA.isVISA(CreditCardNum)) {
            return new VISA(CreditCardNum);
        } else if (Discover.isDiscover(CreditCardNum)) {
            return new Discover(CreditCardNum);
        } else if (MasterCard.isMasterCard(CreditCardNum)) {
            return new MasterCard(CreditCardNum);
        } else if (AmericanExpress.isAmericanExpress(CreditCardNum)) {
            return new AmericanExpress(CreditCardNum);
        }
        return null;
    }
}
