/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

import java.util.ArrayList;

/**
 * This class is the receipt after finishing an order.
 *
 * @author Jing Zhao
 */
public class Receipt {

    /**
     * The food ordered.
     */
    private ArrayList<String> reciptFood = new ArrayList<>();

    /**
     * The price of the ordered food.
     */
    private ArrayList<Double> reciptPrice = new ArrayList<>();

    /**
     * The payment credit card.
     */
    private CreditCard receiptCard = null;

    /**
     * The total price of the order.
     */
    private double total = 0;

    /**
     * Setter for the receiptCard.
     *
     * @param receiptCard
     *      the receipt credit card.
     */
    public void setCreditCard(CreditCard receiptCard) {
        this.receiptCard = receiptCard;
    }

    /**
     * Add an item to the order.
     *
     * @param food
     *      the ordered food.
     * @param price
     *      the price for the ordered food.
     */
    public void addItem(String food, Double price) {
        reciptFood.add(food);
        reciptPrice.add(price);
        total += price;
    }

    /**
     * Getter for the total price.
     *
     * @return
     *      the total price of the order.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Clear current order.
     */
    public void clear() {
        reciptFood.clear();
        reciptPrice.clear();
        total = 0;
        receiptCard = null;
    }

    /**
     * Print the receipt.
     *
     * @return
     *      a string of the printed receipt.
     */
    public String getReceiptString() {
        if (receiptCard == null) {
            return "Invalid Credit Card Number!";
        }
        if (reciptFood.isEmpty()) {
            return "Nothing in the Receipt!";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reciptFood.size(); i++) {
            sb.append(reciptFood.get(i)).append(" ").append(reciptPrice.get(i)).append("\n");
        }
        sb.append("your total is: ").append(total).append("\n");
        sb.append("your payment card is: ").append(receiptCard.getType()).append("\n");
        return sb.toString();
    }

}
