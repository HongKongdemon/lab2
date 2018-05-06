package barBossHouse;

public class Order {
    private int size;
    private Dish[] dishes;

    public Order() {
        this(16);
    }


    public Order(int size) {
        dishes = new Dish[size];
        this.size = 0;
    }

    public Order(Dish[] dishes) {
        this.size = 0;
        for (int i = 0; i < dishes.length; i++) {
            add(dishes[i]);

        }
    }

    public boolean add(Dish dish) {
        if (size >= dishes.length)
            EnlargementOfTheArray();
        dishes[size] = dish;
        size++;
        return true;
    }

    private void EnlargementOfTheArray() {
        Dish[] dishes1 = new Dish[dishes.length * 2];
        System.arraycopy(dishes, 0, dishes1, 0, dishes.length);
        dishes = dishes1;
    }

    public boolean remove(String dishName) {
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

    public int removeAll(String dishName) {
        int count = 0;
        while (remove(dishName)) {
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
        Dish[] dishes = getDishes();
        int h = 0;
        String[] dishNames = new String[size];
        for (int i = 0; i < size; i++)
            if (!matches(dishNames, dishes[i].getName())) {
                dishNames[h++] = dishes[i].getName();
            }
        String[] dishNamesResult = new String[h];
        System.arraycopy(dishNames, 0, dishNamesResult, 0, dishNamesResult.length);
        return dishNamesResult;
    }


    private boolean matches(String[] dishNames, String dishName) {
        for (String dn : dishNames) {
            if (dn != null && dishName != null) {
                return dn.equals(dishName);
            }

        }
        return false;
    }


    public Dish[] sortedDishesByCostDesc() {
        Dish[] dishes1 = this.dishes;
        for (int i = 0; i < dishes1.length; i++) {
            for (int j = 0; j < dishes1.length - i - 1; j++) {
                if (dishes1[j].getCost() < dishes1[j + 1].getCost()) {
                    Dish temp = dishes1[j];
                    dishes1[j] = dishes1[j + 1];
                    dishes1[j + 1] = temp;
                }
            }
        }
        return dishes1;

    }
}

