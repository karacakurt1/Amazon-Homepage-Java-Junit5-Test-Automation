import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AmazonHomepageTest extends BaseTest{
    @Test
    @Order(1)
    public void homeCoverPhotoChangeClickAndPhotoControlTest(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<String>list=amazonHomepagePage.homeCoverPhotoChangeClickAndPhotoControl();
        for (String i:list){
            Assertions.assertNotEquals(i,"https://www.amazon.com.tr/");
        }
    }
    @Test
    @Order(2)
    public void signInControl(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        String location=amazonHomepagePage.signInControl();
        Assertions.assertNotEquals(location, "https://www.amazon.com.tr/");
    }
    @Test
    @Order(3)
    public void controlBoxesPicturesAndTextsTest(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<List<String>>list=amazonHomepagePage.controlBoxesPicturesAndTexts();
        for (List<String> i:list){
            for (String a:i) {
                Assertions.assertNotEquals(a, "https://www.amazon.com.tr/");
            }
        }
    }
    @Test
    @Order(4)
    public void listControl1Test(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<String>list=amazonHomepagePage.listControl1();
        for (String i:list){
            Assertions.assertNotEquals(i,"https://www.amazon.com.tr/");
        }
    }
    @Test
    @Order(5)
    public void listControl2Test(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<String>list=amazonHomepagePage.listControl2();
        for (String i:list){
            Assertions.assertNotEquals(i,"https://www.amazon.com.tr/");
        }
    }
    @Test
    @Order(6)
    public void listControl3Test(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<String>list=amazonHomepagePage.listControl3();
        for (String i:list){
            Assertions.assertNotEquals(i,"https://www.amazon.com.tr/");
        }
    }
    @Test
    @Order(7)
    public void listControl4Test(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<String>list=amazonHomepagePage.listControl4();
        for (String i:list){
            Assertions.assertNotEquals(i,"https://www.amazon.com.tr/");
        }
    }
    @Test
    @Order(8)
    public void listControl5Test(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<String>list=amazonHomepagePage.listControl5();
        for (String i:list){
            Assertions.assertNotEquals(i,"https://www.amazon.com.tr/");
        }
    }
    @Test
    @Order(9)
    public void listControl6Test(){
        AmazonHomepagePage amazonHomepagePage=new AmazonHomepagePage(driver);
        List<String>list=amazonHomepagePage.listControl6();
        for (String i:list){
            Assertions.assertNotEquals(i,"https://www.amazon.com.tr/");
        }
    }
    @Test
    @Order(10)
    public void listControl7Test() {
        AmazonHomepagePage amazonHomepagePage = new AmazonHomepagePage(driver);
        List<String> list = amazonHomepagePage.listControl7();
        for (String i : list) {
            Assertions.assertNotEquals(i, "https://www.amazon.com.tr/");
        }
    }
}

