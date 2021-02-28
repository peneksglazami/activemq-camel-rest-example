В данном репозитории находится пример приложения, читающего сообщение из очереди ActiveMQ и отправляющего его
в REST-сервис.

Приложение написано на Spring Boot с использованием стартеров `camel-activemq-starter` и
`camel-rest-starter`. Маршрутизация сообщения в формате Apache Camel задаётся в классе
[ActivemqToRestRouter](./src/main/java/com/github/peneksglazami/activemqcamelrestexample/ActivemqToRestRouter.java).