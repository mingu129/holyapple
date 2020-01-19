package network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
public class URLEx2 {
    public static void main(String[] args) {
        try {
            URL url= new URL("https://www.naver.com");
            //  Case1 : URL���
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            
            //  Case2 : URLConnection��� (HTTP POST������� ������ �����͸� ����)
//            URLConnection uc = url.openConnection();
//            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) //  �� �྿ �б�
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            System.out.println("URL���� �����͸� �д� �� ������ �߻� �߽��ϴ�.");
        }
    }
}