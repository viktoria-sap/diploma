### Шаги до запуска тестов:

1. Git clone;

1. `docker-compose up -d --force-recreate`;

1. `java -jar ./artifacts/aqa-shop.jar -Djdbc:postgresql://localhost:5432/postgres`
*или*
`java -jar ./artifacts/aqa-shop.jar -Djdbc:mysql://localhost:3306/app`

1. `cd ./artifacts/gate-simulator`

1. `npm start`

1. Запуск тестов.