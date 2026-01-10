package com.workshop.primitives;

import java.util.ArrayList;
import java.util.List;

public class DistanceService {

    private static final double RADIUS = 6371;

    public List<Double> calculateMultipleRoutes(List<GeoPoint> points) {
        if (points.size() < 2) return List.of();

        List<Double> distances = new ArrayList<>();
        GeoPoint startPoint = points.getFirst();

        for(int i = 1; i < points.size(); i++) {
            distances.add(calculateDistanceForPoints(startPoint, points.get(i)));
            startPoint = points.get(i);
        }
        return distances;
    }

    public double calculateDistanceForPoints(GeoPoint geoPoint1, GeoPoint geoPoint2) {
        double distanceLatitude = Math.toRadians(geoPoint2.getLatitude() - geoPoint1.getLatitude());
        double distanceLongitude = Math.toRadians(geoPoint2.getLongitude() - geoPoint1.getLongitude());
        double haversineIntermediateValue = calculateHaversineValue(geoPoint1.getLatitude(), geoPoint2.getLatitude(),
                distanceLatitude, distanceLongitude);
        double angularDistanceCalculation = calculateAngularDistance(haversineIntermediateValue);
        return RADIUS * angularDistanceCalculation;
    }

    private double calculateHaversineValue(double latitude1, double latitude2, double distanceLatitude, double distanceLongitude) {
        double haversineValue = Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2));
        haversineValue *= Math.sin(distanceLongitude / 2) * Math.sin(distanceLongitude / 2);
        haversineValue += Math.sin(distanceLatitude / 2) * Math.sin(distanceLatitude / 2);
        return haversineValue;
    }

    private double calculateAngularDistance(double haversineIntermediateValue) {
        return 2 * Math.atan2(Math.sqrt(haversineIntermediateValue), Math.sqrt(1 - haversineIntermediateValue));
    }
}
