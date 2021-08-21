package com.epam.jwd.model;

import java.util.Objects;

public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle() {
    }

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    @Override
    public String toString() {
        return "Triangle with coordinates{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(p1, triangle.p1) && Objects.equals(p2, triangle.p2) && Objects.equals(p3, triangle.p3);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (p1 != null ? p1.hashCode() : 0);
        result = result * 31 + (p2 != null ? p2.hashCode() : 0);
        result = result * 31 + (p3 != null ? p3.hashCode() : 0);
        return result;
    }
}
