package tests;

import com.epam.tat.module4.Calculator;
import dataproviders.MultiplyDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class MultiplyTest {

    Calculator calculator = new Calculator();

    @Test(dataProviderClass = MultiplyDataProvider.class,
            dataProvider = "Multiply Data Provider",
            groups = "Multiply and Divide")
    public void multiplyTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        System.out.println("MultiplyTest");
        assertEquals(actual, expected);
    }
}
