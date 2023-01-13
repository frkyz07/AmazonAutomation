package TestPackage;

import AbstractComponents.AbstractComponent;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class AmazonGiftTest extends BaseTest {

    public String path = "//src//main//java//Data//PurchaseOrder.json";

    @Test(dataProvider = "getData",retryAnalyzer = Retry.class)
    public void giftTestForTechProducts(HashMap<Object,Object> input){
        landingPage.goToGiftIdeas().selectProduct((String) input.get("person"),
                (String) input.get("category"),(String) input.get("product")).buyProduct();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return AbstractComponent.dataGetter(path);
    }
}
