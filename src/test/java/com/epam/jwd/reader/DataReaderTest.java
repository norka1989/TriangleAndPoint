package com.epam.jwd.reader;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.validation.ValidationOfTriangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {
    Point p1=new Point(2,3);
    Point p2=new Point(0,4);
    Point p3=new Point(-1,1);
    static String FILE_NAME="src/test/resources/points.txt";

    @Test
    void createListFromFile_always() {
        List triangles=DataReader.getInstance().createListFromFile(FILE_NAME);

        assertFalse(triangles.isEmpty());
    }

    @Test
    void create_addTriangleInList_always() {
        Triangle triangle=new Triangle(p1,p2,p3);
        ValidationOfTriangle validOfTriangle=new ValidationOfTriangle(p1,p2,p3);

        List<Triangle> triangles = DataReader.getInstance().create(p1,p2,p3);

        assertFalse(triangles.isEmpty());
        assertEquals(triangle, triangles.get(0));
    }

    @Test
    void delete_deleteListOfTriangles_always() {
        Triangle triangle=new Triangle(p1,p2,p3);
        ValidationOfTriangle validOfTriangle=new ValidationOfTriangle(p1,p2,p3);

        if(validOfTriangle.existenceOfATriangle(p1,p2,p3)){
          //  triangles.add(triangle);
        }
       // DataReader.getInstance().delete(triangles);
        //assertTrue(triangles.isEmpty());

    }


}