/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

/**
 * This class means Discover credit card.
 *
 * @author Jing Zhao
 */
public class Discover extends CreditCard {

    /**
     * Constructor.
     *
     * @param creditCardNum
     *      the credit card number.
     */
    public Discover(String creditCardNum) {
        super(creditCardNum);
        this.creditCardTpye = "Discover";
    }


    /**
     * Check if the credit card is Discover.
     *
     * @param creditCardNum
     *      the credit card number.
     * @return
     *      true or false.
     */
    static boolean isDiscover(String CreditCardNum) {
        if (CreditCardNum == null || CreditCardNum.isEmpty()) {
            return false;
        }
        // Discover: First four digits are 6011. Length is 16 digits.
        return (CreditCardNum.length() == 16 && CreditCardNum.startsWith("6011"));
    }

}
