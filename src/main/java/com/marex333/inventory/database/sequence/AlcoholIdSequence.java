package com.marex333.inventory.database.sequence;

public class AlcoholIdSequence implements IAlcoholIdSequence {
    private int id = 0;
    @Override
    public int getId() {
        return ++this.id;
    }
}
