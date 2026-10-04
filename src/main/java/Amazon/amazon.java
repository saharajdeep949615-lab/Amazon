package Amazon;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class amazon {
    public static WebDriver driver=null;
    public static void main(String[] args) throws InterruptedException, IOException {
        try {
            driver = new ChromeDriver();
            driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=825671333270&hvpos=&hvnetw=g&hvrand=4120824475084749677&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061819&hvtargid=kwd-64107830&hydadcr=14452_2479340&mcid=e9c68a2d0f333bcaacd29ec00843c329&hvocijid=4120824475084749677--&hvexpln=nav&gad_source=1");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Shrit");
            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

            String[] names = {"Men's Regular Fit 100% Cotton Formal Shirt"};

            List<WebElement> lists = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']"));
            //lists.get(1).click();

            for (int i = 0; i < lists.size(); i++) {
                String itmestext = lists.get(i).getText();
                System.out.println(itmestext);
                List items = Arrays.asList(names);
                System.out.println(items);
                if (itmestext.contains(items.get(i).toString())) {
                    lists.get(i).findElement(By.xpath(".//following::h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")).click();
                    break;
                }
            }
            Set<String> window = driver.getWindowHandles();
            Iterator<String> it = window.iterator();
            String parentId = it.next();
            String childId = it.next();

            driver.switchTo().window(childId);
            String headingText = driver.findElement(By.xpath("//*[@class='a-size-large product-title-word-break']")).getText();
            System.out.println(headingText);

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("C:\\Users\\sahar\\IdeaProjects\\Amazon.workspace\\SS\\SS_PAge.png"));
        }catch (Exception e){
            System.out.println("Not working");
            driver.quit();
        }
        driver.quit();
    }
}
