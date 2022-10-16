import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    WebDriverWait waitAttribute;
    Actions actions;
    public BasePage(WebDriver driver) {
            this.driver=driver;
            actions = new Actions(this.driver);
        }
    public WebElement find(By locator) {
            return driver.findElement(locator);
        }
    public List<WebElement> findAll(By locator) {
            return driver.findElements(locator);
        }
    public void click(By locator) {
            find(locator).click();
        }
    public void click(WebElement element) {
            element.click();
        }
    public WebElement wait(By locator) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    public WebElement wait(WebElement element) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                return wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    public String getAttribute(By locator, String attribute) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            boolean count=true;
            String value="";
            while (count==true){
               value = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute(attribute);
                if (value!=""){
                    count=false;
                }
            }
            return value;
        }
    public void sleep(int value){
            try{
                Thread.sleep(value);
            }
            catch (InterruptedException ex)
            {
            }
        }
    public void cookie(By locator){
             try{
                click(locator);
             }
             catch (Exception e){

             }
        }
    public void scrollToPage(int piksel) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,"+piksel+")");
            sleep(1000);
        }
    public void scrollToPageFind(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean count=true;
            while (count==false){
                js.executeScript("window.scrollBy(0,"+300+")");
                sleep(1000);
                try {
                    wait(element);
                    count=false;
                }
                catch (Exception e){
                    count=true;
                }
            }
        }
    public void moveToElement(WebElement element) {

            actions.moveToElement(element).perform();
            sleep(1000);
        }
    public List<String>listControl(By cookie,By buttons,By cards){
            cookie(cookie);
            List<WebElement>buttonsList=findAll(buttons);
            List<WebElement>cardList=findAll(cards);
            List<String> location=new ArrayList<String>();
            for(int a=0;a<cardList.size();a++){
                boolean count=true;
                while (count==true){
                    try {
                        cardList=findAll(cards);
                        cookie(cookie);
                        scrollToPageFind(cardList.get(a));
                        wait(cardList.get(a));
                        click(cardList.get(a));
                        String getlocation = driver.getCurrentUrl();
                        location.add(getlocation);
                        driver.navigate().back();
                        count=false;
                    }
                    catch (Exception e){
                        buttonsList=findAll(buttons);
                        cardList=findAll(cards);
                        scrollToPageFind(buttonsList.get(1));
                        moveToElement(cardList.get(a));
                        click(buttonsList.get(1));
                    }
                }
            }
            for (int i=1;i>=0;i--){
                cardList=findAll(cards);
                cookie(cookie);
                sleep(2000);
                scrollToPageFind(cardList.get(0));
                buttonsList=findAll(buttons);
                if (i==1){
                    moveToElement(cardList.get(i));
                }
                click(buttonsList.get(i));
                click(buttonsList.get(i));
                click(buttonsList.get(i));
            }
            wait(cardList.get(0));
            return location;
        }
    public List<String>boxElementControl(By cookie,By elements){
            cookie(cookie);
            List<WebElement> cardList=findAll(elements);
            List<String> location=new ArrayList<String>();
            int sizeCardList=cardList.size();
            for(int i=0;i<sizeCardList;i++){
                cookie(cookie);
                cardList=findAll(elements);
                scrollToPageFind(cardList.get(i));
                System.out.println((cardList.get(i)));
                wait(cardList.get(i));
                click(cardList.get(i));
                String getlocation = driver.getCurrentUrl();
                location.add(getlocation);
                driver.navigate().back();
            }
            return location;
        }
    }
