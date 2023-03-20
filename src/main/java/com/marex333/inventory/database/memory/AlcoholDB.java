package com.marex333.inventory.database.memory;

import com.marex333.inventory.database.IAlcoholDAO;
import com.marex333.inventory.database.sequence.AlcoholIdSequence;
import com.marex333.inventory.database.sequence.IAlcoholIdSequence;
import com.marex333.inventory.model.Alcohol;

import java.util.ArrayList;
import java.util.List;

public class AlcoholDB implements IAlcoholDAO {
    final private List<Alcohol> alcoholList = new ArrayList<>();
    final private IAlcoholIdSequence alcoholIdSequence;

    public AlcoholDB() {
        this.alcoholIdSequence = new AlcoholIdSequence();
        alcoholList.add(new Alcohol("Campari", new Alcohol.Bottle(Alcohol.Size.ml750, 200, 1200, 5)));
        alcoholList.add(new Alcohol("Baileys", new Alcohol.Bottle(Alcohol.Size.ml750, 200, 1200, 5)));
        alcoholList.add(new Alcohol("Fernet", new Alcohol.Bottle(Alcohol.Size.ml750, 200, 1200, 5)));
        alcoholList.add(new Alcohol("Tia Maria", new Alcohol.Bottle(Alcohol.Size.ml750, 200, 1200, 5)));
    }

    @Override
    public Alcohol getAlcoholByName(String name) {
        return null;
    }

    @Override
    public void persistAlcohol(Alcohol alcohol) {

    }
}
