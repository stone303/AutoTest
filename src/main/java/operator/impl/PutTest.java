package operator.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import operator.base.TestBase;
import operator.basecom.JsonBase;
import operator.basecom.Users;
import operator.http.RestHeaderRest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static operator.config.TestStatusConfig.RESPNSE_STATUS_CODE_200;

public class PutTest {

     TestBase testBase;
     String url;
     RestHeaderRest restHeaderRest;


     @BeforeClass
     public void  setUp(){
                 TestBase testBase = new TestBase();
                 url = testBase.prop.getProperty("URL")+"/api/users/2";
             }
     @Test
     public void putTest() throws ClassCastException, IOException {

                 RestHeaderRest headerRest = new RestHeaderRest();
                 HashMap<String, String> headermap = new HashMap<>();
                 headermap.put("Content-Type", "application/json; charset=utf-8");
                 System.out.println(headermap);

                 //入参转换成json格式
                 Users users = new Users("duan", "tester");
                 String userJsonString = JSON.toJSONString(users);
                 System.out.println(userJsonString);

                //开始调用put请求
                 System.out.println(url);

                 CloseableHttpResponse response = headerRest.put(url, userJsonString, headermap);

                 int statusCode = response.getStatusLine().getStatusCode();
                 Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200,"CODE码不正确");

                 //验证名称为Anthony的jon是不是 automation tester
                 String responseString = EntityUtils.toString(response.getEntity());
                 JSONObject responseJson = JSON.parseObject(responseString);
                 String jobString = JsonBase.GetJsonValue(responseJson, "job");
                 System.out.println(jobString);
                 Assert.assertEquals(jobString, "tester","job is not same");

             }
}
