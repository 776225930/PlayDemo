package com.jhao.playdemo.threadlocal;

import androidx.annotation.NonNull;

class Person {
    @NonNull
    public final String name;

    Person(@NonNull String name) {
        this.name = name;
    }
}