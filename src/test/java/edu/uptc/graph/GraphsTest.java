package edu.uptc.graph;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uptc.graph.Edge;
import edu.uptc.graph.Graphs;
import edu.uptc.graph.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphsTest {

    private ArrayList<Vertex<String>> vertexList;
    private ArrayList<Edge> edgeList;
    private Graphs graphs;

    private void setup(){
        vertexList = new ArrayList<Vertex<String>>();
        edgeList = new ArrayList<Edge>();
        this.graphs = new Graphs();

        this.vertexList.add(new Vertex<String>("A"));
        this.vertexList.add(new Vertex<String>("B"));
        this.vertexList.add(new Vertex<String>("C"));
        this.vertexList.add(new Vertex<String>("D"));
        this.vertexList.add(new Vertex<String>("E"));

        this.edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
        this.edgeList.add(new Edge(2, vertexList.get(1), vertexList.get(2)));
        this.edgeList.add(new Edge(6, vertexList.get(2), vertexList.get(3)));
        this.edgeList.add(new Edge(2, vertexList.get(3), vertexList.get(1)));
        this.edgeList.add(new Edge(10, vertexList.get(0), vertexList.get(2)));


        this.graphs.addVertex(vertexList.get(0));
        this.graphs.addVertex(vertexList.get(1));
        this.graphs.addVertex(vertexList.get(2));
        this.graphs.addVertex(vertexList.get(3));
        this.graphs.addVertex(vertexList.get(4));

        graphs.addEdge(new Edge(1, vertexList.get(0), vertexList.get(1)));
        graphs.addEdge(new Edge(2, vertexList.get(1), vertexList.get(2)));
        graphs.addEdge(new Edge(6, vertexList.get(2), vertexList.get(3)));
        graphs.addEdge(new Edge(16, vertexList.get(2), vertexList.get(0)));
    }

    @Test
    void hasVertex() {
        this.setup();
        Assertions.assertNotNull(graphs.hasVertex(vertexList.get(0)));
        Assertions.assertNotNull(graphs.hasVertex(vertexList.get(1)));
        Assertions.assertNotNull(graphs.hasVertex(vertexList.get(2)));
        Assertions.assertNotNull(graphs.hasVertex(vertexList.get(3)));
        Assertions.assertNotNull(graphs.hasVertex(vertexList.get(4)));
    }

    @Test
    void getCost() {
        this.setup();

        Assertions.assertEquals(25, graphs.getCost());
        Assertions.assertNotEquals(10, graphs.getCost());
    }

    @Test
    void getVertex() {
        this.setup();

        Assertions.assertEquals("A", graphs.getVertex().get(0).getInfo());
        Assertions.assertEquals("B", graphs.getVertex().get(1).getInfo());
        Assertions.assertEquals("C", graphs.getVertex().get(2).getInfo());
        Assertions.assertEquals("D", graphs.getVertex().get(3).getInfo());
        Assertions.assertNotEquals("A", graphs.getVertex().get(1).getInfo());
        Assertions.assertNotEquals("C", graphs.getVertex().get(1).getInfo());
    }

    @Test
    void addEdge() {
        this.setup();

        this.vertexList.add(new Vertex<String>("F"));
        this.vertexList.add(new Vertex<String>("G"));

        this.graphs.addVertex(vertexList.get(5));
        this.graphs.addVertex(vertexList.get(6));

        graphs.addEdge(new Edge(10, vertexList.get(5), vertexList.get(6)));

        Assertions.assertEquals("F", graphs.getVertex().get(5).getInfo());
        Assertions.assertEquals("G", graphs.getVertex().get(6).getInfo());
        Assertions.assertNotEquals("D", graphs.getVertex().get(5).getInfo());
    }

    @Test
    void getEdges() {
        this.setup();

        Assertions.assertEquals("1", graphs.getEdges().get(0).toString());
        Assertions.assertEquals("2", graphs.getEdges().get(1).toString());
        Assertions.assertEquals("6", graphs.getEdges().get(2).toString());
    }

}