package edu.uptc.graph;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    private ArrayList<Edge> edgeList;
    private ArrayList<Vertex<String>> vertexList;

    private void setup(){
        vertexList = new ArrayList<Vertex<String>>();
        edgeList = new ArrayList<Edge>();

        this.vertexList.add(new Vertex<String>("A"));
        this.vertexList.add(new Vertex<String>("B"));
        this.vertexList.add(new Vertex<String>("C"));
        this.vertexList.add(new Vertex<String>("D"));

        this.edgeList.add(new Edge(10, vertexList.get(0), vertexList.get(1)));
        this.edgeList.add(new Edge(20, vertexList.get(0), vertexList.get(2)));
        this.edgeList.add(new Edge(30, vertexList.get(2), vertexList.get(1)));
        this.edgeList.add(new Edge(40, vertexList.get(3), vertexList.get(1)));
        this.edgeList.add(new Edge(50, vertexList.get(3), vertexList.get(0)));


    }

    @Test
    void incident() {
    }

    @Test
    void getVertex1() {
        this.setup();

        Assertions.assertEquals("A", edgeList.get(0).getVertex1().getInfo());
        Assertions.assertEquals("A", edgeList.get(1).getVertex1().getInfo());
        Assertions.assertEquals("C", edgeList.get(2).getVertex1().getInfo());
        Assertions.assertNotEquals("C", edgeList.get(3).getVertex1().getInfo());
    }

    @Test
    void getVertex2() {
        this.setup();

        Assertions.assertEquals("B", edgeList.get(0).getVertex2().getInfo());
        Assertions.assertEquals("C", edgeList.get(1).getVertex2().getInfo());
        Assertions.assertEquals("B", edgeList.get(2).getVertex2().getInfo());
        Assertions.assertNotEquals("A", edgeList.get(3).getVertex2().getInfo());
    }

    @Test
    void getWeight() {
        this.setup();

        Assertions.assertEquals(30, edgeList.get(2).getWeight());
        Assertions.assertEquals(40, edgeList.get(3).getWeight());
        Assertions.assertEquals(10, edgeList.get(0).getWeight());
    }

    @Test
    void getDirected() {
        this.setup();

        Assertions.assertFalse(edgeList.get(3).getDirected());
        Assertions.assertFalse(edgeList.get(0).getDirected());
        Assertions.assertFalse(edgeList.get(2).getDirected());
    }

    @Test
    void makeDirected() {
        this.setup();

        this.vertexList.add(new Vertex<String>("E"));
        this.edgeList.add(new Edge(60, vertexList.get(4), vertexList.get(3)));

        edgeList.get(4).makeDirected();

        Assertions.assertTrue(edgeList.get(4).getDirected());
        Assertions.assertFalse(edgeList.get(0).getDirected());
        Assertions.assertFalse(edgeList.get(1).getDirected());

        edgeList.get(3).makeDirected();
        Assertions.assertTrue(edgeList.get(3).getDirected());
    }

    @Test
    void swap() {
        this.setup();

        edgeList.get(2).swap();
        Assertions.assertEquals("B", edgeList.get(2).getVertex1().getInfo());
        Assertions.assertEquals("A", edgeList.get(1).getVertex1().getInfo());
        Assertions.assertEquals("D", edgeList.get(3).getVertex1().getInfo());

        edgeList.get(3).swap();
        Assertions.assertEquals("B", edgeList.get(3).getVertex1().getInfo());
        Assertions.assertEquals("A", edgeList.get(1).getVertex1().getInfo());
    }

}