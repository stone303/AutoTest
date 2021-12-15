package operator.impl;

import operator.base.TestBase;
import operator.http.GetClient;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetTest extends TestBase {
        TestBase testBase;
        String host;
        String url;
        GetClient getClient;

        @BeforeClass
        public void setUp(){
            testBase = new TestBase();
            host = prop.getProperty("URL");
            url = host + "/api/users";

        }

        @Test
        public void getApiTest() throws ClientProtocolException, IOException {
            getClient = new GetClient();
            getClient.get(url);
        }

}
