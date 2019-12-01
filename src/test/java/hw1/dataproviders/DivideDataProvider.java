package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivideDataProvider {

    @DataProvider(name = "Divide Data Provider")
    public Object [] [] divideTestDataProvider() {
        return new Object[][] {
                {2, 2, 1},
                {0, 1, 0},
                {6, 3, 2}
        };
    }
}
