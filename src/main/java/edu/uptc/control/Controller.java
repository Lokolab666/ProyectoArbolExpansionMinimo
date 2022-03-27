package edu.uptc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.uptc.model.*;
import edu.uptc.view.*;
/**
 * Clase de Controlador que implementa el escuchador, para saber el boton, la accion y el proceso que hará.
 *
 */
public class Controller implements ActionListener{
    private Actions actions;
    private Management management;

    /**
     * Constructor de la clase que permite inicializar atributos de esta clase.
     * @param actions
     */
    public Controller(Actions actions) {
        this.actions = actions;
        management = new Management();
        actions.showGraph(Actions.GRAPH, management.getGraph());//Mostrar grafo ROJO
        actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
        actions.show(Actions.ORIGIN, management.getVertex());
        actions.show(Actions.DESTINY, management.getVertex());
    }

    /**
     * Metodo que permite escuchar o recibir si cierto boton o campo ha sido llenado y
     * darle un funcionamiento respectivo a esto
     * @param e - evento accionado (botones, textfiels)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){

            case Actions.RESET:
                management.reset();
                actions.showGraph(Actions.GRAPH, management.getGraph());//Mostrar grafo ROJO
                actions.clear(Actions.VERTEX);
                actions.clear(Actions.EDGE);
                management.resetMST();
                actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
                actions.show(Actions.ORIGIN, management.getVertex());
                actions.show(Actions.DESTINY, management.getVertex());
                break;

            case Actions.CLOSE:
                System.exit(0);
                break;

            case Actions.VERTEX:
                management.createVertex(actions.capture(Actions.VERTEX)[0]);
                actions.showGraph(Actions.GRAPH, management.getGraph());//Mostrar grafo ROJO
                actions.clear(Actions.VERTEX);
                management.resetMST();
                actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
                actions.show(Actions.ORIGIN, management.getVertex());
                actions.show(Actions.DESTINY, management.getVertex());
                break;

            case Actions.EDGE:
                management.createEdge(actions.capture(Actions.EDGE));
                actions.showGraph(Actions.GRAPH, management.getGraph());//Mostrar grafo ROJO
                actions.clear(Actions.EDGE);
                management.resetMST();
                actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
                break;

            case Actions.PREVIOUS:
                management.previousIndex();
                actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
                break;

            case Actions.NEXT:
                management.nextIndex();
                actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
                break;
        }

    }



}