package stepsdefinition;

import io.cucumber.java.Before;
import utilities.RestAssuredExtension;

public class TestInitializer {

    @Before
    public void TestSetUp(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }

}
