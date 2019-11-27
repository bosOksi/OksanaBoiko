package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class SubtractDataProvider {

    @DataProvider(name = "Subtract Data Provider")
    public Object [] [] subtractTestDataProvider() {
        return new Object[][] {
                {2, 2, 0},
                {0, 1, -1},
                {-1, 1, -2},
                {-2, -5, 3}
        };
    }
}
