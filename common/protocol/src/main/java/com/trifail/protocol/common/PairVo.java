package com.trifail.protocol.common;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PairVo<T,V> implements Serializable {

    @NotNull
    private T key;
    @NotNull
    private V value;

    public PairVo() {
    }

    public PairVo(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
