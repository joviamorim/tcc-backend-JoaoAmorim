# TCC: Desenvolvimento de sistema para reunir dados de músicas e transformá-los em informação através de gráficos e análises.

 No momento, está sendo consumida a API do Spotify.
 
 Para que o sistema funcione, os usuários devem permitir o uso de alguns dados de seu perfil do Spotify. Para isso, será feita uma requisição ao usuário logo ao abrir o sistema.

 Até o momento, o sistema não possui uma interface amigável ao usuário, mas as requisições à API do Spotify já podem ser feitas.

 ## Para o funcionamento do projeto, é necessário:
 - Uma conta no Spotify;
 - Criar um APP no Spotify: https://developer.spotify.com/dashboard
 - Aplicar o Client Id, o Client Secret e o Redirect URI do seu APP em um arquivo que o application.properties consiga fazer a leitura, por exemplo em um arquivo chamado application-secrets.properties
 - Salvar o arquivo application-secrets.properties dentro de resources (mesmo caminho de application.properties)

**O .gitignore está configurado para não subir o arquivo application-secrets.properties para não vazar as chaves de seu APP**

 ## Código exemplo do application-secrets.properties:

 ```
 spotify.clientId= SEU_CLIENT_ID
 spotify.clientSecret= SEU_CLIENT_SECRET
 spotify.redirectUri= SEU_REDIRECT_URI
 ```
