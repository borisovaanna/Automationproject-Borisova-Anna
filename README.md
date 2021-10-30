# -Команда для просмотра доступных обновлений библиотек:
mvn versions:display-dependency-updates
The following dependencies in Dependencies have newer versions:
[INFO]   com.codeborne:selenide ................ 5.25.0-selenium-4.0.0 -> 6.0.3
[INFO]   io.cucumber:cucumber-core ............................. 4.7.1 -> 7.0.0
[INFO]   io.cucumber:cucumber-java ............................. 4.7.1 -> 7.0.0
[INFO]   io.cucumber:cucumber-testng ........................... 4.7.1 -> 7.0.0
[INFO]   io.qameta.allure:allure-testng ...................... 2.15.0 -> 2.16.0#
# -Команда для запуска testng.xml файла (Предварительно прописав конфигурации в pom.xml файле)
Вывод команды:
[INFO] Results:
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
# -Команда для проброса параметра из mvn command line в Lecture_14
mvn clean -Dsuite="src/test/resources/Lecture_14.xml", 
где Lecture_14-xml файл с тестами из класса Task_14.Task_14_Herokuapp

