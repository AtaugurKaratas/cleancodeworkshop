package com.workshop.primitives;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceServiceTest {
    @Test
    void computes_distance_istanbul_ankara(){
        double km = new DistanceService().distanceKm(41.0082, 28.9784, 39.9208, 32.8541);
        assertTrue(km > 340 && km < 460); // rough bounds
    }
    @Test
    void route_sum(){
        double km = new DistanceService().routeKm(41.0082,28.9784, 39.9208,32.8541, 38.4237,27.1428);
        assertTrue(km > 700 && km < 1000);
    }
}
