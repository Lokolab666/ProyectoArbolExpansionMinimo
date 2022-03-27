package edu.uptc.graph;

import java.util.ArrayList;

/**
 * Clase Gráfico, con ciertos algoritmos incorporados, teniendo la arista y el vertice
 */
public class Graphs {

        //Clase de gráfico con ciertos algoritmos incorporados

        private ArrayList<Edge> edge;
        private ArrayList<Vertex<String>> vertex;

    /**
     * Constructor principal de la clase donde se inicializan las aristas y vertices
     */
    public Graphs(){
            this.vertex= new ArrayList<Vertex<String>>();;
            this.edge= new ArrayList<Edge>();
        }

    /**
     * Constructor principal de la clase donde inicializa el array de aristas y vertices
     * @param vertex
     * @param edge
     */
    public Graphs(ArrayList<Vertex<String>> vertex, ArrayList<Edge> edge){
            this.vertex=vertex;
            this.edge=edge;
        }

    /**
     *Metodo que Devuelve si el gráfico contiene o no un vértice de entrada
     * @param v
     * @return booleano diciendo si esta o no el vert8ice de entrada
     */
    //Devuelve si el gráfico contiene o no un vértice de entrada
        public boolean hasVertex(Vertex<String> v){
            for(Vertex<String> vertex:vertex){
                if(vertex.getInfo().equals(v.getInfo())){
                    return true;
                }
            }
            return false;
        }

    /**
     * Metodo que Devuelve la suma de los pesos de los bordes en el gráfico
     * @return suma
     */
    //Devuelve la suma de los pesos de los bordes en el gráfico
        public int getCost(){
            int sum = 0;
            for(Edge e:edge){
                sum += e.getWeight();
            }
            return sum;
        }

    /**
     * Metodo que permite obtener un vertice del array de vertices
     * @return vertice
     */
    public ArrayList<Vertex<String>> getVertex() {
            return vertex;
        }

    /**
     * Metodo que permite Agregar vertices al grafico pintado
     * @param vertex
     */
    public void addVertex(Vertex<String> vertex) {
            this.vertex.add(vertex);
        }

    /**
     * Metodo que permite agregar una arista para conectar dos vertices
     * @param edge
     */
    public void addEdge(Edge edge) {
            this.edge.add(edge);
        }

    /**
     * Metodo que permite obtener una arista del array de aristas
     * @return arista
     */
    public ArrayList<Edge> getEdges(){
            return edge;
        }

    /**
     * Metodo To string que muestra los datos de los vertices y las aristas
     * @return info del vertice con el peso de la arista de forma textual
     */
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
