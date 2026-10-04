package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class DaynamicPrice {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=825671333270&hvpos=&hvnetw=g&hvrand=4120824475084749677&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061819&hvtargid=kwd-64107830&hydadcr=14452_2479340&mcid=e9c68a2d0f333bcaacd29ec00843c329&hvocijid=4120824475084749677--&hvexpln=nav&gad_source=1");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Shrit");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        String[] names={"Men's Regular Fit 100% Cotton Formal Shirt"};

        List<WebElement> lists=driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']"));
        //lists.get(1).click();

        for(int i=0;i<lists.size();i++){
            String itmestext=lists.get(i).getText();
            System.out.println(itmestext);
            List items= Arrays.asList(names);
            System.out.println(items);
            if(itmestext.contains(items.get(i).toString())){
                String price = lists.get(i).findElement(By.xpath(".//following::span[@class='a-price-whole']")).getText();
                String ShirtPrice=driver.findElement(By.xpath("//span[text()='"+price+"']")).getText();
                System.out.println(ShirtPrice);

                driver.close();

                break;
            }
        }
    }
}
