package barBossHouse;

public class Test {
    private static Dish d;
    private static Order o;

    public static void main(String[] args) {
        System.out.println("Cоздаем пробный заказ в 20 блюда ");
        o = new Order();
        add();
        OrderManager om = new OrderManager(5);
        System.out.println("Помещаем заказ в менеджер на стол 1 и 3");
        om.add(o, 3);
        om.add(o, 1);
        System.out.println("Добавляем блюдо \"Фаршмак\" в заказ на 3 стол");
        d = new Dish("Фршмак", "ss,dd,ff,gg", 1);
        om.addDish(d, 3);
        int[] df = om.noFreeTableNums();
        System.out.print("Занятые столы  ");
        for (int dd : df) {
            System.out.print(dd + " ");
        }
        System.out.println("\nПервый свободнй стол " + om.freeTableNum() + "     \nОбщая стоимость заказов " + om.ordersCostSummery());
        System.out.println("Всего заказно блюд с именем \"сx\" " + om.dishQuantity("cx"));
        System.out.println("Удалим заказ с 1 стола");
        om.removeOrder(1);
        int[] dsf = om.noFreeTableNums();
        System.out.print("Занятые столы  ");
        for (int dsd : dsf) {
            System.out.print(dsd + " ");
        }

        o = om.getOrder(3);
        Dish[] dis = o.getDishes();

        System.out.println("\n\nВсего блюд в заказе 3 стола " + o.dishQuantity());
        String[] st = o.dishesNames();
        System.out.print("Названия блюд в заказе без повторов  ");
        for (String sdf : st) {
            System.out.print(sdf + " ");
        }
        System.out.println("\nУдалить все блюда с названием \"cx\", удалено " +
                o.removeAll("cx") + ", осталось " + o.dishQuantity());


    }


    private static void add() {
        d = new Dish("Фаршмак", "ss,dd,ff,gg", 1);
        o.add(d);
        d = new Dish("торт Улыбка негра", "ss,dd,ff,gg", 2);
        o.add(d);
        d = new Dish("Ленивые вареники", "ss,dd,ff,gg", 3);
        o.add(d);
        d = new Dish("Драники", "ss,dd,ff,gg", 4);
        o.add(d);
        d = new Dish("Драчона" , "ss,dd,ff,gg", 5);
        o.add(d);
        d = new Dish("Чевапчичи", "ss,dd,ff,gg", 6);
        o.add(d);
        d = new Dish("Кулебяки" , "ss,dd,ff,gg",+ 7);
        o.add(d);
        d = new Dish("Тещин язык", "ss,dd,ff,gg", 6);
        o.add(d);
        d = new Dish("Позы", "ss,dd,ff,gg", 5);
        o.add(d);
        d = new Dish("Вареный каракуц", "ss,dd,ff,gg", 4);
        o.add(d);
        d = new Dish("Гнездо глухаря", "ss,dd,ff,gg", 3);
        o.add(d);
        d = new Dish("Аджабсандал", "ss,dd,ff,gg", 2);
        o.add(d);
        d = new Dish("Рольмопс", "ss,dd,ff,gg", 4);
        o.add(d);
        d = new Dish("Ципиллины", "ss,dd,ff,gg", 6);
        o.add(d);
        d = new Dish("Цыпленок табака", "ss,dd,ff,gg", 4);
        o.add(d);
        d = new Dish("Мавр в рубашке", "ss,dd,ff,gg", 6);
        o.add(d);
        d = new Dish("Мастурба", "ss,dd,ff,gg", 5);
        o.add(d);
        d = new Dish("Овсянка \"Сэр\"", "ss,dd,ff,gg", 3);
        o.add(d);
        d = new Dish("cx", "ss,dd,ff,gg", 5);
        o.add(d);
        d = new Dish("cx", "ss,dd,ff,gg", 5);
        o.add(d);
    }
}
