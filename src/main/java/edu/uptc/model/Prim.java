package edu.uptc.model;

import java.util.*;
import javax.swing.*;
import edu.uptc.graph.Graphs;
import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.graph.util.*;

public class Prim extends JPanel{

	/*

       Funciones definidas:
        * contains() - Devuelve si el vértice de entrada existe o no en la matriz de entrada
        * minEdge () - Dada la matriz de borde, devuelve el borde mínimamente ponderado
        * addVertex() - Agrega el vértice de entrada al gráfico de entrada
        * addEdge() - Devuelve el gráfico de entrada con borde agregado
        */


    public ArrayList<Graph<Vertex<String>, Edge>> getGraphMST(Graphs graph, Vertex[] vertex, Edge[] edge){

        ArrayList<Graph<Vertex<String>, Edge>> graphArrayList = new ArrayList<Graph<Vertex<String>,Edge>>();

        Graphs graphsProof = new Graphs();

        try {
            graphsProof.addVertex(graph.getVertex().get(0));

            while(convertGraph(graphsProof).getVertexCount() < convertGraph(graph).getVertexCount()){

                //Encuentra la arista adyacente con valor mínimo
                Edge[] adjacentEdges = adjacentEdges(graphsProof, graph);
                Edge minEdge = minEdge(adjacentEdges);

                Vertex<String> v1 = minEdge.getVertex1();
                Vertex<String> v2 = minEdge.getVertex2();

                //Agrega el vértice y luego la arista árbol de expansión mínimo
                if(graphsProof.hasVertex(v1)){
                    graphsProof.addVertex(v2);
                }
                else{
                    graphsProof.addVertex(v1);
                    minEdge.swap();
                }
                minEdge.makeDirected();
                graphsProof.addEdge(minEdge);
                graphArrayList.add(convertGraph(graphsProof));
            }
        }catch(Exception e) {}

        return graphArrayList;
    }

    //Devuelve todos los bordes en Graph adyacentes a (pero no incluidos en) los vértices del subgrafo
    public Edge[] adjacentEdges(Graphs graphOne, Graphs graphTwo){
        ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();
        ArrayList<Edge> superEdges = graphTwo.getEdges();
        ArrayList<Vertex<String>> subVertices = graphOne.getVertex();

        for(int i = 0; i<superEdges.size(); i++){
            if(contains(subVertices, superEdges.get(i).getVertex1()) != contains(subVertices, superEdges.get(i).getVertex2())){
                adjacentEdges.add(superEdges.get(i));
            }
        }
        return adjacentEdges.toArray(new Edge[adjacentEdges.size()]);
    }

    //Devuelve si el vértice de entrada está incluido o no en la matriz de vértices
    public boolean contains(ArrayList<Vertex<String>> vertices, Vertex<String> v){
        for(Vertex<String> vertex:vertices){
            if(vertex.getInfo() == v.getInfo()){
                return true;
            }
        }
        return false;
    }

    //Retorna el valor más mínimo del arbol
    public Edge minEdge(Edge[] edges){
        Edge minEdge = edges[0];
        for(Edge e:edges){
            if(e.getWeight() < minEdge.getWeight()){
                minEdge = e;
            }
        }
        return minEdge;
    }

    //Devuelve el borde mínimo en la matriz
    public Graph<Vertex<String>, Edge> convertGraph(Graphs g){
        Graph<Vertex<String>,Edge> graph = new SparseMultigraph<Vertex<String>,Edge>();
        for(Vertex<String> v:g.getVertex()){
            graph.addVertex(v);
        }

        for(Edge e:g.getEdges()){
            if(e.getDirected()){
                graph.addEdge(e, e.getVertex1(), e.getVertex2(), EdgeType.DIRECTED);
            }
            else{
                graph.addEdge(e, e.getVertex1(), e.getVertex2());
            }
        }
        return graph;
    }

}