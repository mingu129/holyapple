package httpclient;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientPutExample {
    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault();
        HttpPut request = new HttpPut("�ּ�");
        try {
            //  ������ ������
            HttpEntity entity = new StringEntity("������ ���ڿ�", "UTF-8");
            request.setEntity(entity);
            
            //  ����
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