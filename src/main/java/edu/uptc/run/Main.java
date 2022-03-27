package edu.uptc.run;

import edu.uptc.control.*;
import edu.uptc.view.*;

/**
 * Clase que permite correr el programa
 */
public class Main {

    /**
     * Metodo donde se inicializa las ventanas principales y el controlador, para ejecutar bien el programa
     * @param args - del Metodo main
     */
    public static void main(String[] args) {

        PrincipalWindow principalWindow = new PrincipalWindow();
        Controller controller = new Controller(principalWindow);
        principalWindow.assignController(controller);
    }
}