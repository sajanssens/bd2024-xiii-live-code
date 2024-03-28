package com.infosupport.h4;

import com.infosupport.h4.HetWaterIsOpException;

import java.io.IOException;

public class WaterBron implements AutoCloseable {
    public void stroom() throws HetWaterIsOpException {
        throw new HetWaterIsOpException("Hitterecord, dus water is op.");
    }

    public void close() throws IOException {
        // this.releaseresources...
        throw new IOException();
    }
}
