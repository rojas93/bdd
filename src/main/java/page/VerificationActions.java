package page;

import helper.BaseHelper;

public class VerificationActions extends VerificationPage {

    public void smsVerify(String smsCode){
        BaseHelper.clearInput(codeInput);
        codeInput.sendKeys(smsCode);
        submitButton.click();
    }
}
