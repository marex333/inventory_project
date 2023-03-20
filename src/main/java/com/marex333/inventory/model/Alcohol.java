package com.marex333.inventory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

// size in millilitres
// weight in grams
public class Alcohol {
    private int id;
    private String name;
    private double totalAlcohol;
    private double alcoholWeight;
    private boolean isAlcoholPresentInAccount = false;
    private ArrayList<Bottle> listOfBottles;


    // Constructor for bottles to determine weight
    public Alcohol(String name, Bottle... bottles) {
        this.name = name;
        this.totalAlcohol = 0;
        this.listOfBottles = (ArrayList<Bottle>) Arrays.stream(bottles).toList();
        this.alcoholWeight = Arrays.stream(bottles).findFirst().orElse(new Bottle()).getAlcoholWeight();
    }
    public Alcohol() {

    }

    public void initializeTotalAlcohol() {
        double alco = 0;
        for (Bottle bottle : this.listOfBottles) {
            alco += bottle.getSize() * bottle.quantityOfFull;
            alco += bottle.getVolumeOfOpen();
        }

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

    public ArrayList<Bottle> getListOfBottles() {
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
            this.size = size.getSize();
            this.emptyWeight = emptyWeight;
            this.fullWeight = fullWeight;
            this.capWeight = capWeight;
            this.quantityOfFull = 0;
            this.volumeOfOpen = 0;
        }

        // size / (gross - tare)
        public double getAlcoholWeight() {
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
