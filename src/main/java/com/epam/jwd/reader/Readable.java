package com.epam.jwd.reader;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;

import java.util.List;

public interface Readable {

    public List create(Point p1,Point p2,Point p3);
    public void read(String FileName);
    public void delete (List arrayList);
}
