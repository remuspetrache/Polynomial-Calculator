package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private Regex() {
    }

    public static Polynomial convertPolynomial(String stringPolynomial) {
        Polynomial result = new Polynomial();
        stringPolynomial = stringPolynomial.replaceAll("( +)|(\\*)","");
        String patternString = "([+-]?(?:(?:\\d*x\\^\\d+)|(?:\\d*x)|(?:\\d+)))";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(stringPolynomial);
        while (matcher.find()) {
            Monomial m = new Monomial(Double.parseDouble(findCoefficient(matcher.group())), Integer.parseInt(findPower(matcher.group())));
            result.addMonomial(m);
        }
        return result;
    }

    private static String findCoefficient(String matcherGroup) {
        String coefficient;
        if (matcherGroup.contains("x")) {
            coefficient = matcherGroup.substring(0, matcherGroup.lastIndexOf('x'));
            if (coefficient.equals("") || coefficient.equals("+")) {
                coefficient = "1";
            } else if (coefficient.equals("-")) {
                coefficient = "-1";
            }
        } else {
            coefficient = matcherGroup;
        }
        return coefficient;
    }

    private static String findPower(String matcherGroup) {
        String power;
        if (matcherGroup.contains("^")) {
            power = matcherGroup.substring(matcherGroup.lastIndexOf('^') + 1);
        } else if (matcherGroup.contains("x")) {
            power = "1";
        } else {
            power = "0";
        }
        return power;
    }


}

