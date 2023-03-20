package com.marex333.inventory.database.memory;

import com.marex333.inventory.database.IAlcoholDAO;
import com.marex333.inventory.database.sequence.AlcoholIdSequence;
import com.marex333.inventory.database.sequence.IAlcoholIdSequence;
import com.marex333.inventory.model.Alcohol;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
public class AlcoholDB implements IAlcoholDAO {
    final private List<Alcohol> alcoholList = new ArrayList<>();
    final private IAlcoholIdSequence alcoholIdSequence;

    public AlcoholDB() {
        this.alcoholIdSequence = new AlcoholIdSequence();
        alcoholList.add(new Alcohol("Campari", new Alcohol.Bottle(Alcohol.Size.ml700, 463, 1195, 2, 3, 500)));
        alcoholList.add(new Alcohol("Aperol", new Alcohol.Bottle(Alcohol.Size.ml700, 535, 1281, 2)));
        alcoholList.add(new Alcohol("Fernet", new Alcohol.Bottle(Alcohol.Size.ml700, 480, 1140, 2)));
        alcoholList.add(new Alcohol("Tia Maria", new Alcohol.Bottle(Alcohol.Size.ml1000, 702, 1778, 2)));
    }

    @Override
    public Alcohol getAlcoholByName(String name) {
        for (Alcohol alcohol : alcoholList) {
            if (alcohol.getName() == name)
                return alcohol;
        }
        return null;
    }

    @Override
    public void persistAlcohol(Alcohol alcohol) {

    }

    @Override
    public List<Alcohol> getAllAlcohols() {
        return alcoholList;
    }
}
