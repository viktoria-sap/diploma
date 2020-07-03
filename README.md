### О программе:
Предназначена для автоматизированного тестирования сервиса по покупке тура с помощью дебетовой карты или с получением кредита по данным дебетовой карты.

### Тестовое окружение
1. Node.js, Docker; 
1. Свободные порты 8080, 9999 и 5432 или 3306 (в зависимости от базы данных);

### Шаги до запуска тестов:

1. Git clone;

1. Запуск контейнера, в котором разворачивается база данных:
`docker-compose up -d --force-recreate`;

1. Запуск приложения (в зависимости от базы данных):
`java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres -jar artifacts/aqa-shop.jar`

*или*

`java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar`

1. Из каталога gate-simulator запустите симулятор банковского сервиса:
 `npm start`;

### Запуск тестов (в зависимости от базы данных):
`./gradlew test -Ddb.url=jdbc:postgresql://localhost:5432/postgres -Dlogin=app -Dpassword=pass -Dapp.url=http://localhost:8080`

*или*

`./gradlew test -Ddb.url=jdbc:mysql://localhost:3306/app -Dlogin=app -Dpassword=pass -Dapp.url=http://localhost:8080`