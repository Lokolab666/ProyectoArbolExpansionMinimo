package edu.uptc.run;

import edu.uptc.control.*;
import edu.uptc.view.*;

public class Main {

    public static void main(String[] args) {

        PrincipalWindow principalWindow = new PrincipalWindow();
        Controller controller = new Controller(principalWindow);
        principalWindow.assignController(controller);
    }
}