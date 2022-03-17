package main;

import view.*;
import controller.*;

public class MainClass {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        Controller controller = new Controller(view);
        view.setVisible(true);
    }
}
