package com.epam.jwd.reader;

import com.epam.jwd.model.Point;

import java.util.List;

public interface Readable {

    List create(Point p1, Point p2, Point p3);

    void read(String FileName);

    void delete(List arrayList);
}
