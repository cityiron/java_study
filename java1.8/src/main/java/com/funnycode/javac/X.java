package com.funnycode.javac;

/**
 * @author tc
 * @date 2021/1/25
 */
public class X {

    int a, b;
    volatile int v, u;
    void f(){
        int i, j;

        i = a;
        j = b;
        i = v;

        j = u;

        a = i;
        b = j;

        v = i;

        u = j;

        i = u;

        j = b;
        a = i;
    }

}
