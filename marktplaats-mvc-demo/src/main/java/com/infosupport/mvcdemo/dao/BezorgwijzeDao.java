package com.infosupport.mvcdemo.dao;

import com.infosupport.mvcdemo.domain.Bezorgwijze;

import java.util.Arrays;
import java.util.List;

public class BezorgwijzeDao {

    public List<Bezorgwijze> getAll() {
        return Arrays.asList(Bezorgwijze.values());
    }


}
