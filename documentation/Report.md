### Отчет по итогам автоматизированного тестирования 
Приложение было протестировано по запланированным [позитивным и негативным сценариям](/documentation/Plan.md). 

Проведено **15 тест-кейсов**: 
* 4 позитивных сценария
* 11 негативных. 

**86.66%** тест-кейсов прошли успешно.

#### AllureReport:
![image](/documentation/Screenshot_3.png)

По итогам тестирования **обнаружено 6 багов**, а также предложено одно улучшение. 

По всем багам заведены [Issues](https://github.com/viktoria-sap/diploma/issues).

 1. Приложение сообщает об успехе при операции с невалидной картой (при недостатке средств). При этом 
       данные не появляются в БД, то есть операция не производится; 
 1. Поле владелец принимает цифры  и успешно отправляет форму с такими данными; 
 1. Видны подсказки о неверном формате, когда данные исправлены на валидные и форма успешно отправлена; 
 1. Некорректная фиксация заказа в кредит в БД; 
