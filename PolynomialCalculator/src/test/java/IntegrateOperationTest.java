import model.Operations;
import model.Polynomial;
import model.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegrateOperationTest {

    @Test
    void integrateTest(){
        Polynomial p1 = Regex.convertPolynomial("2x^4 + 3x^3 - x^2 + 3");
        assertEquals("0.40x^5 + 0.75x^4 - 0.33x^3 + 3x ", Operations.integrate(p1).toString());
    }
}
