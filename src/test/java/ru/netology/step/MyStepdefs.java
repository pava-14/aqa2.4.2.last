package ru.netology.step;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.ru.Пусть;
import lombok.val;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.page;
import static ru.alfabank.tests.core.helpers.PropertyLoader.loadProperty;

public class MyStepdefs {
    private final String cardNunber0001 = "5559 0000 0000 0001";
    private final String cardNunber0002 = "5559 0000 0000 0002";

    private final AkitaScenario scenario = AkitaScenario.getInstance();

    @Пусть("^пользователь залогинен с именем \"([^\"]*)\" и паролем \"([^\"]*)\"$")
    public void loginWithNameAndPassword(String login, String password) {

        val loginUrl = loadProperty("loginUrl");
        Selenide.open(loginUrl);

//        scenario.setCurrentPage(scenario.getPage("Страница входа"));
        scenario.setCurrentPage(page(LoginPage.class));

        val loginPage = (LoginPage) scenario.getCurrentPage().appeared();
        val authInfo = new DataHelper.AuthInfo(login, password);
        scenario.setCurrentPage(loginPage.validLogin(authInfo));
        val verificationPage = (VerificationPage) scenario.getCurrentPage().appeared();
        val verificationCode = DataHelper.getVerificationCode(authInfo);
        scenario.setCurrentPage(verificationPage.validVerify(verificationCode));
        scenario.getCurrentPage().appeared();
    }
}
