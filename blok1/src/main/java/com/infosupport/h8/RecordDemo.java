package com.infosupport.h8;

import java.util.HashSet;
import java.util.Set;

public class RecordDemo {
    public static void main(String[] args) {
        Point3D point3D = new Point3D(1, 2, 3);
        Point3D point3D1 = new Point3D(1, 2, 3);

        System.out.println(point3D);
        System.out.println(point3D.equals(point3D1));

        int y = point3D.y();

        Set<Point3D> points = new HashSet<>();
        points.add(point3D);
        points.add(point3D1);

        System.out.println(points);

        Point3D change = point3D.change(10);
    }
}
