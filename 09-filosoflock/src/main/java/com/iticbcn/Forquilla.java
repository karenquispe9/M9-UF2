package com.iticbcn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Forquilla {
    private final int num;
    private final Lock bloqueig = new ReentrantLock();

    public Forquilla(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean agafar() {
        return bloqueig.tryLock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}