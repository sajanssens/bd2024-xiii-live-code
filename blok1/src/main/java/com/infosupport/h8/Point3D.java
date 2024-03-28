package com.infosupport.h8;

public record Point3D(int x, int y, int z) {

    public Point3D change(int x) {
        return new Point3D(x, this.y, this.z);
    }
}


