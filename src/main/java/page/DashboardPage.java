package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    public SelenideElement headerLK = $(By.xpath("//*[@data-test-id='dashboard']"));
    public ElementsCollection listCard = $$(By.xpath("//li[@class='list__item']"));

    public SelenideElement depositByNumber(String number){
        for (SelenideElement card: listCard) {
            if (card.getText().contains(number)) return card;
        }
        return null;
    }

    public SelenideElement amountInput = $(By.xpath("//*[@data-test-id='amount']//input"));
    public SelenideElement fromInput = $(By.xpath("//*[@data-test-id='from']//input"));
    public SelenideElement toInput = $(By.xpath("//*[@data-test-id='to']//input"));

    public static String actionDepositXpath = "//*[@data-test-id='action-deposit']";
    public SelenideElement transferButton = $(By.xpath("//*[@data-test-id='action-transfer']"));
}
