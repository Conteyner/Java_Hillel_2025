package org.lessons.lesson_5;

// Клас розрахунку вартості товару,
// враховуючи вартість доставки
// ЗАВДАННЯ: Виправити код класу.
// Клас успадковує клас CalcCostBase.
public class CalcCostDelivery extends CalcCostBase{

    // Вартість доставки
    private final static double DELIVERY_PRICE = 7;

    // Розрахунок вартості товару,
    // з урахуванням вартості доставки
    @Override
    public double calcCost(Product product) {
        return super.calcCost(product)
                + DELIVERY_PRICE;
    }
}
