import model.Operations;
import model.Polynomial;
import model.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplyOperationTest {

    @Test
    void multiplyTest(){
        Polynomial p1 = Regex.convertPolynomial("x^3 + 6x");
        Polynomial p2 = Regex.convertPolynomial("x^2 - 2");
        assertEquals("x^5 + 4x^3 - 12x ", Operations.multiply(p1,p2).toString());
    }
}
