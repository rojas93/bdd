package page;

import helper.BaseHelper;

public class VerificationActions extends VerificationPage {

    public void smsVirify(String smsCode){
        BaseHelper.clearInput(codeInput);
        codeInput.sendKeys(smsCode);
        submitButton.click();
    }
}
