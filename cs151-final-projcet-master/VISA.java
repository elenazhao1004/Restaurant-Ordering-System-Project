/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

/**
 * This class means VISA credit card.
 *
 * @author Jing Zhao
 */
public class VISA extends CreditCard {

    /**
     * Constructor.
     *
     * @param creditCardNum
     *      the credit card number.
     */
    public VISA(String creditCardNum) {
        super(creditCardNum);
        this.creditCardTpye = "VISA";
    }

    /**
     * Check if the credit card is VISA.
     *
     * @param creditCardNum
     *      the credit card number.
     * @return
     *      true or false.
     */
    static boolean isVISA(String CreditCardNum) {
        if (CreditCardNum == null || CreditCardNum.isEmpty()) {
            return false;
        }
        // visa: First digit is a 4. Length is either 13 or 16 digits.
        if (CreditCardNum.charAt(0) == '4' && (CreditCardNum.length() == 16 || CreditCardNum.length() == 13)) {
            return true;
        }
        return false;
    }

}
