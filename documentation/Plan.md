# План автоматизации тестирования
## Автоматизируемые сценарии: 
### Позитивные сценарии:
    1. Ввод валидных данных, с выбиром оплаты по дебетовой карте, операция проходит; 
    2. Ввод валидных данных, с выбором покупки в кредит, операция проходит; 
    3. Ввод валидных данных, с выбором оплаты по дебетовой карте с недостаточным количеством средств, отказ в операции; 
    4. Ввод валидных данных, с выбором оплаты по кредитной карте, отказ в операции.
    
### Негативные сценарии: 
    1. Ввод невалидных данных, с выбиром оплаты по дебетовой карте;
    2. Ввод невалидных данных, с выбором покупки в кредит; 
    
    
**Таким образом проверим, что:**

    1. Когда поле заполнено неверно, появляются уведомления.
    2. Невалидные данные формы не передаются на этап платежного сервиса, а значит операция не проходит.
    3. Есть ограничения полей на ввод невалидных данных: 
        * Граничные значения номера карты - 15 знаков  и 1 знак.
        * Пустое поле в имени пользователя.
        * Неверный cvc код.
        * Неверный формат номера месяца.
        * Неверный формат года.
        * Ввод цифр в поле имя пользователя.
        
## Инструменты: 
1. *GitHub*.
Хранение проекта. Позволяет вернуться к предыдущим коммитам, если новые изменения что-то сломали. Легко склонировать проект и запустить.
1. *Docker*.
Развертывание и запуск приложения из контейнера. Одновременно можно запускать несколько контейнеров, при небольшом потреблении ресурсов.
1. *Faker*.
Генерация данных для тестирования. 
1. *RestAssured*.
Отправка запросов симулятору банковских сервисов, проверка структуры генерируемых ответов. 
1. *Selenide*.
Page Objects, UI тестирование, заполнение формы через веб-интерфейс. Selenide более минималистичен по сравнению с Selenium'ом - упор на логику, а не на способ использования. Сам запускает браузер, не нужно подбирать драйвер. 

## Риски: 
1. Полный цикл тестирования. 
В учебных кейсах в основном затрагивались только части функционала, с более-менне "идеальными" условиями. Но чем шире цикл и чем больше в него входит логики, тем больше возникает сложностей и вероятных пробелов в тестировании.

1. Тестовое окружение.
Две базы данных (MySQL, PostgreSQL), симулятор платежной системы, их взаимодействие - все в купе может потребовать много времени для успешной настройки.
  
## Интервальная оценка с учётом рисков
   * Подготовка окружения - 48 часов. 
   * Разработка - 96 часов
   * Подготовка отчетной документации -  10 часов 
  
## План сдачи работ
   * Подготовка окружения - 25.06  
   * Разработка - 01.06
   * Подготовка отчетной документации - 03.06