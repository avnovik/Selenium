## Selenium

### Selenium — применение в автоматизированном тестировании

Курс предназначен для тестировщиков, участвующих в проектах по автоматизированному функциональному тестированию и для
пользователей Selenium, которым необходимо подготовить автоматизированные тесты.

Слушатели курса получат необходимые знания для работы с Selenium и сопутствующими инструментами, такими как Maven,
Junit, Allure фреймворком BDD
Помимо теоретической части курс включает практические задания, которые позволяют применять получаемые знания

По завершении курса слушатели смогут:

- Разрабатывать автоматизированные тесты
- Выполнять запуск автоматизированных тестов
- Настраивать систему непрерывной интеграции

### Курс состоит из:

- 6 разделов, включающие видеолекции общей продолжительностью ~15 часов
  Для удобства в описании к видеолекциям прописаны тайм-коды для перехода к интересующим темам
- 4 промежуточных практических задания для проработки изученных тем. На этих заданиях будем создавать и дорабатывать
  свой автотест
  (задания обязательны к выполнению для получения зачета)
- Итоговая практика по всем темам курса, которые обязательны к выполнению для получения зачета по курсу

---
#### [Задание №1_Первый автотест](https://github.com/avnovik/Selenium/blob/main/src/test/java/ru/tests/exercise1/FirstTaskTest.java)
Написать автотест по заданному сценарию:
1. Перейти на страницу http://training.appline.ru/user/login Пройти авторизацию
2. Проверить наличие на странице заголовка Панель быстрого запуска
3. В выплывающем окне раздела Расходы нажать на Командировки
4. Нажать на Создать командировку
5. Проверить наличие на странице заголовка "Создать командировку"
6. На странице создания командировки заполнить или выбрать поля:
   * Подразделение - выбрать Отдел внутренней разработки
   * Принимающая организация - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
   * В задачах поставить чекбокс на "Заказ билетов"
   * Указать города выбытия и прибытия
   * Указать даты выезда и возвращения
   * !! Раздел Командированные сотрудники не заполнять
7. Проверить, что все поля заполнены правильно
8. Нажать "Сохранить и закрыть"
9. Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"

---
#### [Задание №2_Page Object](https://github.com/avnovik/Selenium/blob/second/src/test/java/ru/tests/exercise2/SecondTaskTest.java)
Доработать сценарий из задания № 1:
1. Переписать тест с использованием PageObject и PageFactory
2. Вынести в environment.properties переменные:
   - Браузер, в котором запускаются тесты
   - Путь к драйверу браузера
   - Настроить запуск тестов с использованием maven
   - Выделить класс BaseTest, методы которого могут быть переиспользованы в дргуих тестах

---
#### [Задание №3_Allure](https://github.com/avnovik/Selenium/blob/third/src/test/java/ru/tests/exercise2/SecondTaskTest.java)
К автотесту, разработанному в предыдущих заданиях добавить возможность формирования Allure отчета

---
#### [Задание №4_Cucumber](https://github.com/avnovik/Selenium/blob/fourth/src/test/java/ru/tests/exercise4/feature/cucumberScenario.feature)
Доработать автотест из предыдущих заданий с использованием библиотеки Cucumber

============================