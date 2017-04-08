package cn.v5cn.v5cms.util;

/**
 * Created by ZYW on 2014/11/7.
 */
public class TwoTuple<A,B> {
    public final A a;
    public final B b;

    public TwoTuple(A a,B b){
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }
}
