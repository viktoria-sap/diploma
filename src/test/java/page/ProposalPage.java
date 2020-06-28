package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProposalPage {
    private SelenideElement buttonBuyByDebit = $(byText("Купить"));
    private SelenideElement buttonBuyCredit = $(byText("Купить в кредит"));

    public CardData selectBuyByDebitCard() {
        buttonBuyByDebit.click();
        return new CardData();
    }

    public CardData selectBuyByCreditCard() {
        buttonBuyCredit.click();
        return new CardData();
    }
}
