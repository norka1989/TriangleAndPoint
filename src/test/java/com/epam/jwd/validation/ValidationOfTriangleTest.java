package com.epam.jwd.validation;

import com.epam.jwd.model.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidationOfTriangleTest {

    @ParameterizedTest
    @MethodSource("listOfDatesForCreatingTriangle")
    public void existenceOfATriangle_chekOfExistence_always(Point p1,Point p2,Point p3) {
        ValidationOfTriangle valid=new ValidationOfTriangle(p1,p2,p3);
        assertTrue(valid.existenceOfATriangle(p1,p2,p3));
    }

    private static Stream<Arguments> listOfDatesForCreatingTriangle(){
            return Stream.of(
                    arguments(new Point(-3,3),new Point(6,-3),new Point(22,6)),
                    arguments(new Point(-3,3),new Point(90,-3),new Point(3,0)),
                    arguments(new Point(-3,3),new Point(0,0),new Point(4,4)),
                    arguments(new Point(1,1),new Point(0,0),new Point(4,4)),
                    arguments(new Point(2,1),new Point(-1,-3),new Point(1,6))
            );
    }

    }