import data.Card;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import page.DashboardActions;
import page.LoginActions;

import java.util.HashMap;
import java.util.List;

public class TestTransferCardToCard {

    @ParameterizedTest
    @MethodSource("dataGenerator.DataGenerator#getCredLogin")
    public void testLoginLK(HashMap<String, String> value){
        LoginActions loginActions = new LoginActions();
        loginActions.openLogin();
        loginActions.login(value.get("login"), value.get("password"), value.get("code"));
        loginActions.checkLogin();
    }

    @ParameterizedTest
    @MethodSource("dataGenerator.DataGenerator#getCredLogin")
    public void testTransferCardToCardFail(HashMap<String, String> value){
        DashboardActions dashboardActions = new DashboardActions();
        LoginActions loginActions = new LoginActions();
        loginActions.openLogin();
        loginActions.login(value.get("login"), value.get("password"), value.get("code"));
        List<Card> cardList = dashboardActions.getListCard();
        for (Card card: cardList) {
            card.setBalance(Double.parseDouble(dashboardActions.getBalanceByNumber(card.getSecretNumber())));
        }
        dashboardActions.transferCardToCard(cardList.get(0), cardList.get(1), String.valueOf(cardList.get(1).getBalance() + 1));
        dashboardActions.checkNotTransferListCard();
    }

    @ParameterizedTest
    @MethodSource("dataGenerator.DataGenerator#getCredLogin")
    public void testTransferCardToCardDouble(HashMap<String, String> value){
        DashboardActions dashboardActions = new DashboardActions();
        LoginActions loginActions = new LoginActions();
        loginActions.openLogin();
        loginActions.login(value.get("login"), value.get("password"), value.get("code"));
        List<Card> cardList = dashboardActions.getListCard();
        cardList = dashboardActions.resetBalance(cardList);
        dashboardActions.transferCardToCard(cardList.get(0), cardList.get(1), "10,0");
        double balanceTo = cardList.get(0).getBalance() + 10;
        double balanceFrom = cardList.get(1).getBalance() - 10;
        cardList = dashboardActions.resetBalance(cardList);
        dashboardActions.checkTransferBalance(cardList.get(0), cardList.get(1), balanceTo, balanceFrom);
    }

    @ParameterizedTest
    @MethodSource("dataGenerator.DataGenerator#getCredLogin")
    public void testTransferCardToCardInt(HashMap<String, String> value){
        DashboardActions dashboardActions = new DashboardActions();
        LoginActions loginActions = new LoginActions();
        loginActions.openLogin();
        loginActions.login(value.get("login"), value.get("password"), value.get("code"));
        List<Card> cardList = dashboardActions.getListCard();
        cardList = dashboardActions.resetBalance(cardList);
        dashboardActions.transferCardToCard(cardList.get(0), cardList.get(1), "10");
        double balanceTo = cardList.get(0).getBalance() + 10;
        double balanceFrom = cardList.get(1).getBalance() - 10;
        cardList = dashboardActions.resetBalance(cardList);
        dashboardActions.checkTransferBalance(cardList.get(0), cardList.get(1), balanceTo, balanceFrom);
    }
}
