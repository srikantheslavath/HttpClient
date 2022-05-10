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

public class MarchWebinar {
    //what will be there in put post and patch
    //while sending the api load?
    //BODY

@Test
    public void doWork() throws IOException {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    //create http get object

    HttpGet httpget1 = new HttpGet("https://reqres.in/api/users?page=2");
    System.out.println("request type is " + httpget1.getMethod());
    HttpResponse response = httpclient.execute(httpget1);
    System.out.println(response);
    //validation
    System.out.println(response.getStatusLine().getStatusCode());
    System.out.println(response.getProtocolVersion());
    System.out.println(response.getStatusLine().toString());
    System.out.println(response.getStatusLine().getReasonPhrase());
//assertion=expected vs actual
    Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
}
@Test
 public  void doMoreWork() throws IOException {

   CloseableHttpClient httpClient=HttpClients.createDefault();
    HttpPost httpPost=new HttpPost("https://reqres.in/api/users");
    String  json="{\"name\":\"aryav\",\"job\":\"instructor\"}";

    httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
    System.out.println("the request type is "+httpPost.getMethod());
    HttpResponse response=httpClient.execute(httpPost);
    System.out.println(response);
    System.out.println(response.getStatusLine());
    System.out.println(response.getStatusLine().getStatusCode());
    System.out.println(response.getStatusLine().getReasonPhrase());

    Header[] headers= response.getAllHeaders();
    for(Header head:headers){
        System.out.println("from here headers start "+head);
    }
}
}
