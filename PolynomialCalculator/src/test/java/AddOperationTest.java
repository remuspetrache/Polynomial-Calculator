import model.Operations;
import model.Polynomial;
import model.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddOperationTest {

    @Test
    void addTest(){
        Polynomial p1 = Regex.convertPolynomial("3x^2 + 6x + 5");
        Polynomial p2 = Regex.convertPolynomial("2x^3 + 6x^2 - 2x - 5");
        assertEquals("2x^3 + 9x^2 + 4x ", Operations.add(p1,p2).toString());
    }
}
