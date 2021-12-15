package operator.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import operator.base.TestBase;
import operator.basecom.JsonBase;
import operator.basecom.Users;
import operator.http.RestHeaderRest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import static operator.config.TestStatusConfig.RESPNSE_STATUS_CODE_201;

public class PostTest extends TestBase {
    TestBase testBase;
    String host;
    String url;

    @BeforeClass
    public void setUp()
    {
        testBase = new TestBase();
        host = prop.getProperty("URL");
        url = host + "/api/users";
        //System.out.println(url);
    }

    @Test
    public void postapi() throws ClientProtocolException, IOException {
        RestHeaderRest restHeaderRest = new RestHeaderRest();
        //准备请求头信息
        HashMap<String, String> hashMap = new HashMap<>();

        //这个在postman中可以查询到
        hashMap.put("Content-Type", "application/json; charset=utf-8");

        //对象转换成Json字符串
        Users user = new Users("duan", "tester");
        String userJsonStr = JSON.toJSONString(user);
        System.out.println(userJsonStr);

        //post请求
        CloseableHttpResponse httpResponse = restHeaderRest.post(url, userJsonStr, hashMap);
        System.out.println(httpResponse);

        //检查code码
        int statcode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statcode, RESPNSE_STATUS_CODE_201, "code  false");


        //接口返回结果json格式化
        String str = EntityUtils.toString(httpResponse.getEntity());
        JSONObject strjson = JSON.parseObject(str);
        System.out.println(strjson);

        //取出对应key值做比对
        String name1 = JsonBase.GetJsonValue(strjson, "name");
        String job1 = JsonBase.GetJsonValue(strjson, "job");
        System.out.println(name1);
        System.out.println(job1);
        Assert.assertEquals(name1, "duan", "name is not duan");
        Assert.assertEquals(job1, "tester", "job is false");

    }

}
