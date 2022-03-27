package edu.uptc.view;

import java.awt.Color;

import javax.swing.JFrame;

import edu.uptc.control.*;
import edu.uptc.graph.*;
import edu.uci.ics.jung.graph.Graph;

public class PrincipalWindow extends JFrame implements Actions{

    private showGraphPanel gpGraph;
    private showGraphPanel gpMST;
    private showOptionsPanel opOptions;

    public PrincipalWindow() {
        super("Arboles de expancion minima");
        setSize(1315, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        insert();
    }

    private void insert() {
        opOptions = new showOptionsPanel(this);
        opOptions.setSize(300, 561);

    }


    public void assignController(Controller controller) {
        opOptions.assignController(controller);
        showPanels();
    }

    @Override
    public String[] capture(String section) {

        return opOptions.capture(section);
    }

    @Override
    public void show(String section, String[] data) {
        opOptions.show(section, data);
    }

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

    @Override
    public void clear(String section) {
        opOptions.clear(section);
    }

    private void showPanels() {
        opOptions.setLocation(((int)getLocation().getX()+1008), ((int)getLocation().getY()+31));
        opOptions.setVisible(true);

        gpGraph.setLocation(((int)getLocation().getX()+8), ((int)getLocation().getY()+31));
        gpGraph.setVisible(true);

        gpMST.setLocation(((int)getLocation().getX()+508), ((int)getLocation().getY()+31));
        gpMST.setVisible(true);
    }

}
