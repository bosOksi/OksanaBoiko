package dataproviders;

import org.testng.annotations.DataProvider;

public class MultiplyDataProvider {

    @DataProvider(name = "Multiply Data Provider")
    public Object [] [] multiplyTestDataProvider() {
        return new Object[][] {
                {2, 2, 4},
                {0, 1, 0},
                {-1, 0, 0}
        };
    }
}
