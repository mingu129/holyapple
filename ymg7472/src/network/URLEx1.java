package network;

import java.net.MalformedURLException;
import java.net.URL;
public class URLEx1 {
    public static void main(String[] args) {
        URL opinion = null;
        URL homepage = null;
        try {
            homepage = new URL("http://swhacademy.ga:8081");    //  ���� ���
            opinion = new URL(homepage, "sw_newtork/index.html");   //  ��� ���
        } catch (MalformedURLException e) {
            System.out.println("�߸��� URL�Դϴ�.");
        }
        System.out.println("Protocol = " + opinion.getProtocol());  //  ��������
        System.out.println("host =" + opinion.getHost());   //  ȣ��Ʈ �̸�
        System.out.println("port =" + opinion.getPort());   //  ��Ʈ��ȣ
        System.out.println("path =" + opinion.getPath());   //  ���
        System.out.println("filename =" + opinion.getFile());   //  �����̸�
    }
}