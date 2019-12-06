package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    public SelenideElement codeInput = $(By.name("code"));
    public SelenideElement submitButton = $(By.xpath("//*[@data-test-id='action-verify']"));
}
