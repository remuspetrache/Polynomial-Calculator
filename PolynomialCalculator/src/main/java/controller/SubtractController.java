package controller;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubtractController implements ActionListener {
    private final Controller controller;

    public SubtractController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomial p1 = controller.getFirstInput();
        if (p1 != null) {
            Polynomial p2 = controller.getSecondInput();
            if (p2 != null) {
                Polynomial result = Operations.subtract(p1, p2);
                controller.view.setResultField("Difference: " + result.toString());
            }
        }
    }
}
