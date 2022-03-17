import model.Operations;
import model.Polynomial;
import model.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubtractOperationTest {

    @Test
    void subtractTest(){
        Polynomial p1 = Regex.convertPolynomial("4x^3 - 2x^2 + 5x - 9");
        Polynomial p2 = Regex.convertPolynomial("x^2 + 4x^3 - 3x + 5");
        assertEquals("-3x^2 + 8x - 14 ", Operations.subtract(p1,p2).toString());
    }
}
