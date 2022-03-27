package edu.uptc.view;

import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.Graph;

/**
 * Clase abstracta de interfaces que permite tener las acciones del arbol de expansión minima.
 */
public interface Actions {

    public static final String CLOSE = "close";
    public static final String RESET = "reset";

    public static final String VERTEX = "vertex";
    public static final String EDGE = "edge";
    public static final String ORIGIN = "origin";
    public static final String DESTINY = "destiny";

    public static final String PREVIOUS = "previous";
    public static final String NEXT = "next";

    public static final String GRAPH = "graph";
    public static final String GRAPHMST = "graphmst";

    /**
     * Metodo que permite conocer si algun atributo esta siendo usado
     * @param section - la seccion capturada
     */
    public String[] capture(String section);

    /**
     * Metodo que permite mostrar los datos y la seccion seleccionada
     * @param section
     * @param data
     */
    public void show(String section, String[] data);

    /**
     * Metodo que permite mostrar el grafo.
     * @param section
     * @param graph
     */
    public void showGraph(String section, Graph<Vertex<String>,Edge> graph);

    /**
     * Metodo que permite limpiar los campos introducidos en el panel
     * @param section
     */
    public void clear(String section);
}
