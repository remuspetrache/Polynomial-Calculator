package controller;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifferentiateController implements ActionListener {
    private final Controller controller;

    public DifferentiateController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomial p1 = controller.getFirstInput();
        if (p1 != null) {
            Polynomial result = Operations.differentiate(p1);
            controller.view.setResultField("Derivative: " + result.toString());
        }
    }
}
