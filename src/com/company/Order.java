package com.company;

public class Order {
    private int size;
    private Dish[] dishes;

    public Order () {this ( 16);}

    public Order (int size){
        dishes = new Dish[size];
        this.size = 0;
    }
    public Order (Dish[] dishes){
        this.dishes = dishes;
        this.size = 0;
    }

    public boolean add (Dish dish){
        if (size >= dishes.length)
        dishes[size] = dish;
        size++;
        return true;
    }
   public boolean remove(String dishName){
       for (int i = 0; i < size; i++) {

           if (dishes[i].getName().equals(dishName)) {

               for (int j = i; j < size; j++) {
                   dishes[j] = dishes[j + 1];

                   if (j == size) {
                       dishes[j + 1] = null;
                   }
               }
               size--;
               return true;
           }
       }
       return false;
    }

    public int removeAll (String dishName){
    int count = 0;
        while (remove(dishName)){
            count++;
        }
        return count;
    }
    public int dishQuantity() {
        return size;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (Dish dish : dishes) {
            if (dish != null && (dish.getName().equals(dishName))) {
                count++;
            }
        }
        return count;
    }

        public Dish[] getDishes() {
            Dish[] dishef = new Dish[dishQuantity()];
            System.arraycopy(dishes, 0, dishes, 0, dishes.length);
            return dishes;
    }
    public double costTotal() {
        double sum = 0;
        for (Dish dish : dishes) {
            if (dish != null) {
                sum += dish.getCost();
            }
        }
        return sum;
    }
    public String[] dishesNames() {
        int h = 0;
        String[] dishNames = new String[size];
        for (int i = 0; i < size; i++) {
            if (!prover(dishNames, dishes[i].getName())) {
                dishNames[h++] = dishes[i].getName();
            }
        }
        String[] dishNamesResult = new String[h];
        System.arraycopy(dishNames, 0, dishNamesResult, 0, dishNamesResult.length);
        return dishNamesResult;
    }


    private boolean prover(String[] dishNames, String dishName) {
        for (int i = 0; i < dishNames.length; i++) {
            String dn = dishNames[i];
            if (dn != null && dn.equals(dishName))
                return true;
        }
        return false;
    }
    public Dish [] sortedDishesByCostDesc() {

        for (int i = 0; i <dishes.length; i++)
        {
            for (int j = 0; j < dishes.length - i - 1 ; j++)
            {
                if (dishes[j].getCost() < dishes[j + 1].getCost())
                {
                    Dish temp = dishes[j];
                    dishes[j] = dishes[j + 1];
                    dishes[j + 1] = temp;
                }
            }
        }

    }
}

