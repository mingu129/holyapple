package filesend;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class WriteToFile {
    public static void main(String args[]) {
    	long time = System.currentTimeMillis(); 

		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy�� mm�� dd�� hh�� mm�� ss��");

		String str = dayTime.format(new Date(time));

        String message = "This is a sample message.\n";
        
        File file = new File("C:\\text\\"+str+".txt");
        FileWriter writer = null;
        
        try {
            // ���� ������ ���뿡 �̾ ������ true��, ���� ������ ���ְ� ���� ������ false�� �����Ѵ�.
            writer = new FileWriter(file, true);
            writer.write(message);
            writer.flush();
            
            System.out.println("DONE");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
