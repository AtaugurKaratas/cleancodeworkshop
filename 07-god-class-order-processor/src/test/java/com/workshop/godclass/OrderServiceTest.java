package com.workshop.godclass;

import org.junit.jupiter.api.Test;

import static com.workshop.godclass.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    void shouldCalculateDiscount_whenMainPriceThreshold() {
        //Given
        double total = 2000;
        double expectedDiscount = total * MAIN_DISCOUNT_RATE;

        //When
        double actualDiscount = orderService.calculateDiscount(total);

        //Then
        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    void shouldCalculateDiscount_whenSecondPriceThreshold() {
        //Given
        double total = 600;
        double expectedDiscount = total * SECOND_DISCOUNT_RATE;

        //When
        double actualDiscount = orderService.calculateDiscount(total);

        //Then
        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    void shouldCalculateDiscount_whenDefault() {
        //Given
        double total = 300;

        //When
        double actualDiscount = orderService.calculateDiscount(total);

        //Then
        assertEquals(total, actualDiscount);
    }

    @Test
    void shouldCalculateShipping_whenSmallerThanMinFreeShippingThreshold() {
        //Given
        double total = 50;
        double expectedShipping = total + SHIPPING_COST;

        //When
        double actualShipping = orderService.calculateShipping(total);

        //Then
        assertEquals(expectedShipping, actualShipping);
    }

    @Test
    void shouldCalculateShipping_whenBiggerThanMinFreeShippingThreshold() {
        //Given
        double total = 125;

        //When
        double actualShipping = orderService.calculateShipping(total);

        //Then
        assertEquals(total, actualShipping);
    }

    @Test
    void shouldCalculateTax_WhenGivenTotal() {
        //Given
        double total = 100;
        double expectedTotal = total * TAX_MULTIPLIER;

        //When
        double actualTotal = orderService.calculateTax(total);

        //Then
        assertEquals(expectedTotal, actualTotal);
    }

}