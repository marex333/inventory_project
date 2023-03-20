package com.marex333.inventory.database;

import com.marex333.inventory.model.Alcohol;

public interface IAlcoholDAO {
    Alcohol getAlcoholByName(String name);
    void persistAlcohol(Alcohol alcohol);

}
