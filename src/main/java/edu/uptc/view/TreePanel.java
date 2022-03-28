package edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;

import javax.swing.JPanel;

import org.apache.commons.collections15.Transformer;

import edu.uptc.graph.*;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class TreePanel extends JPanel{


    private Layout<Vertex<String>, Edge> layout;
    private DefaultModalGraphMouse gm;
    private VisualizationViewer<Vertex<String>, Edge> vs;
    private Graph<Vertex<String>, Edge> graph;
    private Color color;

    private Dimension dimension;

    public TreePanel(Graph<Vertex<String>, Edge> graph, Color color) {
        this.color = color;
        this.graph = graph;
        setBackground(color);
        initialice();
        assign();
    }

    private void initialice() {
        dimension = new Dimension();
        //Inicializar visualizacion
        layout =  new TreeLayout<Vertex<String>, Edge>((Forest<Vertex<String>, Edge>) graph);
        //crea margen Por niveles para asi poder asignar los nodos a la altura a la que pertenece
        vs = new VisualizationViewer<Vertex<String>, Edge>(layout);//componente que detecta la interaccion con el mouse
        dimension.setSize(Actions.WIDTH*.3587,Actions.HEIGHT*.6640);//490, 410
        vs.setPreferredSize(dimension);

        //Permite el escalado del grafo a medida que este se vea editando
        gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vs.setGraphMouse(gm);

        //Transformador asigna el número de vértice a una propiedad de vértice
        Transformer<Vertex<String>, Paint> vertexColor = new Transformer<Vertex<String>, Paint>() {
            @Override
            public Paint transform(Vertex<String> arg0) {
                return color;
            }
        };

        vs.getRenderContext().setVertexFillPaintTransformer(vertexColor);//configura el color de los vertices
        vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());//configuracion renderizado Vertices
        vs.getRenderer().getVertexLabelRenderer().setPosition(Position.AUTO);//los labels se ubican centrados del vertice

        vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());//configuracion renderizado Aristas "rutas"
        vs.getRenderContext().getEdgeLabelRenderer().setRotateEdgeLabels(false);//los labels se ubican centrados del Aristas "rutas"

    }

    private void assign() {
        add(vs);
    }

}
