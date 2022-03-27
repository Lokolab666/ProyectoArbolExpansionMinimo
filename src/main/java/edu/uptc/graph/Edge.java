package edu.uptc.graph;

/**
 * Clase donde se hace una arista.
 */
public class Edge {
    private int weight;
    private Vertex<String> v1;
    private Vertex<String> v2;
    private boolean directed = false;

    /**
     * Constructor principal de la clase que permite inicializar los atributos de las aristas sin dirección
     * @param weight
     * @param value1
     * @param value2
     */
    public Edge(int weight, Vertex<String> value1, Vertex<String> value2){
        this.weight=weight;
        v1= value1;
        v2= value2;
    }

    /**
     *Constructor principal de la clase que permite inicializar los atributos de las aristas con dirección
     * @param weight
     * @param value1
     * @param value2
     * @param directed
     */
    public Edge(int weight, Vertex<String> value1, Vertex<String> value2, boolean directed){
        this.weight=weight;
        v1= value1;
        v2= value2;
        this.directed=directed;
    }

    /**
     * Metodo que Devuelve si la arista incide o no en el vértice de entrada
     * @param vertex
     * @return la informacion de los vertices si es igual a la arista dada
     */
    public boolean incident(Vertex<String> vertex){
        return vertex.getInfo()==v1.getInfo() || vertex.getInfo()==v2.getInfo();
    }

    /**
     * Metodo que permite obtener un vertice
     * @return vertice1
     */
    public Vertex<String> getVertex1(){
        return v1;
    }

    /**
     * Metodo que permite obtener un vertice
     * @return vertice2
     */
    public Vertex<String> getVertex2(){
        return v2;
    }

    /**
     * Metodo que permite obtener el peso de la arista
     * @return peso
     */
    public int getWeight(){
        return weight;
    }

    /**
     * Metodo que permite obtener la dirección de la arista
     * @return dirección
     */
    public boolean getDirected(){
        return directed;
    }

    /**
     * Metodo que permite hacer directo una arista
     * @return booleano que define si es directo o no
     */
    public void makeDirected(){
        directed=true;
    }

    /**
     * Metodo que almacena una variable de intercambio para que el vertice 2 sea el vertice 1 y contrariamente
     */
    public void swap(){
        Vertex<String> temp=v2;
        v2=v1;
        v1=temp;
    }

    /**
     * Metodo To string que muestra los datos del peso del grafo de forma textual
     * @return peso
     */
    public String toString(){
        return ""+weight;
    }
}
