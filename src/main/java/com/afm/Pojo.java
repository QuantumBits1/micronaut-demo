package com.afm;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Pojo {
    private String value;

    public Pojo(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
