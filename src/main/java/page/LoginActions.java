package page;

import helper.BaseHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginActions extends LoginPage{

    public void login(String login, String password, String code){
        BaseHelper.clearInput(loginInput);
        loginInput.sendKeys(login);
        BaseHelper.clearInput(passwordInput);
        passwordInput.sendKeys(password);
        loginButton.click();
        VerificationActions verificationActions = new VerificationActions();
        verificationActions.smsVirify(code);
    }

    public void checkLogin(){
        DashboardActions dashboardActions = new DashboardActions();
        dashboardActions.headerLK.waitUntil(visible, 15000);
        dashboardActions.headerLK.shouldHave(exactText("Личный кабинет"));
    }

    public void openLogin() {
        open("http://localhost:9999");
    }

}
