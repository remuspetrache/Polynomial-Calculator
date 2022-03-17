package model;

public class Monomial implements Comparable<Monomial> {
    private double coefficient;
    private int power;

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public Monomial(Monomial m) {
        this.coefficient = m.getCoefficient();
        this.power = m.getPower();
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int compareTo(Monomial otherMonomial) {
        return otherMonomial.power - this.power;
    }

    public String toString() {
        String display = "";
        if (Math.abs(coefficient) != 1) {
            if (Math.abs((int) coefficient - coefficient) < 0.001d) {
                display += (int) coefficient;
            } else {
                display += String.format("%.2f", coefficient);
            }
        } else if (coefficient == -1) {
            display += "-";
        }
        if (power != 0 && power != 1) {
            display += "x^" + power;
        } else if (power == 1) {
            display += "x";
        } else if (Math.abs(coefficient) == 1) {
            display += "1";
        }
        return display;
    }

}
