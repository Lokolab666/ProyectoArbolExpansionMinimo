package edu.uptc.graph;

/**
 * Clase donde se crea un vertice con una información
 * @param <T>
 */
public class Vertex<T> {

    private T info;

    /**
     * Constructor principal de la clase inicializando la info del vertice
     * @param info
     */
    public Vertex(T info){
        this.info = info;
    }

    /**
     * Metodo que trae la información del vertice.
     * @return info
     */
    public T getInfo(){
        return info;
    }

    /**
     * Metodo que permite cambiar la informacion del vertice
     * @param info
     */
    public void setInfo(T info){
        this.info = info;
    }

    /**
     * Metodo To string que muestra la info del vertice
     * @return info
     */
    @Override
    public String toString() {
        return ""+info;
    }
}
