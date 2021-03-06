#language:ru

Функциональность: Вход
#  Структура сценария: Вход в личный кабинет
#    Пусть совершен переход на страницу "Страница входа" по ссылке "loginUrl"
#    Когда в поле "Логин" введено значение "&lt;login&gt;"
#    И в поле "Пароль" введено значение "&lt;password&gt;"
#    И выполнено нажатие на кнопку "Продолжить"
#    Тогда страница "Подтверждение входа" загрузилась
#    Когда в поле "Код" введено значение "&lt;code&gt;"
#    И выполнено нажатие на кнопку "Продолжить"
#    Тогда страница "Дашбоард" загрузилась
#
#    Примеры:
#      | login | password  | code  |
#      | vasya | qwerty123 | 99999 |

  Сценарий: Вход в личный кабинет
    Пусть пользователь залогинен с именем "vasya" и паролем "qwerty123"
    Тогда "true" is true
