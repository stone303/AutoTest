package operator.http;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class GetClientTest {

    GetClient getClient;
    @Test
    public void testGet() {

        String url="https://api.apiopen.top/getJoke?page=1&count=2&type=video";

        try {
            getClient =new GetClient();
            getClient.get(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}