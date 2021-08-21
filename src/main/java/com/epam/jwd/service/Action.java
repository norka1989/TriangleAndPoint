package com.epam.jwd.service;

import com.epam.jwd.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Action {
    private static final Logger LOG = LogManager.getLogger(Action.class);

    public double side1(Triangle triangle) {
        double side1 = Math.sqrt(
                Math.pow((triangle.getP2().getX() - triangle.getP1().getX()), 2) +
                        Math.pow((triangle.getP2().getY() - triangle.getP1().getY()), 2)
        );
        return side1;
    }

    public double side2(Triangle triangle) {
        double side2 = Math.sqrt(
                Math.pow((triangle.getP3().getX() - triangle.getP2().getX()), 2) +
                        Math.pow((triangle.getP3().getY() - triangle.getP2().getY()), 2)
        );
        return side2;
    }

    public double side3(Triangle triangle) {
        double side3 = Math.sqrt(
                Math.pow((triangle.getP3().getX() - triangle.getP1().getX()), 2) +
                        Math.pow((triangle.getP3().getY() - triangle.getP1().getY()), 2)
        );
        return side3;
    }

    public double perimetr(Triangle triangle) {
        double perimetr = side1(triangle) + side2(triangle) + side3(triangle);
        LOG.info("perimetr of the triangle " + triangle + " = " + perimetr);
        return perimetr;
    }

    public double square(Triangle triangle) {
        double p = perimetr(triangle) / 2;
        double square = Math.sqrt(p * (p - side1(triangle) * (p - side2(triangle)) * (p - side3(triangle))));
        LOG.info("square of the triangle " + triangle + " = " + square);
        return square;
    }
}