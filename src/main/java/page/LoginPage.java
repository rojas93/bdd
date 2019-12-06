package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement loginInput = $(By.name("login"));
    public SelenideElement passwordInput = $(By.name("password"));
    public SelenideElement loginButton = $(By.xpath("//*[@data-test-id='action-login']"));
}
