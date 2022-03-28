package edu.uptc.run;

import edu.uptc.control.*;
import edu.uptc.view.*;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Toolkit t = Toolkit.getDefaultToolkit();
        PrincipalWindow principalWindow = new PrincipalWindow();
        Controller controller = new Controller(principalWindow);
        principalWindow.assignController(controller);
    }
}