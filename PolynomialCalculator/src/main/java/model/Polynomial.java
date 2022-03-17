package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomialList = new ArrayList<>();


    public List<Monomial> getMonomialList() {
        return monomialList;
    }

    public void setMonomialList(List<Monomial> polynomial) {
        this.monomialList = polynomial;
    }

    public void addMonomial(Monomial newMonomial) {
        boolean exists = false;
        for (Monomial m : monomialList) {
            if (m.getPower() == newMonomial.getPower()) {
                exists = true;
                m.setCoefficient(m.getCoefficient() + newMonomial.getCoefficient());
                if (m.getCoefficient() == 0) {
                    monomialList.remove(m);
                }
                break;
            }
        }
        if (!exists && newMonomial.getCoefficient() != 0) {
            monomialList.add(newMonomial);
            Collections.sort(monomialList);
        }
    }

    public String toString() {
        String display = "";
        for (Monomial m : monomialList) {
            display += m.toString();
            display += " + ";
        }
        display = display.replace("+ -", "- ");
        if (display.compareTo("") == 0) {
            display = "0";
        } else display = display.substring(0, display.length() - 2);
        return display;
    }
}
