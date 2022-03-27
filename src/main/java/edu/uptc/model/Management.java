package edu.uptc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Clase que permite el manejo de los datos del grafo pintado o a pintar
 */
public class Management{

    private Graph<Vertex<String>, Edge> graph;
    private ArrayList<Vertex<String>> vertexList;
    private ArrayList<Edge> edgeList;
    private ArrayList<Graph<Vertex<String>, Edge>> listMST;
    private int index;
    private Prim prim;

    /**
     * Contructor principal de la clase donde permite inicializar ciertos atributos necesarios
     */
    public Management() {
        index = 0;
        prim = new Prim();
        vertexList = new ArrayList<Vertex<String>>();
        edgeList = new ArrayList<Edge>();
        graph = new SparseMultigraph<Vertex<String>,Edge>();
        problemOne();
        resetMST();
    }
    /**
     * Metodo que permite poner en un reincio el panel, vertices y aristas puestas
     */
    public void reset() {
        vertexList = new ArrayList<Vertex<String>>();
        edgeList = new ArrayList<Edge>();
        graph = new SparseMultigraph<Vertex<String>,Edge>();

        resetMST();
    }

    public void problemOne(){

        // Agregar nodos
        vertexList.add(new Vertex<String>("SE"));
        vertexList.add(new Vertex<String>("LA"));
        vertexList.add(new Vertex<String>("DE"));
        vertexList.add(new Vertex<String>("DA"));
        vertexList.add(new Vertex<String>("CH"));
        vertexList.add(new Vertex<String>("NY"));
        vertexList.add(new Vertex<String>("DC"));

        //Unir los dos nodos con su distancia
        edgeList.add(new Edge(1100, vertexList.get(0), vertexList.get(1)));
        edgeList.add(new Edge(2000, vertexList.get(0), vertexList.get(4)));
        edgeList.add(new Edge(1300, vertexList.get(0), vertexList.get(2)));
        edgeList.add(new Edge(2000, vertexList.get(1), vertexList.get(4)));
        edgeList.add(new Edge(2600, vertexList.get(1), vertexList.get(6)));
        edgeList.add(new Edge(1400, vertexList.get(1), vertexList.get(3)));
        edgeList.add(new Edge(1000, vertexList.get(2), vertexList.get(4)));
        edgeList.add(new Edge(780, vertexList.get(2), vertexList.get(3)));
        edgeList.add(new Edge(900, vertexList.get(3), vertexList.get(4)));
        edgeList.add(new Edge(1300, vertexList.get(3), vertexList.get(6)));
        edgeList.add(new Edge(800, vertexList.get(4), vertexList.get(5)));
        edgeList.add(new Edge(200, vertexList.get(5), vertexList.get(6)));

        genesis();
    }

    public void problemTwo(){
        vertexList.add(new Vertex<String>("1"));
        vertexList.add(new Vertex<String>("2"));
        vertexList.add(new Vertex<String>("3"));
        vertexList.add(new Vertex<String>("4"));
        vertexList.add(new Vertex<String>("5"));
        vertexList.add(new Vertex<String>("6"));
        vertexList.add(new Vertex<String>("7"));
        vertexList.add(new Vertex<String>("8"));
        vertexList.add(new Vertex<String>("9"));

        edgeList.add(new Edge(5, vertexList.get(0), vertexList.get(1)));
        edgeList.add(new Edge(9, vertexList.get(0), vertexList.get(2)));
        edgeList.add(new Edge(20, vertexList.get(0), vertexList.get(3)));
        edgeList.add(new Edge(4, vertexList.get(0), vertexList.get(4)));
        edgeList.add(new Edge(14, vertexList.get(0), vertexList.get(7)));
        edgeList.add(new Edge(15, vertexList.get(0), vertexList.get(8)));

        edgeList.add(new Edge(6, vertexList.get(1), vertexList.get(2)));
        edgeList.add(new Edge(15, vertexList.get(2), vertexList.get(3)));
        edgeList.add(new Edge(10, vertexList.get(2), vertexList.get(4)));
        edgeList.add(new Edge(20, vertexList.get(3), vertexList.get(4)));
        edgeList.add(new Edge(12, vertexList.get(3), vertexList.get(6)));
        edgeList.add(new Edge(7, vertexList.get(3), vertexList.get(5)));
        edgeList.add(new Edge(3, vertexList.get(4), vertexList.get(5)));
        edgeList.add(new Edge(5, vertexList.get(4), vertexList.get(6)));
        edgeList.add(new Edge(13, vertexList.get(4), vertexList.get(7)));
        edgeList.add(new Edge(6, vertexList.get(4), vertexList.get(8)));

        edgeList.add(new Edge(7, vertexList.get(6), vertexList.get(7)));
        edgeList.add(new Edge(5, vertexList.get(7), vertexList.get(8)));

        genesis();
    }

    /**
     * Metodo que permite colocar datos pre-inicializados
     */
    private void genesis() {

        for(int i = 0; i < vertexList.size(); i++){
            graph.addVertex(vertexList.get(i));
        }

        for(int i = 0; i < edgeList.size(); i++){
            if(edgeList.get(i).getDirected()){
                graph.addEdge(edgeList.get(i), edgeList.get(i).getVertex1(), edgeList.get(i).getVertex2(), EdgeType.DIRECTED);
            }
            else{
                graph.addEdge(edgeList.get(i), edgeList.get(i).getVertex1(), edgeList.get(i).getVertex2());
            }
        }
    }

    /**
     * Metodo que permite crear una cara o vertice de acuerdo a un dato ingresado
     * @param data Vector lleno de los datos para crear el valor de la arista
     */
    public void createEdge(String[] data) {
        try {
            edgeList.add(new Edge(Integer.parseInt(data[1]), vertexList.get(Integer.parseInt(data[0])), vertexList.get(Integer.parseInt(data[2]))));
            graph.addEdge(edgeList.get(edgeList.size()-1), edgeList.get(edgeList.size()-1).getVertex1(), edgeList.get(edgeList.size()-1).getVertex2());
        } catch (Exception e) {}
    }

    public void createVertex(String data) {
        vertexList.add(new Vertex<String>(data));
        graph.addVertex(vertexList.get(vertexList.size()-1));

    }

    public String[] getVertex() {
        String[] data = new String[vertexList.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = vertexList.get(i).getInfo();
        }
        return data;
    }

    public void resetMST() {
        index=0;
        listMST = prim.getGraphMST(new Graphs(vertexList, edgeList), vertexList.toArray(new Vertex[vertexList.size()]), edgeList.toArray(new Edge[edgeList.size()]));
    }

    public Graph<Vertex<String>, Edge> getGraph() {
        return graph;
    }

    public void nextIndex() {
        if(index<listMST.size()-1) {
            index++;
        }
    }

    public void previousIndex() {
        if(index>0) {
            index--;
        }
    }

    public Graph<Vertex<String>, Edge> getGraphMST() {
        Graph<Vertex<String>, Edge> gMST = new DelegateForest<>();
        if (listMST.size()>0) {
            Graph<Vertex<String>, Edge> graph = listMST.get(index);
            Collection<Vertex<String>> vertexCollection = graph.getVertices();
            for (Iterator<Vertex<String>> iterator = vertexCollection.iterator(); iterator.hasNext();) {
                Vertex<String> vertex = (Vertex<String>) iterator.next();
                gMST.addVertex(vertex);
            }
            Collection<Edge> edgeCollection = graph.getEdges();
            for (Iterator<Edge> iterator = edgeCollection.iterator(); iterator.hasNext();) {
                Edge edge = (Edge) iterator.next();
                gMST.addEdge(edge, edge.getVertex1(), edge.getVertex2());
            }
        }
        return gMST ;
    }
}