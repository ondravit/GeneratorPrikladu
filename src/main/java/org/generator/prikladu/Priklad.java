package org.generator.prikladu;

public class Priklad {
    private final int a;
    private final String oper;
    private final int b;

    public Priklad(int a, String oper, int b) {
        this.a = a;
        this.oper = oper;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public String getOper() {
        return oper;
    }

}
