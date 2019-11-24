package tests;

import com.epam.tat.module4.Calculator;
import dataproviders.AddDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTest {

    Calculator calculator = new Calculator();

    @Test(dataProviderClass = AddDataProvider.class,
            dataProvider = "Add Data Provider",
            groups = "Add and Subtract")
    public void addTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        System.out.println("AddTest");
        assertEquals(actual, expected);
    }
}
