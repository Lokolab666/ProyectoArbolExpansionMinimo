package edu.uptc.view;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;

import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.Graph;

/**
 * Clase que permite mostrar el panel del grafo completo y el del arbol de expansion minima
 */
public class showGraphPanel extends JDialog implements Actions{

    private GraphPanel gpGraph;
    private TreePanel tpTreeMST;

    /**
     * Constructor que permite inicializar los atributos de este panel
     * @param frame the frame
     */
    public showGraphPanel(JFrame frame) {
//		super(frame, true);
        setLayout(null);
        setSize(500, 561);
        setResizable(false);
        setUndecorated(true);
    }

    /**
     * Metodo en el que se inicializan la vista de los paneles
     */
    private void initialize(String section, Graph<Vertex<String>, Edge> graph) {
        switch(section) {
            case Actions.GRAPH:
                gpGraph = new GraphPanel(graph, Color.RED);
                gpGraph.setBounds(0, 0, 500, 561);
                break;

            case Actions.GRAPHMST:
                tpTreeMST = new TreePanel(graph, Color.GREEN);
                tpTreeMST.setBounds(0, 0, 500, 561);
                break;
        }
    }

    /**
     * Metod que permite insertar un grafo al panel de acuerdo a la seccion dada
     * @param section
     */
    private void insert(String section) {
        switch(section) {
            case Actions.GRAPH:
                add(gpGraph);
                break;

            case Actions.GRAPHMST:
                add(tpTreeMST);
                break;
        }
    }


    /**
     * Metodo que permite conocer si algun atributo esta siendo usado
     * @param section - la seccion capturada
     */
    @Override
    public String[] capture(String section) {return null;}

    /**
     * Metodo que permiet mostrar los datos en la seccion puesta
     * @param section
     * @param data
     */
    @Override
    public void show(String section, String[] data) {}

    /**
     * Metodo que permite mostrar el grafo
     * @param section
     * @param graph
     */
    @Override
    public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {
        initialize(section, graph);
        insert(section);
    }

    /**
     * Metodo que permite limpiar los datos del panel
     * @param section
     */
    public void clear(String section) {}

}
