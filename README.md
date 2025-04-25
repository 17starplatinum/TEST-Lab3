# Bombardiro Crocodilo: yeah idc anymore about giving well thought names to my assignments

---
## Лабораторная работа №3
<p align="center">
    <img src="https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExa3U1b2xlMXpvbDh0bWJ0OWM5d2tuNDUyaTkxdjRhcWo1MGl5dzRueSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/enrJj5p6lJD9WoFegD/giphy.gif" alt="yeah idc I wanna go to Irkutsk asap" />
</p>

### Вариант: `839`

## Результат: ${\color{green}100\\%}$

### Текст задания:
Сформировать варианты использования, разработать на их основе тестовое покрытие и провести функциональное тестирование интерфейса сайта (в соответствии с вариантом).
```
Вариант №839: Domaintools.com. Domain name search tool allows wildcard search of current and deleted/expired whois domains. - http://www.domaintools.com/
```
Требования к выполнению работы:
1. Тестовое покрытие должно быть сформировано на основании набора прецедентов использования сайта.
2. Тестирование должно осуществляться автоматически — с помощью системы автоматизированного тестирования Selenium.
3. Шаблоны тестов должны формироваться при помощи Selenium IDE и исполняться при помощи Selenium RC в браузерах Firefox и Chrome.
4. Предполагается, что тестируемый сайт использует динамическую генерацию элементов на странице, т.е. выбор элемента в DOM должен осуществляться не на основании его ID, а с помощью XPath.\
Доп. задание от препода [@Kyoto67](https://github.com/Kyoto67):
5. Реализовать оформление отчёта по тестированию через библиотеку [Allure](https://allurereport.org/).

Требования к содержанию отчёта:
1. Текст задания. 
2. UseCase-диаграмму с прецедентами использования тестируемого сайта. 
3. CheckList тестового покрытия. 
4. Описание набора тестовых сценариев. 
5. Результаты тестирования. 
6. Выводы.

Вопросы к защите лабораторной работы:
1. Функциональное тестирование. Основные понятия, способы организации и решаемые задачи. 
2. Система `Selenium`. Архитектура, принципы написания сценариев, способы доступа к элементам страницы. 
3. Язык `XPath`. Основные конструкции, системные функции, работа с множествами элементов.

## Выполнение
| .pdf (Light)                           | .pdf (Dark)                                  | .pdf (AMOLED)                                  |
|----------------------------------------|----------------------------------------------|------------------------------------------------|
| [Тык](/docs/reports/ST_Report_III.pdf) | [Тык](/docs/reports/ST_Report_III(dark).pdf) | [Тык](/docs/reports/ST_Report_III(AMOLED).pdf) |

Для того чтобы тщательно взяться за работу, мне пришлось сначала составить карту навигации по сайту. Если вам попалась ебахламина как у меня, то рекомендую перед работой сделать как ниже:
![breakdown](/docs/domaintools.png)

### UML:
![UML](/docs/domaintools-UML.drawio(dark).png)

### Сценарии:
| № | Кейс                                                                                           | Успешность |
|---|------------------------------------------------------------------------------------------------|------------|
| 1 | **[Whois поиск](/src/test/java/ru/itmo/cs/kdot/lab3/WhoisTest.java)**                          | +          |
| 2 | **[Смотреть видео-туториалы](/src/test/java/ru/itmo/cs/kdot/lab3/VideoTutorialTest.java)**     | +          |
| 3 | **[Найти через поиск материал из сайта](/src/test/java/ru/itmo/cs/kdot/lab3/SearchTest.java)** | +          |
| 4 | **[Отправить запрос на демо](/src/test/java/ru/itmo/cs/kdot/lab3/DemoTest.java)**              | +          |
| 5 | **[Читать статьи](/src/test/java/ru/itmo/cs/kdot/lab3/ResourceTest.java)**                     | +          |
| 6 | **[Логин](https://account.domaintools.com/log-in/) (вы увидите, почему здесь минус)**          | -          |
