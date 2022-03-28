package edu.uptc.view;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JFrame;

import edu.uptc.control.*;
import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.Graph;

public class showOptionsPanel extends JDialog implements Actions{

    private OptionsPanel opOptions;

    private Dimension dimension;

    /**
     * Instantiates a new menu window.
     *
     * @param frame the frame
     */
    public showOptionsPanel(JFrame frame) {
        setLayout(null);
        dimension = new Dimension();
        dimension.setSize(Actions.WIDTH*.2196, Actions.HEIGHT*.8606);
        setSize(dimension);//300, 661
        setResizable(false);
        setUndecorated(true);
        initialize();
        insert();
    }

    private void initialize() {
        opOptions = new OptionsPanel();
        dimension.setSize(Actions.WIDTH*.2196, Actions.HEIGHT*.8606);
        opOptions.setSize(dimension);//300, 661
        opOptions.setLocation(0,0);//0, 0
        opOptions.setBackground(Color.orange);
    }

    private void insert() {
        add(opOptions);
    }

    public void assignController(Controller controller) {
        opOptions.assignController(controller);
    }

    @Override
    public String[] capture(String section) {
        switch(section) {
            case Actions.VERTEX:
                String[] dataVertex = {opOptions.getVertexName()};
                return dataVertex;

            case Actions.EDGE:
                String[] dataEdge = {""+opOptions.getOriginVertexIndex(), opOptions.getWeight(), ""+opOptions.getDestinyVertexIndex()};
                return dataEdge;
        }
        return null;
    }

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

    @Override
    public void showData(String section, String data) {}

    @Override
    public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {}

    public void clear(String section) {
        opOptions.clear(section);
    }

}