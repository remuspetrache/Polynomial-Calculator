import model.Operations;
import model.Polynomial;
import model.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferentiateOperationTest {

    @Test
    void differentiateTest(){
        Polynomial p1 = Regex.convertPolynomial("6x^3 + 6x^2 - 5x + 3");
        assertEquals("18x^2 + 12x - 5 ", Operations.differentiate(p1).toString());
    }
}
