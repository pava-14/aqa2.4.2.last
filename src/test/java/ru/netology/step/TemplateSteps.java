package ru.netology.step;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.ru.Пусть;
import lombok.val;
import org.junit.jupiter.api.Test;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.page;
import static ru.alfabank.tests.core.helpers.PropertyLoader.loadProperty;

/*
 * cards:
 * first:
 * number: '5559 0000 0000 0001'
 * balance: 10 000 RUB
 * second:
 * number: '5559 0000 0000 0002'
 * balance: 10 000 RUB

1. Перевода с определённой карты на другую карту n'ой суммы
2. Проверки баланса по карте (со страницы списка карт)
 */
public class TemplateSteps {
    private final String cardNunber0001 = "5559 0000 0000 0001";
    private final String cardNunber0002 = "5559 0000 0000 0002";

    private final AkitaScenario scenario = AkitaScenario.getInstance();

//    @Пусть("^пользователь залогинен с именем \"([^\"]*)\" и паролем \"([^\"]*)\"$")

//    @Пусть("^пользователь залогинен с именем \\\"([^\\\"]*)\\\" и паролем \\\"([^\\\"]*)\\\"$")
//    private void openDashboard(String login, String password) {
//
//        val loginUrl = loadProperty("loginUrl");
//        Selenide.open(loginUrl);
//
//        scenario.setCurrentPage(page(LoginPage.class));
//        val loginPage = (LoginPage) scenario.getCurrentPage().appeared();
//        val authInfo = new DataHelper.AuthInfo(login, password);
//        scenario.setCurrentPage(loginPage.validLogin(authInfo));
//        val verificationPage = (VerificationPage) scenario.getCurrentPage().appeared();
//        val verificationCode = DataHelper.getVerificationCode(authInfo);
//        scenario.setCurrentPage(verificationPage.validVerify(verificationCode));
//        scenario.getCurrentPage().appeared();
//    }

    /*
    Когда он переводит "5 000" рублей с карты с номером "5559 0000 0000 0002" на свою "1" карту с главной страницы;
     */
    @Test
//    public void shouldTransferFromCard0001toCard002 () {
//        DashboardPage page = openDashboard();
//        page.updateBalance();
//        int currentBalance = page.getBalance("0001");
//        int expected = currentBalance + 5000;
//        page.moneyTransfer("0001", cardNunber0002, 5000);
//        page.updateBalance();
//        assertEquals(expected, page.getBalance("0001"));
//    }

    /*
    Тогда баланс его "1" карты из списка на главной странице должен стать "15 000" рублей.
     */
    public void shouldCheckBalanceTransferFromCard000() {

    }
}