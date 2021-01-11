package com.funnycode.template;

/**
 * @author tc
 * @date 2020/12/15
 */
public class DinnerDemo {

    public static void main(String[] args) {
        System.out.println("---准备台湾餐---");
        Dinner dinner1 = new TaiwanDinner("台湾");
        dinner1.doDinner();
        System.out.println("---准备杭州餐---");
        Dinner dinner2 = new HangzhouDinner("杭州");
        dinner2.doDinner();
        System.out.println("---准备北京餐---");
        Dinner dinner3 = new BeijingDinner("北京");
        dinner3.doDinner();
    }

}
