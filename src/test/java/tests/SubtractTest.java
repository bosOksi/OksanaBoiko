package tests;

import com.epam.tat.module4.Calculator;
import dataproviders.SubtractDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SubtractTest {

    Calculator calculator = new Calculator();

    @Test(dataProviderClass = SubtractDataProvider.class,
            dataProvider = "Subtract Data Provider",
            groups = "Add and Subtract")
    public void subtractTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        System.out.println("SubtractTest");
        assertEquals(actual, expected);
    }
}
