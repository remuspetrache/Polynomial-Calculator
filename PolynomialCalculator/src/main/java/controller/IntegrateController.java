package controller;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegrateController implements ActionListener {
    private final Controller controller;

    public IntegrateController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomial p1 = controller.getFirstInput();
        if (p1 != null) {
            Polynomial result = Operations.integrate(p1);
            if (result.toString().equals("0")){
                controller.view.setResultField("Integral: C");
            }
            else{
                controller.view.setResultField("Integral: " + result.toString() + "+ C");
            }
        }
    }
}
