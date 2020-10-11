package httpclient;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * <pre>
 * httpclient 
 * HttpClientGetExample.java
 *
 * ���� :
 * </pre>
 * 
 * @since : 2020. 7. 12.
 * @author : ymg74
 * @version : v1.0
 */
public class HttpClientGetExample {
    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/park1200656/KnuSentiLex/master/data/SentiWord_info.json");
        try {
            //  �ʿ信 ���󼭴� ��� �߰�
//          request.addHeader("Content-type", "application/json");
            
            //  ��û
            HttpResponse response = client.execute(request);
            
            //  ����
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }
}