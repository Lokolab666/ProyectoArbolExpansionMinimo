package edu.uptc.graph;

import java.util.ArrayList;

public class Graphs {

        //Clase de gráfico con ciertos algoritmos incorporados

        private ArrayList<Edge> edge;
        private ArrayList<Vertex<String>> vertex;


        public Graphs(){
            this.vertex= new ArrayList<Vertex<String>>();
            this.edge= new ArrayList<Edge>();
        }

        public Graphs(ArrayList<Vertex<String>> vertex, ArrayList<Edge> edge){
            this.vertex=vertex;
            this.edge=edge;
        }

        //Devuelve si el gráfico contiene o no un vértice de entrada
        public boolean hasVertex(Vertex<String> v){
            for(Vertex<String> vertex:vertex){
                if(vertex.getInfo().equals(v.getInfo())){
                    return true;
                }
            }
            return false;
        }

        //Devuelve la suma de los pesos de los bordes en el gráfico
        public int getCost(){
            int sum = 0;
            for(Edge e:edge){
                sum += e.getWeight();
            }
            return sum;
        }

        public ArrayList<Vertex<String>> getVertex() {
            return vertex;
        }

        public void addVertex(Vertex<String> vertex) {
            this.vertex.add(vertex);
        }

        public void addEdge(Edge edge) {
            this.edge.add(edge);
        }

        public ArrayList<Edge> getEdges(){
            return edge;
        }

        public String toString(){
            String ver="";
            for(Vertex<String> v:vertex){
                ver+=v.toString()+",";
            }
            String edg="";
            for(Edge e:edge){
                edg+=e.toString()+" ";
            }
            return "Vertices: "+ver+"\nEdges: "+edg+"\n";
        }
}
