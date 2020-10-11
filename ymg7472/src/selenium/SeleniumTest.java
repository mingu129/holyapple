package selenium; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
/**
 * <pre>
 * selenium 
 * SeleniumTest.java
 *
 * ���� :
 * </pre>
 * 
 * @since : 2020. 8. 16.
 * @author : ymg74
 * @version : v1.0
 */
public class SeleniumTest {

    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/selenium/chromedriver_win32/chromedriver.exe";
    
    //ũ�Ѹ� �� URL
    private String base_url;
    
    public SeleniumTest(String s) {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        //Driver SetUp
        driver = new ChromeDriver(options);
//        base_url = "https://www.twitch.tv/rlgus1006/clips?filter=clips&range=all";
        base_url = s;
    }
 
    public String crawl() {
    	String result = "";
        try {
            //get page (= ���������� url�� �ּ�â�� ���� �� request �� �Ͱ� ����)
            driver.get(base_url);
            result = driver.getPageSource();
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
        	
            driver.close();
        }
        return result;
 
    }

 
}

