package edu.uptc.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    private ArrayList<Edge> edgeList;
    private ArrayList<Vertex<String>> vertexList;

    private void setup(){
        vertexList = new ArrayList<Vertex<String>>();
        edgeList = new ArrayList<Edge>();

        this.vertexList.add(new Vertex<String>("E"));
        this.vertexList.add(new Vertex<String>("F"));
        this.vertexList.add(new Vertex<String>("G"));
        this.vertexList.add(new Vertex<String>("H"));

        this.edgeList.add(new Edge(10, vertexList.get(0), vertexList.get(1)));
        this.edgeList.add(new Edge(20, vertexList.get(0), vertexList.get(2)));
        this.edgeList.add(new Edge(30, vertexList.get(2), vertexList.get(1)));
        this.edgeList.add(new Edge(40, vertexList.get(3), vertexList.get(1)));
        this.edgeList.add(new Edge(50, vertexList.get(3), vertexList.get(0)));

    }

    @Test
    void getInfo() {
        setup();

        Assertions.assertEquals("E", vertexList.get(0).getInfo());
        Assertions.assertEquals("F", vertexList.get(1).getInfo());
        Assertions.assertEquals("G", vertexList.get(2).getInfo());
        Assertions.assertNotNull(edgeList.get(0).getVertex1().getInfo());

    }

    @Test
    void setInfo() {
        setup();

        vertexList.get(1).setInfo("I");

        Assertions.assertNotEquals("F", vertexList.get(1).getInfo());
        Assertions.assertEquals("I", vertexList.get(1).getInfo());

        vertexList.get(0).setInfo("J");
        vertexList.get(2).setInfo("K");
        vertexList.get(3).setInfo("L");

        Assertions.assertNotEquals("E", vertexList.get(0).getInfo());
        Assertions.assertEquals("J", vertexList.get(0).getInfo());
        Assertions.assertNotEquals("G", vertexList.get(2).getInfo());
        Assertions.assertEquals("K", vertexList.get(2).getInfo());
        Assertions.assertNotEquals("H", vertexList.get(3).getInfo());
        Assertions.assertEquals("L", vertexList.get(3).getInfo());
    }

}