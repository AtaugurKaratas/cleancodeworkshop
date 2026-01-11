package com.workshop.primitives;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceServiceTest {
    @Test
    void calculateDistanceBetweenTwoPoints_shouldReturnCorrectDistance() {
        GeoPoint geoPoint = new GeoPoint(41.0082, 28.9784);
        GeoPoint geoPoint2 = new GeoPoint(39.9208, 32.8541);
        double km = new DistanceService().calculateDistanceForPoints(geoPoint, geoPoint2);
        assertTrue(km > 340 && km < 460);
    }
    @Test
    void calculateDistanceMultiplePoints_shouldReturnCorrectDistance() {
        GeoPoint geoPoint = new GeoPoint(41.0082,28.9784);
        GeoPoint geoPoint2 = new GeoPoint(39.9208,32.8541);
        GeoPoint geoPoint3 = new GeoPoint(38.4237,27.1428);
        double excepted = 349.4216869601892;
        List<Double> routesCalculation = new DistanceService().calculateMultipleRoutes(List.of(geoPoint, geoPoint2, geoPoint3));
        assertEquals(excepted, routesCalculation.getFirst());
    }
}
