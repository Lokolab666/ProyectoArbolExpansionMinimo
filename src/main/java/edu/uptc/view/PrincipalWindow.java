package edu.uptc.view;

import java.awt.Color;

import javax.swing.JFrame;

import edu.uptc.control.*;
import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.Graph;

/**
 * Clase donde se cre la ventana principal para mostrar los paneles donde estan las acciones,
 * grafo completo y el grafo con el arbol de expansión minima.
 */
public class PrincipalWindow extends JFrame implements Actions{
    private showGraphPanel gpGraph;
    private showGraphPanel gpMST;
    private showOptionsPanel opOptions;

    /**
     * Constructor de la clase, donde permite inicializar el frame inicial.
     */
    public PrincipalWindow() {
        super("Arboles de expancion minima");
        setSize(1315, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        insert();
    }

    /**
     * Metodo que permite agregar los botones al panel de acciones.
     */
    private void insert() {
        opOptions = new showOptionsPanel(this);
        opOptions.setSize(300, 561);

    }

    /**
     * Metodo que permite asignar el la clase controler, donde implementa las acciones de los botones.
     * @param controller
     */
    public void assignController(Controller controller) {
        opOptions.assignController(controller);
        showPanels();
    }

    /**
     * Metodo que permite conocer si algun atributo esta siendo usado.
     * @param section - la seccion capturada
     * @return
     */
    @Override
    public String[] capture(String section) {

        return opOptions.capture(section);
    }

    /**
     * Metodo que permite mostrar los datos de acuerdo a la sección capturada
     * @param section
     * @param data
     */
    @Override
    public void show(String section, String[] data) {
        opOptions.show(section, data);
    }

    /**
     * Metodo que permite mostrar el grafo pintado de acuerdo al proceso aplicado
     * @param section
     * @param graph
     */
    @Override
    public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {



        switch(section) {
            case Actions.GRAPH:

                gpGraph = new showGraphPanel(this);
                gpGraph.setSize(500, 561);
                gpGraph.setBackground(Color.red);
                gpGraph.showGraph(section, graph);
                if(gpGraph!=null) {
                    gpGraph.setLocation(((int)getLocation().getX()+8), ((int)getLocation().getY()+31));
                    gpGraph.setVisible(true);
                }
                break;

            case Actions.GRAPHMST:

                gpMST = new showGraphPanel(this);
                gpMST.setSize(500, 561);
                gpMST.setBackground(Color.GREEN);
                gpMST.showGraph(section, graph);
                if(gpMST!=null) {
                    gpMST.setLocation(((int)getLocation().getX()+508), ((int)getLocation().getY()+31));
                    gpMST.setVisible(true);
                }

                break;
        }

    }

    /**
     * Metodo que permite limpiar los campos del panel de inputs
     * @param section
     */
    @Override
    public void clear(String section) {
        opOptions.clear(section);
    }

    /**
     * Metodo que permite mostrar los paneles del grafo normal, grafo del arbol de expansion minima y el panel de acciones
     */
    private void showPanels() {
        opOptions.setLocation(((int)getLocation().getX()+1008), ((int)getLocation().getY()+31));
        opOptions.setVisible(true);

        gpGraph.setLocation(((int)getLocation().getX()+8), ((int)getLocation().getY()+31));
        gpGraph.setVisible(true);

        gpMST.setLocation(((int)getLocation().getX()+508), ((int)getLocation().getY()+31));
        gpMST.setVisible(true);
    }

}
