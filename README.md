# Orange Blood Heroes

## Instruções de deploy
Após fazer o clone do repositório, em uma máquina com docker e docker-compose instalados, execute o comando abaixo para subir a aplicação:
```bash
docker-compose up -d --build
```
O processo pode demorar um pouco, pois o docker irá baixar as imagens necessárias e construir as imagens da aplicação.

Após Finalizado:

A aplicação estará disponível em http://localhost:8082;
O Swagger estará disponível em http://localhost:8082/swagger-ui.html;
O Prometheus estará disponível em http://localhost:9090/;
O Grafana estará disponível em http://localhost:3000/ (usuário: admin, senha: admin).
