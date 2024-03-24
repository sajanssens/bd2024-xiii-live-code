package com.infosupport.h7.mvcexample.dao;

import com.infosupport.h7.mvcexample.domain.Bezorgwijze;

import java.util.Arrays;
import java.util.List;

public class BezorgwijzeDao {

    public List<Bezorgwijze> getAll() {
        return Arrays.asList(Bezorgwijze.values());
    }


}
