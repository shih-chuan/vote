# 投票系統

Live Demo: <https://vote.cchuan.one>

## Spring 建置方法

### 1. MySql 建立 Database

執行 `DB/ddl.sql` 與 `DB/dml.sql`

### 2. 建立 `applications.properties`

建立 `server/src/main/resources/application.properties` 檔案

```env
spring.application.name=server
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/vote?serverTimezone=Asia/Taipei&characterEncoding=utf-8
spring.datasource.username=$DB_USER
spring.datasource.password=$DB_PASSWORD
server.port=8080
```

### 3. 建立 jar 檔

```bash
mvn clean package
```

### 4. 執行 Spring

```bash
java -jar target/server-0.0.1-SNAPSHOT.jar
```

## Vue 建置方法

### 1. 建立 `.env`

建立 `client/.env` 檔案

```env
VITE_API_ADDRESS="http://localhost:8080/api"
```

### 2. build

```bash
npm install
npm run build
```

### 3. serve

將`client/dist`底下生成之靜態檔案交由網頁伺服器(Apache, Nginx)發送
