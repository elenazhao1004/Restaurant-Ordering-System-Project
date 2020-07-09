/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

/**
 * This class means MasterCard credit card.
 *
 * @author Jing Zhao
 */
public class MasterCard extends CreditCard {

    /**
     * Constructor.
     *
     * @param creditCardNum
     *      the credit card number.
     */
    public MasterCard(String creditCardNum) {
        super(creditCardNum);
        this.creditCardTpye = "MasterCard";
    }

    /**
     * Check if the credit card is MasterCard.
     *
     * @param creditCardNum
     *      the credit card number.
     * @return
     *      true or false.
     */
    static boolean isMasterCard(String CreditCardNum) {
        if (CreditCardNum == null || CreditCardNum.isEmpty()) {
            return false;
        }
        // MasterCard: First digit is a 5, second digit is in range 1 through 5
        // inclusive.
        // Only valid length of number is 16 digits.
        if (CreditCardNum.length() == 16 && CreditCardNum.charAt(0) == '5' && CreditCardNum.charAt(1) >= '1'
                && CreditCardNum.charAt(1) <= '5')
            return true;
        return false;

    }

}
