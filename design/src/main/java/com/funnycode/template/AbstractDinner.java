package com.funnycode.template;

/**
 * @author tc
 * @date 2020/12/15
 */
public abstract class AbstractDinner implements Dinner {

    protected String name;

    public AbstractDinner(String name) {
        this.name = name;
    }

    private void eat() {
        System.out.printf("%sMM说：开吃喽", name).println();
    }

    protected boolean foodEnough() {
        return true;
    }

    protected void doShopping() {
        System.out.println("门口小贩买菜");
    }

    protected abstract void beforeCooking();

    protected abstract String doCooking();

    protected abstract void afterCooking();

    @Override
    public void doDinner() {
        if (!foodEnough()) {
            doShopping();
        }

        beforeCooking();
        System.out.println(doCooking());
        afterCooking();

        eat();
    }

}
