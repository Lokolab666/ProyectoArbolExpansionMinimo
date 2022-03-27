package edu.uptc.view;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;

import edu.uptc.control.*;
import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.Graph;

/**
 * Clase que muestra el panel de opciones creado
 */
public class showOptionsPanel extends JDialog implements Actions{

    private OptionsPanel opOptions;

    /**
     * Constructor principal de la clase que permite inicializar ciertos atributos del panel
     * @param frame the frame
     */
    public showOptionsPanel(JFrame frame) {
        setLayout(null);
        setSize(300, 561);
        setResizable(false);
        setUndecorated(true);
        initialize();
        insert();
    }

    /**
     Metodo que permite incializar el panel de las opciones para mostrarlo
     */
    private void initialize() {
        opOptions = new OptionsPanel();
        opOptions.setBounds(0, 0, 300, 561);
        opOptions.setBackground(Color.orange);
    }

    /**
     * Metodo que permite agregar el panel para mostrarlo
     */
    private void insert() {
        add(opOptions);
    }

    /**
     * Metodo que permite asignar la clase Controlador para poder hacer ele respetivo manejo de las opciones dadas
     * @param controller
     */
    public void assignController(Controller controller) {
        opOptions.assignController(controller);
    }

    /**
     * Metodo que permite copturar los datos ingresados para el vertice y las aristas
     * @param section - la seccion capturada
     * @return el nombre del vertice de origen y de destino
     */
    @Override
    public String[] capture(String section) {
        switch(section) {
            case Actions.VERTEX:
                String[] dataVertex = {opOptions.getVertexName()};
                return dataVertex;
//			break;

            case Actions.EDGE:
                String[] dataEdge = {""+opOptions.getOriginVertexIndex(), opOptions.getWeight(), ""+opOptions.getDestinyVertexIndex()};
                return dataEdge;
//			break;
        }
        return null;
    }

    /**
     * Metodo qyue permite mostrar los datos que estan en los combo box
     * @param section
     * @param data
     */
    @Override
    public void show(String section, String[] data) {
        switch(section) {
            case Actions.ORIGIN:
                opOptions.fillcbOriginVertex(data);
                break;

            case Actions.DESTINY:
                opOptions.fillcbDestinyVertex(data);
                break;
        }
        repaint();
    }

    /**
     * Metodo que permite visualizar el grafo normal y el arbol de expansion minima
     * @param section
     * @param graph
     */
    @Override
    public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {}

    /**
     * Metodo que permite limpiar los campos dados en las opciones
     * @param section
     */
    public void clear(String section) {
        opOptions.clear(section);
    }

}