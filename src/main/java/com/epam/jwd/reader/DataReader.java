package com.epam.jwd.reader;

import com.epam.jwd.exception.IncorrectDatesException;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.validation.DataValidation;
import com.epam.jwd.validation.ValidationOfTriangle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataReader implements Readable {
    private static final Logger LOG = LogManager.getLogger(DataReader.class);
    private static final String FILE_IS_NOT_FOUND_ERROR = "The file <%s> is not found";
    private static final String OPENING_FILE = "An attempt to open file <%s>";
    private static final String LUCKY_OPENING = "The file <%s> is opened successfully";
    private static final String CREATED_LIST_OF_TRIANGLES = "The following triangles are created: <%s>";
    private static final String ERROR_IN_READING_COORD = "The error in reading coordinates from the line №";
    private static final String INCORRECT_DATES_IN_THE_LINE = "The dates in the line are incorrect";
    private static final String THE_TRIANGLE_IS_ADDED = "The triangle is added in the list";
    private static BufferedReader reader;
    private static final DataValidation valid = new DataValidation();
    private List<Triangle> triangles = new ArrayList<>();
    private static DataReader instance;                 //singleton


    private DataReader() {
    }

    public static DataReader getInstance() {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    @Override
    public void read(String FileName) {
        try {
            LOG.info(String.format(OPENING_FILE, FileName));
            reader = new BufferedReader(new FileReader(FileName));
            LOG.info(String.format(LUCKY_OPENING, FileName));
        } catch (FileNotFoundException e) {
            LOG.error(String.format(FILE_IS_NOT_FOUND_ERROR, FileName));
        }
    }

    public List<Triangle> createListFromFile(String FileName) {
        read(FileName);
        String line;
        int numberOfLine = 0;
        try {
            while ((line = reader.readLine()) != null) {
                numberOfLine++;
                if (valid.isCorrectData(line)) {
                    String[] coordinates = line.split("\\s|\\.");   //get 6 numbers
                    int[] intCoordinates = new int[6];                     //create a massiv of int
                    for (int i = 0; i < coordinates.length; i++) {
                        intCoordinates[i] = Integer.parseInt(coordinates[i]);
                    }
                    Point p1 = new Point(intCoordinates[0], intCoordinates[1]);
                    Point p2 = new Point(intCoordinates[2], intCoordinates[3]);
                    Point p3 = new Point(intCoordinates[4], intCoordinates[5]);
                    create(p1, p2, p3);
                } else {
                    throw new IncorrectDatesException(INCORRECT_DATES_IN_THE_LINE);
                }
            }
        } catch (Exception e) {
            LOG.error(ERROR_IN_READING_COORD + numberOfLine);
        }
        return triangles;
    }


    @Override
    public List<Triangle> create(Point p1, Point p2, Point p3) {
        Triangle triangle = new Triangle(p1, p2, p3);
        ValidationOfTriangle valid = new ValidationOfTriangle(p1, p2, p3);
        if (valid.existenceOfATriangle(p1, p2, p3)) {
            LOG.info(THE_TRIANGLE_IS_ADDED);
            triangles.add(triangle);
        }
        LOG.info(String.format(CREATED_LIST_OF_TRIANGLES, triangles.toString()));
        return triangles;
    }

    @Override
    public void delete(List list) {
        list.removeAll(list);                //можно ли так сделать???????????????
        LOG.info("The list of triangles is empty now");
    }

}
