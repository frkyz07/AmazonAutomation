package TestPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {


    @Test(dataProvider = "DriverTest")
    public void testCaseData(String greeting, String message, int id){

        System.out.println(greeting);
        System.out.println(message);
        System.out.println(id);
    }

    @DataProvider(name="DriverTest")
    public Object[][] getData(){

        Object[][] data = {{"hello","text",1},{"bye","message",2}, {"solo","call",3}};


        return data;
    }

}
