import model.Operations;
import model.Polynomial;
import model.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivideOperationTest {

    @Test
    void divideTest(){
        Polynomial p1 = Regex.convertPolynomial("x^3 - 2x^2 + 6x -5");
        Polynomial p2 = Regex.convertPolynomial("x^2 - 1");
        String result = "Quotient: x - 2 \n"+
                "Remainder: 7x - 7 ";
        assertEquals(result, Operations.divide(p1,p2));
    }
}
