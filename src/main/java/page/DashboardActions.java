package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.Card;
import helper.BaseHelper;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DashboardActions extends DashboardPage {

    public List<Card> getListCard() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card("5559 0000 0000 0001", 10000, "0001"));
        cardList.add(new Card("5559 0000 0000 0002", 1000, "0002"));
        return cardList;
    }


    public String getBalanceByNumber(String secretNumber) {
        headerLK.should(Condition.exist);
        SelenideElement deposit = depositByNumber(secretNumber);
        return deposit.getText().split("баланс:")[1].split(" ")[1].trim();
    }


    public void transferCardToCard(Card cardTo, Card cardFrom, String amount) {
        depositByNumber(cardTo.getSecretNumber()).find(By.xpath("." + actionDepositXpath)).click();
        BaseHelper.clearInput(amountInput);
        amountInput.sendKeys(amount);
        BaseHelper.clearInput(fromInput);
        fromInput.sendKeys(cardFrom.getNumber());
        transferButton.click();
    }

    public void checkNotTransferListCard() {
        amountInput.shouldHave(Condition.visible);
    }

    public void checkTransferBalance(Card cardTo, Card cardFrom, double balanceTo, double balanceFrom) {
        assertEquals(cardTo.getBalance(), balanceTo);
        assertEquals(cardFrom.getBalance(), balanceFrom);
    }

    public List<Card> resetBalance(List<Card> cardList){
        for (Card card: cardList) {
            card.setBalance(Double.parseDouble(getBalanceByNumber(card.getSecretNumber())));
        }
        return cardList;
    }
}
