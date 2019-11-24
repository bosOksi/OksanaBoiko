package dataproviders;

import org.testng.annotations.DataProvider;

public class AddDataProvider {

    @DataProvider(name = "Add Data Provider")
    public Object [] [] addTestDataProvider() {
        return new Object[][] {
                {2, 2, 4},
                {0, 1, 1},
                {-1, 0, -1},
                {-3, -5, -8}
        };
    }
}
