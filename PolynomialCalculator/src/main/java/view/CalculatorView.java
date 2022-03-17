package view;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private final JPanel contentPane;
    private final JLabel titleLabel;
    private final JTextField firstPolynomialField;
    private final JLabel firstPolynomialLabel;
    private final JTextField secondPolynomialField;
    private final JLabel secondPolynomialLabel;
    private final JTextPane resultTextPane;
    private final JPanel inputPane;
    private final JPanel firstPolynomialPane;
    private final JPanel secondPolynomialPane;
    private final JPanel buttonsPane;
    private final JButton addButton;
    private final JButton divideButton;
    private final JButton subtractButton;
    private final JButton integrateButton;
    private final JButton multiplyButton;
    private final JButton differentiateButton;
    private final JButton instructionsButton;

    public CalculatorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBackground(new Color(52, 96, 194));

        titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setPreferredSize(new Dimension(100, 60));

        inputPane = new JPanel();
        inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.Y_AXIS));
        inputPane.setBackground(new Color(52, 96, 194));

        firstPolynomialPane = new JPanel();
        firstPolynomialPane.setBackground(new Color(52, 96, 194));
        firstPolynomialLabel = new JLabel("      First Polynomial =");
        firstPolynomialField = new JTextField();
        firstPolynomialField.setPreferredSize(new Dimension(200, 20));
        firstPolynomialPane.add(firstPolynomialLabel);
        firstPolynomialPane.add(firstPolynomialField);

        secondPolynomialPane = new JPanel();
        secondPolynomialPane.setBackground(new Color(52, 96, 194));
        secondPolynomialLabel = new JLabel("Second Polynomial =");
        secondPolynomialField = new JTextField();
        secondPolynomialField.setPreferredSize(new Dimension(200, 20));
        secondPolynomialPane.add(secondPolynomialLabel);
        secondPolynomialPane.add(secondPolynomialField);

        JPanel resultPane = new JPanel();
        resultPane.setBackground(new Color(52, 96, 194));
        resultTextPane = new JTextPane();
        resultTextPane.setPreferredSize(new Dimension(450, 40));
        resultTextPane.setFont(new Font("Tahoma", Font.BOLD, 14));

        StyledDocument doc = resultTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        resultTextPane.setEditable(false);
        resultTextPane.setBorder(BorderFactory.createEmptyBorder());
        resultTextPane.setBackground(new Color(52, 96, 194));
        resultPane.add(resultTextPane);

        inputPane.add(firstPolynomialPane);
        inputPane.add(secondPolynomialPane);
        inputPane.add(resultPane);

        buttonsPane = new JPanel();
        buttonsPane.setLayout(new GridLayout(3, 2));
        buttonsPane.setBackground(new Color(52, 96, 194));

        addButton = new JButton("Add");
        addButton.setBackground(new Color(103, 199, 255));
        buttonsPane.add(addButton);
        subtractButton = new JButton("Subtract");
        subtractButton.setBackground(new Color(103, 199, 255));
        buttonsPane.add(subtractButton);
        multiplyButton = new JButton("Multiply");
        multiplyButton.setBackground(new Color(103, 199, 255));
        buttonsPane.add(multiplyButton);
        divideButton = new JButton("Divide");
        divideButton.setBackground(new Color(103, 199, 255));
        buttonsPane.add(divideButton);
        integrateButton = new JButton("Integrate");
        integrateButton.setBackground(new Color(103, 199, 255));
        buttonsPane.add(integrateButton);
        differentiateButton = new JButton("Differentiate");
        differentiateButton.setBackground(new Color(103, 199, 255));
        buttonsPane.add(differentiateButton);

        instructionsButton = new JButton("Instructions");
        instructionsButton.setBackground(new Color(103, 199, 255));
        instructionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(titleLabel);
        contentPane.add(inputPane);
        contentPane.add(buttonsPane);
        contentPane.add(instructionsButton);
        setContentPane(contentPane);
        setTitle("Polynomial Calculator");
    }

    public void addAdditionListener(ActionListener aal) {
        addButton.addActionListener(aal);
    }

    public void addSubtractionListener(ActionListener sal) {
        subtractButton.addActionListener(sal);
    }

    public void addDivisionListener(ActionListener dal) {
        divideButton.addActionListener(dal);
    }

    public void addMultiplicationListener(ActionListener mal) {
        multiplyButton.addActionListener(mal);
    }

    public void addIntegrationListener(ActionListener ial) {
        integrateButton.addActionListener(ial);
    }

    public void addDerivativeListener(ActionListener dal) {
        differentiateButton.addActionListener(dal);
    }

    public void addInstructionsListener(ActionListener inal) {
        instructionsButton.addActionListener(inal);
    }

    public String getFirstPolynomial() {
        return firstPolynomialField.getText();
    }

    public String getSecondPolynomial() {
        return secondPolynomialField.getText();
    }

    public void changeFirstPolynomialFieldColor(Color c) {
        firstPolynomialField.setBackground(c);
    }

    public void changeSecondPolynomialFieldColor(Color c) {
        secondPolynomialField.setBackground(c);
    }

    public void setResultField(String resultString) {
        resultTextPane.setText(resultString);
    }

    public void showError(String errorMessage) {
        int result = JOptionPane.showConfirmDialog(this, errorMessage, "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        if (result == JOptionPane.OK_OPTION || result == JOptionPane.CLOSED_OPTION) {
            this.changeFirstPolynomialFieldColor(Color.white);
            this.changeSecondPolynomialFieldColor(Color.white);
        }
    }
}
