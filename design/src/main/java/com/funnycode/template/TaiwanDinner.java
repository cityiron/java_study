package com.funnycode.template;

/**
 * @author tc
 * @date 2020/12/15
 */
public class TaiwanDinner extends AbstractDinner {

    public TaiwanDinner(String name) {
        super(name);
    }

    @Override
    protected boolean foodEnough() {
        // 每次都买食物
        return false;
    }

    @Override
    protected void doShopping() {
        System.out.println("生鲜超市购买，一定要买茶叶蛋");
    }

    @Override
    protected void beforeCooking() {
        System.out.printf("%sMM 在洗菜切菜", name).println();
    }

    @Override
    protected String doCooking() {
        return name + "MM 在做" + name + "菜";
    }

    @Override
    protected void afterCooking() {
        System.out.printf("%sMM 让你去品尝", name).println();
    }

}
