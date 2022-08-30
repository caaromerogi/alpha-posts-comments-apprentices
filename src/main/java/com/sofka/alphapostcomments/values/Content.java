package com.sofka.alphapostcomments.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Content implements ValueObject<String> {
    private String value;

    @Override
    public String value() {
        return value;
    }

    public Content(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO melodic instrument can't be blank");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content that = (Content) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
