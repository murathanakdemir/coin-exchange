# Coin Exchange

## Installation

- Install [Docker Destop](https://www.docker.com/products/docker-desktop)
  according to your OS.
- Run Docker Desktop App and start Docker engine.

## Run Project

- Go to exchange project root folder and run the following commands from terminal according to your OS:

Linux or Mac:
```bash
cd scripts
bash build-project.sh
bash docker-compose-up.sh
```

Windows:
```bash
cd scripts
build-project.bat
docker-compose-up.bat
```

- Now exchange, PostgreSQL and PgAdmin database are running on docker container.
- You can access the Swagger documentation from [here](http://localhost:8081/swagger-ui.html).
- You can access the PgAdmin from [here](http://localhost:81/).

## Access to Database From Browser

- You case use PgAdmin for PostgreSQL on browser from [here](http://localhost:81/).
- You can login with username: postgres@sgv.com & password: postgres
- Create server from left menu.
- Fill the form data (name = exchange & host = postgres & username = postgres & password = postgres)
- Then save server.
- You can access the trade_history table from Servers/exchange/Databases/postgres/Schemas/public/Tables.

## Stop Project

- Go to exchange project root folder and run the following commands from terminal according to your OS:

Linux or Mac:
```bash
cd scripts
bash docker-compose-down.sh
```

Windows:
```bash
cd scripts
docker-compose-down.bat
```

## Unit Testing

- Go to exchange project root folder and run the following commands from terminal according to your OS:

Linux or Mac:
```bash
cd scripts
bash run-unit-tests.sh
```

Windows:
```bash
cd scripts
run-unit-tests.bat
```

## Integration Testing

- Go to exchange project root folder and run the following commands from terminal according to your OS:

Linux or Mac:
```bash
cd scripts
bash run-integration-tests.sh
```

Windows:
```bash
cd scripts
run-integration-tests.bat
```