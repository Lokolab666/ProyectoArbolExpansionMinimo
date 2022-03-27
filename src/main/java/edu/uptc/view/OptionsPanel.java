package edu.uptc.view;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.uptc.control.*;

/**
 * Clase donde se crea el panel de opciones o acciones para realizar en el programa
 */
public class OptionsPanel extends JPanel{
    private JButton btnClose;
    private JButton btnReset;

    private JLabel txtVertex;
    private JLabel txtVertexName;
    private JTextField tfVertexName;
    private JButton btnVertexName;

    private JLabel txtEdge;
    private JLabel txtOriginVertex;
    private JComboBox<String> cbOriginVertex;
    private JLabel txtWeight;
    private JTextField tfWeight;
    private JLabel txtDestinyVertex;
    private JComboBox<String> cbDestinyVertex;
    private JButton btnEdge;

    private JLabel txtMST;
    private JButton btnPreviousMST;
    private JButton btnNextMST;

    /**
     * Constructor principal de la clase que permite inicializar atributos y objetos del panel
     */
    public OptionsPanel() {
        setLayout(null);
        initialize();
        assign();
    }

    /**
     * Metodo en el que se inicializan los botones, espacios de escritura y entradas de variables al grafo MST
     */
    private void initialize() {
        btnReset = new JButton("Reset");
        btnReset.setForeground(Color.RED);
        btnReset.setBounds(0, 0, 80, 30);

        btnClose = new JButton("X");
        btnClose.setForeground(Color.RED);
        btnClose.setBounds(250, 0, 50, 30);

        txtVertex = new JLabel("Agregar un nuevo vertice");
        txtVertex.setBounds(30, 40, 240, 30);

        txtVertexName = new JLabel("Ingrese el nombre del vertice");
        txtVertexName.setBounds(30, 70, 240, 30);

        tfVertexName = new JTextField();
        tfVertexName.setBounds(30, 100, 240, 30);

        btnVertexName = new JButton("Agregar vertice");
        btnVertexName.setBounds(30, 140, 240, 30);

        txtEdge = new JLabel("Conectar 2 vertices mediante una arista");
        txtEdge.setBounds(30, 170, 240, 30);

        txtOriginVertex = new JLabel("Seleccione el vertice de origen");
        txtOriginVertex.setBounds(30, 200, 240, 30);

        cbOriginVertex = new JComboBox<>();
        cbOriginVertex.setModel(new DefaultComboBoxModel());
        cbOriginVertex.setBounds(30, 230, 240, 30);

        txtWeight = new JLabel("Ingrese el peso de la arista");
        txtWeight.setBounds(30, 260, 240, 30);

        tfWeight = new JTextField();
        tfWeight.setBounds(30, 290, 240, 30);

        txtDestinyVertex = new JLabel("Seleccione el vertice de destino");
        txtDestinyVertex.setBounds(30, 320, 240, 30);

        cbDestinyVertex = new JComboBox<>();
        cbOriginVertex.setModel(new DefaultComboBoxModel());
        cbDestinyVertex.setBounds(30, 350, 240, 30);

        btnEdge = new JButton("Agregar conexion mediante arista");
        btnEdge.setBounds(30, 390, 240, 30);

        txtMST = new JLabel("Arboles de expancion minima");
        txtMST.setBounds(30, 440, 240, 30);

        btnPreviousMST = new JButton("Paso anterior");
        btnPreviousMST.setBounds(30, 470, 240, 30);

        btnNextMST = new JButton("Siguiente paso");
        btnNextMST.setBounds(30, 510, 240, 30);
    }

    /**
     * Metodo que permite agregar los botones, textfields y demás inputs para crear el arbol de expansión minima
     */
    private void assign() {
        add(btnReset);
        add(btnClose);

        add(txtVertex);
        add(txtVertexName);
        add(tfVertexName);
        add(btnVertexName);

        add(txtEdge);
        add(txtOriginVertex);
        add(cbOriginVertex);
        add(txtWeight);
        add(tfWeight);
        add(txtDestinyVertex);
        add(cbDestinyVertex);
        add(btnEdge);

        add(txtMST);
        add(btnPreviousMST);
        add(btnNextMST);
    }

    /**
     * Metodo que permite asignar la clase Controlador a cada boton e input, con el fin de que tengan una acción
     * @param controller
     */
    public void assignController(Controller controller) {
        btnReset.setActionCommand(Actions.RESET);
        btnReset.addActionListener(controller);

        btnClose.setActionCommand(Actions.CLOSE);
        btnClose.addActionListener(controller);

        btnVertexName.setActionCommand(Actions.VERTEX);
        btnVertexName.addActionListener(controller);

        btnEdge.setActionCommand(Actions.EDGE);
        btnEdge.addActionListener(controller);

        btnPreviousMST.setActionCommand(Actions.PREVIOUS);
        btnPreviousMST.addActionListener(controller);

        btnNextMST.setActionCommand(Actions.NEXT);
        btnNextMST.addActionListener(controller);
    }

    /**
     * Metodo que permite obtener el nombre de los vertices añadidos al programa.
     * @return nombre del vertice en texto
     */
    public String getVertexName() {
        return tfVertexName.getText();
    }

    /**
     * Metodo que permite llenar el combo box del vertice de conexión de destino con el nombre de los vertices añadidos al programa, para hacer las debidas conexiones.
     * @param data
     */
    public void fillcbOriginVertex(String[] data) {
        cbOriginVertex.removeAllItems();
        for (int i = 0; i < data.length; i++) {
            cbOriginVertex.addItem(data[i]);
        }
    }

    /**
     * Metodo que permite obtener el vertice puesto como origen en el programa.
     * @return valor del vertice de origen
     */
    public int getOriginVertexIndex() {
        return cbOriginVertex.getSelectedIndex();
    }

    /**
     * Metodo que permite llenar el combo box del vertice de conexión de destino con el nombre de los vertices añadidos al programa
     * @param data
     */
    public void fillcbDestinyVertex(String[] data) {
        cbDestinyVertex.removeAllItems();
        for (int i = 0; i < data.length; i++) {
            cbDestinyVertex.addItem(data[i]);
        }
    }

    /**
     * Metodo que permite obtener el vertice puesto como destino en el programa.
     * @return valor del vertice de destino
     */
    public int getDestinyVertexIndex() {
        return cbDestinyVertex.getSelectedIndex();
    }

    /**
     * Metodo que permite obtener el peso de las aristas
     * @return peso de la arista como texto
     */
    public String getWeight() {
        return tfWeight.getText();
    }

    /**
     * Metodo que permite limpiar los campos de texto en el panel de acciones
     * @param section - donde esta el input de texto.
     */
    public void clear(String section) {
        switch(section){
            case Actions.VERTEX:
                tfVertexName.setText("");
                break;

            case Actions.EDGE:
                tfWeight.setText("");
                break;
        }
    }

}