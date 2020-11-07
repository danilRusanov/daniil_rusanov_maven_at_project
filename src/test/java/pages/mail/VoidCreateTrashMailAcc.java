package pages.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;

public class VoidCreateTrashMailAcc {

    WebDriver driver = new ChromeDriver();


    public void createTrashMailAccForm(String name, String password, String email) {

        driver.get("https://trashmail.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='#tab-register']")).click();

        //form[@class='ng-pristine ng-valid']/div[@class='form-group']/input[@type='text']

        driver.findElement(By.xpath("//div[@class='tab-pane fade active in']//input[@class='form-control ng-pristine ng-untouched ng-valid' and @ng-model='user.name']"))
                .sendKeys(name);
        driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']"))
                .sendKeys(password);
        driver.findElement(By.xpath("//div[@class='tab-pane fade active in']//input[@class='form-control ng-pristine ng-untouched ng-valid' and @ng-model='user.passwordRepeat']"))
                .sendKeys(password);
        driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']"))
                .sendKeys(email);
    }

    public void registerButton() {
        driver.findElement(By.xpath("//form[@class='ng-dirty ng-valid-parse ng-valid ng-valid-email']//button['Register']")).click();
    }


    public boolean registerBlockIsPresent() {
        return driver.findElement(By.xpath("//div[@class='alert ng-scope top am-fade alert-info']")).isDisplayed();
    }

}
