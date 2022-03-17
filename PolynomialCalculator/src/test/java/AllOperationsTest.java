import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        AddOperationTest.class,
        SubtractOperationTest.class,
        MultiplyOperationTest.class,
        DivideOperationTest.class,
        DifferentiateOperationTest.class,
        IntegrateOperationTest.class
})
public class AllOperationsTest {
}
