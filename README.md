# versionamento-documentacao-api
API com versionamento e autodocumentação

# Comando para parar a execução da aplicação (8091 - numero da porta)
kill `lsof -i -n -P | grep TCP | grep 8091 | tr -s " " "\n" | sed -n 2p`


# Endereço para visualizar a auto documentação
http://localhost:8091/swagger-ui.html
