package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsController implements ActionListener {
    private final Controller controller;

    public InstructionsController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UIManager.put("OptionPane.background", new Color(148, 172, 233));
        UIManager.put("Panel.background", new Color(148, 172, 233));
        UIManager.put("Button.background", new Color(103, 199, 255));
        String instructions = """
                You must introduce two polynomials with variable "x" in the following way:
                \ta(n)x^n + a(n-1)x^(n-1) + ... + a(1)x + a(0)
                Both polynomials must have integer coefficients and natural exponents.
                After adding the polynomials, select the desired operation.
                For the integration and differentiation operations, the first polynomial will be used.""";
        JTextArea area = new JTextArea(instructions);
        area.setFont(new Font("Times New Roman", Font.BOLD, 14));
        area.setBackground(new Color(148, 172, 233));
        JOptionPane.showMessageDialog(controller.view, area, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }
}
