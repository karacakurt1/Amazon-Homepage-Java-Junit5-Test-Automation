import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;
import java.util.ArrayList;

public class AmazonHomepagePage extends BasePage{
    By cookie=By.cssSelector("input[id='sp-cc-accept']");
    By signUp=By.cssSelector("a[class*='a-button-text']");
    By photoButtons=By.cssSelector("div[cel_widget_id*='gw-desktop-hero-'] i[class*='a-icon a-icon-']");
    By photoClickButton=By.cssSelector("div[class='a-row a-carousel-controls a-carousel-row a-carousel-has-buttons a-carousel-overlay-buttons a-carousel-rounded-buttons']");
    By photoCard=By.cssSelector("div[class='a-carousel-viewport'] li[class='a-carousel-card']  img[alt]");
    By photoValue=By.cssSelector("input[class='a-carousel-firstvisibleitem']");
    By texts =By.cssSelector("a[class='a-link-normal see-more truncate-1line']");
    By images=By.cssSelector("div[class='a-section a-spacing-none fluid-image-container']");
    By list1Buttons=By.cssSelector("div[id='desktop-1'] a[aria-label*='Carousel']");
    By list1Card =By.cssSelector("div[id='desktop-1'] li[class*='feed-carousel-card']");
    By list2Buttons =By.cssSelector("div[id='desktop-2'] a[aria-label]");
    By list2Card =By.cssSelector("div[id='desktop-2'] li[class*='feed-carousel-card']");
    By list3Buttons =By.cssSelector("div[id='desktop-3'] a[aria-label*='Carousel']");
    By list3Card =By.cssSelector("div[id='desktop-3'] li[class*='feed-carousel-card']");
    By list4Buttons =By.cssSelector("div[id='desktop-4'] a[aria-label]");
    By list4Card =By.cssSelector("div[id='desktop-4'] li[class*='feed-carousel-card']");
    By list5Buttons =By.cssSelector("div[id='desktop-5'] a[aria-label*='Carousel']");
    By list5Card =By.cssSelector("div[id='desktop-5'] li[class*='feed-carousel-card']");
    By list6Buttons =By.cssSelector("div[id='desktop-6'] a[aria-label]");
    By list6Card =By.cssSelector("div[id='desktop-6'] li[class*='feed-carousel-card']");
    By list7Buttons =By.cssSelector("div[id='desktop-7'] a[aria-label*='Carousel']");
    By list7Card =By.cssSelector("div[id='desktop-7'] li[class*='feed-carousel-card']");
    public AmazonHomepagePage(WebDriver driver) {
        super(driver);
    }
    public List<String> homeCoverPhotoChangeClickAndPhotoControl(){
        cookie(cookie);
        wait(photoButtons);
        wait(photoCard);
        sleep(5);
        List<WebElement>photoButtonsList=findAll(photoButtons);
        List<WebElement>photoCardsList=findAll(photoCard);
        List<String> location=new ArrayList<String>();
        int sizeButtons=photoButtonsList.size();
        int sizeCards=photoCardsList.size();
        for (int i=0;i<sizeButtons;i++) {
            for (int a=1;a<=sizeCards;a++){
                int count=0;
                while (count<1){
                    cookie(cookie);
                    sleep(2000);
                    String value=getAttribute(photoValue,"value");
                    if (Integer.parseInt(value)==a)
                    {
                        wait(photoClickButton);
                        click(photoClickButton);
                        String getlocation = driver.getCurrentUrl();
                        location.add(getlocation);
                        driver.navigate().back();
                        count=1;
                    }
                    else {
                        photoButtonsList=findAll(photoButtons);
                        click(photoButtonsList.get(i));
                    }
                }
            }
        }
        return location;
    }
    public String signInControl(){
        cookie(cookie);
        wait(signUp);
        click(signUp);
        String location = driver.getCurrentUrl();
        return location;
    }
    public List<List<String>>  controlBoxesPicturesAndTexts(){
        List<String> imagesList=boxElementControl(cookie,images);
        List<String> textsList=boxElementControl(cookie,texts);
        List<List<String>> matrixLocation= new ArrayList<List<String>>();
        matrixLocation.add(imagesList);
        matrixLocation.add(textsList);
        return matrixLocation;
    }
    public List<String> listControl1(){
        List<String> location=listControl(cookie,list1Buttons,list1Card);
        return  location;
    }
    public List<String> listControl2(){
        List<String> location=listControl(cookie,list2Buttons,list2Card);
        return  location;
    }
    public List<String> listControl3(){
        List<String> location=listControl(cookie,list3Buttons,list3Card);
        return  location;
    }
    public List<String> listControl4(){
        List<String> location=listControl(cookie,list4Buttons,list4Card);
        return  location;
    }
    public List<String> listControl5(){
        List<String> location=listControl(cookie,list5Buttons,list5Card);
        return  location;
    }
    public List<String> listControl6(){
        List<String> location=listControl(cookie,list6Buttons,list6Card);
        return  location;
    }
    public List<String> listControl7(){
        List<String> location=listControl(cookie,list7Buttons,list7Card);
        return  location;
    }
}
