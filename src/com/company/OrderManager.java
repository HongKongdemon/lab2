package com.company;

import java.util.function.Predicate;

public class OrderManager {
    private Order[] orders;

    public OrderManager(int count) {
        orders = new Order[count];
    }

    public void add(Order order, int tableNum) {
        orders[tableNum] = order;
    }

    public Order getOrder(int tableNum) {
        return orders[tableNum];
    }

    public void addDish(Dish dish, int tableNum) {
        orders[tableNum].add(dish);
    }

    public void removeOrder(int tableNum) {
        orders[tableNum] = null;
    }

    public int freeTableNum() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int[] freeTableNums() {

        Predicate<Order> isNull = s -> s==null;
        return predicateTableNums(isNull);
    }

    public int[] noFreeTableNums() {
        Predicate<Order> isNull = s -> s!=null;
        return predicateTableNums(isNull);
    }


    private int[] predicateTableNums(Predicate<Order> isNull) {
        int[] nums = new int[orders.length];
        int j = 0;
        for (int i = 0; i < nums.length && j < nums.length; i++) {
            if (isNull.test(orders[i])) {
                nums[j] = i;
                j++;
            }
        }
        int[] numsRez = new int[j];
        System.arraycopy(nums, 0, numsRez, 0, j);
        return numsRez;
    }


    public Order[] getOrders() {
        int[] noFT = noFreeTableNums();
        Order[] ordersBuf = new Order[noFT.length];
        int j = 0;
        for (int i = 0; i < noFT.length; i++) {
            ordersBuf[i] = orders[noFT[i]];
        }
        return ordersBuf;
    }

    public double ordersCostSummery() {
        double sum = 0;
        for (Order order : orders) {
            if (order != null) {
                sum += order.costTotal();
            }
        }
        return sum;
    }

    public int dishQuantity(String dishName) {
        int sum = 0;
        for (Order order : orders) {
            if (order != null) {
                sum += order.dishQuantity(dishName);
            }
        }
        return sum;
    }

}