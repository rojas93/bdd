package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    protected SelenideElement codeInput = $(By.name("code"));
    protected SelenideElement submitButton = $(By.xpath("//*[@data-test-id='action-verify']"));
}
