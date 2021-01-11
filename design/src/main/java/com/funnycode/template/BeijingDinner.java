package com.funnycode.template;

/**
 * @author tc
 * @date 2020/12/15
 */
public class BeijingDinner extends AbstractDinner {

    public BeijingDinner(String name) {
        super(name);
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
