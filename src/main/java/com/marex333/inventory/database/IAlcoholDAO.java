package com.marex333.inventory.database;

import com.marex333.inventory.model.Alcohol;

import java.util.List;

public interface IAlcoholDAO {
    Alcohol getAlcoholByName(String name);
    void persistAlcohol(Alcohol alcohol);
    List<Alcohol> getAllAlcohols();

}
