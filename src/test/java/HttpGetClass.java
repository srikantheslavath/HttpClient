

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class HttpGetClass {
    @Test
    public void testGetMethod() throws IOException {

// creating the HTTPCLIENT object
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //create the httpget object

        HttpGet httpget = new HttpGet("https://reqres.in/api/users/2");
        System.out.println("Request Type :" + httpget.getMethod());
        HttpResponse response = httpclient.execute(httpget);
        System.out.println(response);
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().toString());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);

        int code = response.getStatusLine().getStatusCode();
        Assert.assertEquals(code, 200);


    }

    @Test
    public void TestPostMethod() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://reqres.in/api/users");
        String json = "{\"name\":\"vikas\",\"job\":\"instructor\"}";
        httppost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        System.out.println("Request Type:" +httppost.getMethod());
        HttpResponse response = httpclient.execute(httppost);
        System.out.println(response);
        Header[] headers = response.getAllHeaders();
        for(Header head :headers){
            System.out.println(head);
        }


    }
}