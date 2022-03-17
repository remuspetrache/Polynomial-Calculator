package controller;

import model.Polynomial;
import model.Regex;
import view.CalculatorView;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    protected final CalculatorView view;

    public Controller(CalculatorView view) {
        this.view = view;
        view.addAdditionListener(new AddController(this));
        view.addSubtractionListener(new SubtractController(this));
        view.addMultiplicationListener(new MultiplyController(this));
        view.addDivisionListener(new DivideController(this));
        view.addIntegrationListener(new IntegrateController(this));
        view.addDerivativeListener(new DifferentiateController(this));
        view.addInstructionsListener(new InstructionsController(this));
    }

    protected Polynomial getFirstInput() {
        String firstPolynomial = view.getFirstPolynomial();
        if (testInput(firstPolynomial)) {
            view.changeFirstPolynomialFieldColor(Color.red);
            view.showError("The first polynomial is incorrectly added.\n" +
                    "Make sure you follow the instructions properly!");
            return null;
        } else {
            return Regex.convertPolynomial(firstPolynomial);
        }
    }

    protected Polynomial getSecondInput() {
        String secondPolynomial = view.getSecondPolynomial();
        if (testInput(secondPolynomial)) {
            view.changeSecondPolynomialFieldColor(Color.red);
            view.showError("The second polynomial is incorrectly added.\n" +
                    "Make sure you follow the instructions properly!");
            return null;
        } else {
            return Regex.convertPolynomial(secondPolynomial);
        }
    }

    private boolean testInput(String s1) {
        s1 = s1.replaceAll("( +)", "");
        if (s1.isEmpty()){
            return true;
        }
        String patternString = "([^\\d^+\\-x*])|(x[^\\^+-])|(x\\^[^\\d])|(x\\^\\d+[^\\d+-])" +
                "|([^x]\\^)|([+-][^\\dx])|([^\\d]\\*)|(\\*[^x])";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s1);
        return matcher.find();
    }
}
