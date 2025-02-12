package com.exmple;


import java.util.concurrent.atomic.AtomicBoolean;

public class Forquilla {
    private final AtomicBoolean enUs = new AtomicBoolean(false);
    public final int index;

    public Forquilla(int i) {
        index = i;
    }

    public boolean coger() {
        return enUs.compareAndSet(false, true); // Intenta coger la forquilla sin bloqueo
    }

    public void dejar() {
        enUs.set(false); // Libera la forquilla
    }

    public int getId() {
        return index;
    }
}

