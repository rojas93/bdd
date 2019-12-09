package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    protected SelenideElement headerLK = $(By.xpath("//*[@data-test-id='dashboard']"));
    protected ElementsCollection listCard = $$(By.xpath("//li[@class='list__item']"));

    protected SelenideElement depositByNumber(String number){
        for (SelenideElement card: listCard) {
            if (card.getText().contains(number)) return card;
        }
        return null;
    }

    protected SelenideElement amountInput = $(By.xpath("//*[@data-test-id='amount']//input"));
    protected SelenideElement fromInput = $(By.xpath("//*[@data-test-id='from']//input"));

    protected static String actionDepositXpath = "//*[@data-test-id='action-deposit']";
    protected SelenideElement transferButton = $(By.xpath("//*[@data-test-id='action-transfer']"));
}
