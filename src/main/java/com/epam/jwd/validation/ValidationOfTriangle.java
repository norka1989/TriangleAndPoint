package com.epam.jwd.validation;

import com.epam.jwd.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidationOfTriangle {
    private static final Logger LOG = LogManager.getLogger(ValidationOfTriangle.class);

    private Point p1;
    private Point p2;
    private Point p3;
    private int ax1;
    private int ay1;
    private int bx;
    private int by;

    public ValidationOfTriangle(Point p1, Point p2, Point p3) {
        ax1 = p2.getX() - p1.getX(); //coordinates of vector a between p1 and p2
        ay1 = p2.getY() - p1.getY();  //coordinates of vector a between p1 and p2
        bx = p3.getX() - p1.getX();   //coordinates of vector b between p3 and p1
        by = p3.getY() - p1.getY();   //coordinates of vector b between p3 and p1
    }

    public boolean existenceOfATriangle(Point p1, Point p2, Point p3) {
        int s = ax1 * by - bx * ay1; // collinearity condition
        if (s != 0) {
            LOG.info("Points " + p1 + ", " + p2 + ", " + p3 + " can form a triangle");
            return true;
        } else {
            LOG.info("Points don`t form a triangle, vectors are collinear ");
            return false;
        }
    }

    public boolean isRightTriangle() {
        int op = ax1 * bx + ay1 * by;  //perpendicularity condition
        if (op == 0) {
            LOG.info("right-angled triangle");
            return true;
        } else {
            LOG.info("arbitrary triangle");
            return false;
        }
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
}
