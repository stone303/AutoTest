package operator.impl;

import operator.base.TestBase;
import operator.http.RestHeaderRest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DelTest {
     TestBase testBase;
     String url;
     RestHeaderRest restHeaderRest;
 //    CloseableHttpResponse closeableHttpResponse;

     @BeforeClass
     public void  setUp(){
         TestBase testBase = new TestBase();
         url = testBase.prop.getProperty("URL")+"/api/users/2";
     }


     @Test
     public void delTest() throws ClassCastException, IOException {

         RestHeaderRest restHeaderRest = new RestHeaderRest();
         CloseableHttpResponse delete = restHeaderRest.delete(url);

         int statusCode = delete.getStatusLine().getStatusCode();
         Assert.assertEquals(statusCode,204,"CODE码不正确");

     }

}
