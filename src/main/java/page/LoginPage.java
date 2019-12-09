package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    protected SelenideElement loginInput = $(By.name("login"));
    protected SelenideElement passwordInput = $(By.name("password"));
    protected SelenideElement loginButton = $(By.xpath("//*[@data-test-id='action-login']"));
}
