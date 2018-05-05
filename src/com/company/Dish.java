package com.company;

public class Dish {
    private double cost;
    private String name;

    private String descpription;
    private static int zero = 0;

    public Dish( String name, String descpription) {
        this(name, descpription, zero);
    }

    public Dish(String name, String descpription, double cost) {
        this.name = name;
        this.descpription = descpription;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescpription() {
        return descpription;
    }

    public void setDescpription(String descpription) {
        this.descpription = descpription;
    }
}
}
