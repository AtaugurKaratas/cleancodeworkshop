package com.workshop.primitives;

import java.util.List;

public class Route {
    private List<GeoPoint> points;

    public Route(List<GeoPoint> points) {
        this.points = points;
    }

    public List<GeoPoint> getPoints() {
        return points;
    }

    public void setPoints(List<GeoPoint> points) {
        this.points = points;
    }
}
