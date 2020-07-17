package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Name("Дашбоард")
public class DashboardPage extends AkitaPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cardList = $$(".list .list__item");
    @Name("Сумма")
    private SelenideElement fieldAmount = $("[data-test-id=amount] input");
    @Name("Откуда")
    private SelenideElement fieldFrom = $("[data-test-id=from] input");
    @Name("Куда")
    private SelenideElement fieldTo = $("[data-test-id=to] input");
    @Name("Пополнить")
    private SelenideElement buttonAction = $("[data-test-id=action-transfer]");
    @Name("Обновить")
    private SelenideElement buttonActionReload = $("[data-test-id=action-reload]");


    public DashboardPage() {
        heading.waitUntil(Condition.visible, 15000);
    }

    private void openTransferForm(String lastFourDigit) {
        cardList.findBy(Condition.text(lastFourDigit)).$(withText("Пополнить")).click();
        $(withText("Пополнение карты")).shouldBe(visible);
    }

    private void setAmountValue(int amount) {
        fieldAmount.clear();
        fieldAmount.setValue(String.valueOf(amount));
    }

    private void setFromValue(String cardNumber) {
        fieldFrom.setValue(cardNumber);
    }

    private void doTransfer() {
        fieldTo.shouldBe(disabled);
        buttonAction.click();
    }

    public void updateBalance() {
        heading.waitUntil(Condition.visible, 15000);
        buttonActionReload.click();
    }

    public int getBalance(String lastFourDigit) {
        String[] cardInfo = cardList.findBy(Condition.text(lastFourDigit)).getText().split(" ");
        return Integer.parseInt(cardInfo[5]);
    }

    public void moneyTransfer(String lastFourDigitCardTo, String cardNumberFrom, int amount) {
        openTransferForm(lastFourDigitCardTo);
        setAmountValue(amount);
        setFromValue(cardNumberFrom);
        doTransfer();
    }
}
