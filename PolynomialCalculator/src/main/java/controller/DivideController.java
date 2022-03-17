package controller;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivideController implements ActionListener {
    private final Controller controller;

    public DivideController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomial p1 = controller.getFirstInput();
        if (p1 != null) {
            Polynomial p2 = controller.getSecondInput();
            if (p2 != null) {
                controller.view.setResultField(Operations.divide(p1, p2));
            }
        }
    }
}
