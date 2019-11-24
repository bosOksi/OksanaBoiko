package tests;

import com.epam.tat.module4.Calculator;
import dataproviders.DivideDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DivideTest {

    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DivideDataProvider.class,
            dataProvider = "Divide Data Provider",
            groups = "Multiply and Divide")
    public void divideTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        System.out.println("DivideTest");
        assertEquals(actual, expected);
    }
}
