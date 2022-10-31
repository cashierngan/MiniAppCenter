package DataProvider;

import org.testng.annotations.DataProvider;
import helpers.ExcellHelpers;

public class DataProviderManager {

    @DataProvider(name = "data_provider_miniapp")
    public Object[][] dataLogin() {
        ExcellHelpers excelHelpers = new ExcellHelpers();
        Object[][] data = excelHelpers.getDataHashTable(helpers.Helpers.getCurrentDir() + "datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp", 2,3);
        return data;
    }
}
