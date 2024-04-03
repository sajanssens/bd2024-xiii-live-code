package com.infosupport.h13.boxes;
//          declaration site: T is type parameter
public class Box<T> {

    private T contents;

    public Box(T contents) {
        this.contents = contents;
    }

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }
}
