package model;

public class Operations {

    private Operations() {
    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Monomial m : p1.getMonomialList()) {
            result.addMonomial(new Monomial(m));
        }
        for (Monomial m : p2.getMonomialList()) {
            result.addMonomial(new Monomial(m));
        }
        return result;
    }

    private static Polynomial negative(Polynomial p) {
        Polynomial negativeP = new Polynomial();
        for (Monomial m : p.getMonomialList()) {
            double negativeCoefficient = -m.getCoefficient();
            Monomial negativeMonomial = new Monomial(negativeCoefficient, m.getPower());
            negativeP.addMonomial(negativeMonomial);
        }
        return negativeP;
    }

    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial negativeP2 = Operations.negative(p2);
        return Operations.add(p1, negativeP2);
    }

    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Monomial m1 : p1.getMonomialList()) {
            for (Monomial m2 : p2.getMonomialList()) {
                double newCoefficient = m1.getCoefficient() * m2.getCoefficient();
                int newPower = m1.getPower() + m2.getPower();
                result.addMonomial(new Monomial(newCoefficient, newPower));
            }
        }
        return result;
    }

    public static String divide(Polynomial p1, Polynomial p2) {
        if (p1.getMonomialList().isEmpty() || p2.getMonomialList().isEmpty()) {
            return "Error! Cannot divide by 0";
        } else if (p1.getMonomialList().get(0).getPower() >= p2.getMonomialList().get(0).getPower()) {
            return division(p1, p2);
        } else {
            return division(p2, p1);
        }
    }

    private static String division(Polynomial p1, Polynomial p2) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = p1;
        Monomial leadingR = remainder.getMonomialList().get(0);
        Monomial leadingP2 = p2.getMonomialList().get(0);
        while (leadingR.getPower() >= leadingP2.getPower()) {
            Polynomial interm = new Polynomial();
            double intermCoefficient = leadingR.getCoefficient() / leadingP2.getCoefficient();
            int intermPower = leadingR.getPower() - leadingP2.getPower();
            interm.addMonomial(new Monomial(intermCoefficient, intermPower));
            quotient = add(quotient, interm);
            remainder = subtract(remainder, multiply(interm, p2));
            if (remainder.getMonomialList().isEmpty()) {
                break;
            }
            leadingR = remainder.getMonomialList().get(0);
        }
        return "Quotient: " + quotient.toString() + "\nRemainder: " + remainder.toString();
    }

    public static Polynomial differentiate(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Monomial m : p.getMonomialList()) {
            result.addMonomial(new Monomial(m.getCoefficient() * m.getPower(), m.getPower() - 1));
        }
        return result;
    }

    public static Polynomial integrate(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Monomial m : p.getMonomialList()) {
            result.addMonomial(new Monomial(m.getCoefficient() / (m.getPower() + 1), m.getPower() + 1));
        }
        return result;
    }
}
