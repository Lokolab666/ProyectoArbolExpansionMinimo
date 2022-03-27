package edu.uptc.graph;

public class Edge {
    private int weight;
    private Vertex<String> v1;
    private Vertex<String> v2;
    private boolean directed = false;

    public Edge(int weight, Vertex<String> value1, Vertex<String> value2){
        this.weight=weight;
        v1= value1;
        v2= value2;
    }

    public Edge(int weight, Vertex<String> value1, Vertex<String> value2, boolean directed){
        this.weight=weight;
        v1= value1;
        v2= value2;
        this.directed=directed;
    }

    //Devuelve si la arista incide o no en el vértice de entrada
    public boolean incident(Vertex<String> vertex){
        return vertex.getInfo()==v1.getInfo() || vertex.getInfo()==v2.getInfo();
    }

    public Vertex<String> getVertex1(){
        return v1;
    }

    public Vertex<String> getVertex2(){
        return v2;
    }

    public int getWeight(){
        return weight;
    }

    public boolean getDirected(){
        return directed;
    }

    public void makeDirected(){
        directed=true;
    }

    public void swap(){
        Vertex<String> temp=v2;
        v2=v1;
        v1=temp;
    }

    public String toString(){
        return ""+weight;
    }
}
