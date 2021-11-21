# RegistrationUserWithEmailConfirmation

# Sobre o projeto

Registration User é uma API Rest desenvolvida com Spring Boot para implentar um sistema de cadastro de usuário.
O usuário deve informar ao sistema um email e uma senha valida. 
Após receber esses dados o sistema cria um token de confirmação com validade de 15 minutos, após este periodo o token perde sua validade.
Este projeto foi desenvolvido no curso da AmigosCode com o professor e engenherio de software Mama Samba Braima. 


# Diagrama

![Diaggrama](https://github.com/galetedanilo/registration-user-with-email-confirmation/blob/main/assets/diagram.png)

# Padrão Camada

![Padrao](https://github.com/galetedanilo/registration-user-with-email-confirmation/blob/main/assets/camadas.png)

# Tecnologias Utilizadas

## Back end

- Java
- Java Mail
- Spring Boot
- Spring Security
- Lombok
- Maven


# Como Executar o Projeto

## Back end:

Pré-requisito: Java 11

```bash
# clonar repositório
git clone https://github.com/galetedanilo/registration-user-with-email-confirmation.git

# entrar na pasta do back end
cd backend

# executar projeto
./mvnw spring-boot:run
```

# Agradecimentos

-  AmigosCode - www.amigoscode.com/courses
-  Prof. Mama Samba Braima

# Autor

Danilo Fernandes Galete

https://www.linkedin.com/in/galetedanilo/

