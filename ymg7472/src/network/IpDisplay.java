package network;

import java.net.InetAddress;

public class IpDisplay {
    public static void main(String[] args) {
        try{
            // Ȩ������ IP ������ ���
            InetAddress [] ia = InetAddress.getAllByName("swhacademy.gq");
            for(InetAddress imsi : ia){
                System.out.println("SWH IP : "+imsi.getHostAddress());
            }
            // �ڽ��� IP ���
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("My PC IP :" + local.getHostAddress());
        }catch(Exception e){
            // ���ܰ� �߻����� �� ������ ������ ���
            System.out.println(e.getMessage());
        }
    }
}