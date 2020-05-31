package robotTest;

import java.awt.*;
import java.awt.event.*;

public class RobotTestII
{
  public RobotTestII()
  {
    int keyInput[] =
                     {
                     KeyEvent.VK_F,
                     KeyEvent.VK_U,
                     KeyEvent.VK_C,
                     KeyEvent.VK_K
    };

    try
    {
      // notepad ���α׷� Ȱ��ȭ
      Runtime.getRuntime().exec("notepad");
      Robot robot = new Robot();
      // Hello���� �Է�
      for(int i=0; i<keyInput.length; i++)
      {
        robot.keyPress(keyInput[i]);
        robot.keyRelease(keyInput[i]);
        //���� �ش� �����带 200ms ���� sleep��Ų��.
        robot.delay(700);
      }

      // �޸��忡 �Է��� ���ڸ� ��� �����Ѵ�.
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_A);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_A);

      //���� �ش� �����带 500ms ���� sleep��Ų��.
      robot.delay(500);
      // ���콺 ������ ��ư Ŭ��
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_C);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_C);
      robot.delay(500);
      
      for(int i = 0; i<1000; i++) {
    	  robot.keyPress(KeyEvent.VK_CONTROL);
          robot.keyPress(KeyEvent.VK_V);
          robot.keyRelease(KeyEvent.VK_CONTROL);
          robot.keyRelease(KeyEvent.VK_V);
          robot.keyPress(KeyEvent.VK_ENTER);
          robot.keyRelease(KeyEvent.VK_ENTER);
          robot.keyPress(KeyEvent.VK_ENTER);
          robot.keyRelease(KeyEvent.VK_ENTER);
      }

    }
    catch (AWTException ae)
    {
      ae.printStackTrace();
    }
    catch (java.io.IOException ex)
    {
      ex.printStackTrace();
    }

  }

  public static void main(String[] args)
  {
    new RobotTestII();
    System.exit(0);
  }

}