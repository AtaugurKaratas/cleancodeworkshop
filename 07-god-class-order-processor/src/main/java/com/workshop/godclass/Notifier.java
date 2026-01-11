package com.workshop.godclass;

public class Notifier {

    public void notifyEmail(Order order, double total) {
        System.out.println("Email to " + order.customerEmail() + ": your total is " + total);
    }
}
