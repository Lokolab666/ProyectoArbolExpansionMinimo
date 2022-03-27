package edu.uptc.graph;

public class Vertex<T> {

    private T info;

    public Vertex(T info){
        this.info = info;
    }

    public T getInfo(){
        return info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    @Override
    public String toString() {
        return ""+info;
    }
}
