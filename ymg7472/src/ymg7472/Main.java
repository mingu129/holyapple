package ymg7472;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Main{
	static void menu(){
		System.out.println("###############");
		System.out.println("1.����� �߰�");
		System.out.println("2.����� ����");
		System.out.println("3.����");
		System.out.println("4.������");
		System.out.println("5.����");
		System.out.println("6.�ҷ�����");
		System.out.println("###############");
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int i = 0;
		User[] user = new User[10];
		while(true) {
			menu();
			Scanner s = new Scanner(System.in);
			int a = s.nextInt();
			
			if(a==1) {
				Scanner s1 = new Scanner(System.in);
				User u = new User();
				System.out.println("�̸�:");
				u.setName(s.next());
				System.out.println("����:");
				u.setAge(s.nextInt());
				user[i] = u;
				i++;
				
			}
			
			if(a==2) {
				System.out.println("����� �̸�:");
				String f = s.next();
				for(int r=0; r<10; r++)
				{
					if (user[r] != null && user[r].getName().equals(f)) {
						Scanner s2 = new Scanner(System.in);
						User u = new User();
						System.out.println("�̸�:");
						u.setName(s.next());
						System.out.println("����:");
						u.setAge(s.nextInt());
						user[r] = u;
						s2.close();
					}
				}
			}
			
			if(a==3) {
				Scanner s3 = new Scanner(System.in);
				System.out.println("����� �̸�:");
				String j = s3.next();
				for(int r=0; r<10; r++)
				{
					if (user[r] != null && user[r].getName().equals(j) ) {
						System.out.println("������� �̸�:" + user[r].getName() + ",������� ����:" + user[r].getAge());
					}
				}
			}
			
			if(a==4) {
				System.out.println("�����մϴ�.");
				break;
			}
			if(a==5 ) {
				FileOutputStream output = new FileOutputStream("C:\\Users\\swh\\userslist.txt");
				for(int r=0; r<10; r++)
				{
					if (user[r] != null) {
						String d = user[r].getName() +","+ user[r].getAge()+"\n";
						output.write(d.getBytes());
					}
				}
				output.close();
			}
			if(a==6) {
				FileInputStream input = new FileInputStream("C:\\Users\\swh\\userslist.txt");
		        byte[] data = new byte[1024];  // ���� ������ ���̰� 1024����Ʈ���� ũ�� ���� ���� ���
		        input.read(data);
		        System.out.println(new String(data));
		        input.close();
			}
		}	
		
	}
}