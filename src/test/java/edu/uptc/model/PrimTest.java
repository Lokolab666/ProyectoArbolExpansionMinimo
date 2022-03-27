package edu.uptc.model;

import edu.uci.ics.jung.graph.Graph;
import edu.uptc.graph.Edge;
import edu.uptc.graph.Graphs;
import edu.uptc.graph.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {
    private ArrayList<Graph<Vertex<String>, Edge>> listMST;
    private Prim prim;
    private ArrayList<Edge> edgeList;
    private ArrayList<Vertex<String>> vertexList;

    private void setup(){
        prim = new Prim();

        vertexList = new ArrayList<Vertex<String>>();
        edgeList = new ArrayList<Edge>();

        this.vertexList.add(new Vertex<String>("Z"));
        this.vertexList.add(new Vertex<String>("Y"));
        this.vertexList.add(new Vertex<String>("X"));
        this.vertexList.add(new Vertex<String>("W"));

        this.edgeList.add(new Edge(10, vertexList.get(0), vertexList.get(1)));
        this.edgeList.add(new Edge(20, vertexList.get(0), vertexList.get(2)));
        this.edgeList.add(new Edge(30, vertexList.get(2), vertexList.get(1)));
        this.edgeList.add(new Edge(40, vertexList.get(3), vertexList.get(1)));
        this.edgeList.add(new Edge(50, vertexList.get(3), vertexList.get(0)));

        listMST = prim.getGraphMST(new Graphs(vertexList, edgeList), vertexList.toArray(new Vertex[vertexList.size()]), edgeList.toArray(new Edge[edgeList.size()]));

    }

    @Test
    void getGraphMST() {
        this.setup();

        Assertions.assertEquals("[10]", listMST.get(0).getEdges().toString());
        Assertions.assertEquals("[20, 10]", listMST.get(1).getEdges().toString());
        Assertions.assertEquals("[20, 40, 10]", listMST.get(2).getEdges().toString());

        Assertions.assertEquals("[Y, Z]", listMST.get(0).getVertices().toString());
        Assertions.assertEquals("[Y, X, Z]", listMST.get(1).getVertices().toString());
        Assertions.assertEquals("[Y, X, Z, W]", listMST.get(2).getVertices().toString());

        this.vertexList.add(new Vertex<String>("V"));
        this.vertexList.add(new Vertex<String>("U"));
        this.vertexList.add(new Vertex<String>("T"));

        this.edgeList.add(new Edge(45, vertexList.get(4), vertexList.get(1)));
        this.edgeList.add(new Edge(1, vertexList.get(5), vertexList.get(4)));
        this.edgeList.add(new Edge(5, vertexList.get(5), vertexList.get(6)));
        this.edgeList.add(new Edge(15, vertexList.get(6), vertexList.get(3)));
        this.edgeList.add(new Edge(65, vertexList.get(4), vertexList.get(6)));

        listMST = prim.getGraphMST(new Graphs(vertexList, edgeList), vertexList.toArray(new Vertex[vertexList.size()]), edgeList.toArray(new Edge[edgeList.size()]));

        Assertions.assertEquals("[20, 15, 40, 10]", listMST.get(3).getEdges().toString());
        Assertions.assertEquals("[20, 5, 15, 40, 10]", listMST.get(4).getEdges().toString());
        Assertions.assertEquals("[20, 5, 15, 40, 10, 1]", listMST.get(5).getEdges().toString());

        Assertions.assertNotEquals("[Y, Z]", listMST.get(3).getVertices().toString());
        Assertions.assertEquals("[U, Y, X, Z, W, T]", listMST.get(4).getVertices().toString());
        Assertions.assertEquals("[U, Y, X, Z, W, V, T]", listMST.get(5).getVertices().toString());
    }
}