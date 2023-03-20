package com.marex333.inventory.model;

import java.util.ArrayList;
import java.util.List;

// size in millilitres
// weight in grams
public class Alcohol {
    private int id;
    private String name;
    private double totalAlcohol = initializeTotalAlcohol();
    private double alcoholWeight;
    private boolean isAlcoholPresentInAccount = false;
    private List<Bottle> listOfBottles;

    public Alcohol(){}
    // Constructor determine alcoholWeight as TARE of Bottle. Bottle need empty + full weights!
    public Alcohol(String name, Bottle... bottles){
        this.name = name;
        listOfBottles = new ArrayList<>(List.of(bottles));
        this.alcoholWeight = bottles[0].calculateAlcoholWeight();
    }
    // Constructor takes alcoholWeight from argument.
    public Alcohol(String name, double alcoholWeight, Bottle... bottles) {
        this.name = name;
        this.alcoholWeight = alcoholWeight;
        this.listOfBottles = new ArrayList<>(List.of(bottles));
    }

    private double initializeTotalAlcohol() {
        double total = 0;
        for (Bottle bottle : this.listOfBottles) {
            total += bottle.getSize() * bottle.quantityOfFull;
            total += bottle.getVolumeOfOpen();
        }
        return total;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bottle> getListOfBottles() {
        return listOfBottles;
    }

    public void setListOfBottles(ArrayList<Bottle> listOfBottles) {
        this.listOfBottles = listOfBottles;
    }

    public double getTotalAlcohol() {
        return totalAlcohol;
    }

    public void setTotalAlcohol(double totalAlcohol) {
        this.totalAlcohol = totalAlcohol;
    }

    public double getAlcoholWeight() {
        return alcoholWeight;
    }

    public boolean isAlcoholPresentInAccount() {
        return isAlcoholPresentInAccount;
    }

    public void setAlcoholPresentInAccount(boolean alcoholPresentInAccount) {
        isAlcoholPresentInAccount = alcoholPresentInAccount;
    }
    public String toString() {
        return "id: " + this.id +
                "\nname: " + this.name +
                "\ntotal alcohol: " + this.totalAlcohol +
                "\nalco weight: " + this.alcoholWeight +
                "\nisAlcoholPresentInAccount: " + this.isAlcoholPresentInAccount +
                "\nList of Bottles: " + this.listOfBottles;
    }
    public static class AlcoholBuilder {
        Alcohol alcohol = new Alcohol();
        public AlcoholBuilder name(String name) {
            this.alcohol.setName(name);
            return this;
        }
        public AlcoholBuilder bottle(Bottle bottle) {
            this.alcohol.listOfBottles.add(bottle);
            return this;
        }
    }

    public static class Bottle {
        private int size;
        private double emptyWeight;
        private double fullWeight;
        private double capWeight;
        private int quantityOfFull;
        private double volumeOfOpen;

        Bottle() {
            this.quantityOfFull = 0;
            this.volumeOfOpen = 0;
        }
        public Bottle(Size size, double emptyWeight, double fullWeight, double capWeight) {
            this(size, emptyWeight, fullWeight, capWeight, 0, 0);
        }
        public Bottle(Size size, double emptyWeight, double fullWeight, double capWeight, int quantityOfFull, double volumeOfOpen){
            this.size = size.getSize();
            this.emptyWeight = emptyWeight;
            this.fullWeight = fullWeight;
            this.capWeight = capWeight;
            this.quantityOfFull = quantityOfFull;
            this.volumeOfOpen = volumeOfOpen;

        }

        // size / (gross - tare)
        public double calculateAlcoholWeight() {
            return this.size / (this.fullWeight - this.emptyWeight);
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public double getEmptyWeight() {
            return emptyWeight;
        }

        public void setEmptyWeight(double emptyWeight) {
            this.emptyWeight = emptyWeight;
        }

        public double getFullWeight() {
            return fullWeight;
        }

        public void setFullWeight(double fullWeight) {
            this.fullWeight = fullWeight;
        }

        public double getCapWeight() {
            return capWeight;
        }

        public void setCapWeight(double capWeight) {
            this.capWeight = capWeight;
        }

        public int getQuantityOfFull() {
            return quantityOfFull;
        }

        public void setQuantityOfFull(int quantityOfFull) {
            this.quantityOfFull = quantityOfFull;
        }

        public double getVolumeOfOpen() {
            return volumeOfOpen;
        }

        public void setVolumeOfOpen(double volumeOfOpen) {
            this.volumeOfOpen = volumeOfOpen;
        }
    }
    public enum Size {
        ml200(200),
        ml250(250),
        ml500(500),
        ml700(700),
        ml750(750),
        ml1000(1000),
        ml1500(1500),
        ml3000(3000);

        private final int size;

        Size(int size) {
            this.size = size;
        }
        int getSize() {
            return this.size;
        }
    }
}
