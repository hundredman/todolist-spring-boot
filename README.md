# TodoList 프로젝트

이 프로젝트는 Spring Boot와 Thymeleaf를 사용하여 간단한 할 일 관리 애플리케이션을 구현한 것입니다. 사용자는 할 일을 추가, 수정, 삭제하고 완료 상태를 토글할 수 있습니다.

---

## 📌 프로젝트 개요

- **프로젝트 이름**: TodoList
- **기술 스택**:
    - Spring Boot 3.1.5
    - Thymeleaf (템플릿 엔진)
    - MariaDB (데이터베이스)
    - Maven (빌드 도구)
- **주요 기능**:
    - 할 일 추가
    - 할 일 수정
    - 할 일 삭제
    - 할 일 완료 상태 토글
    - 할 일 목록 조회

---

## 🛠️ 설치 및 실행 방법

### 1. **필수 조건**
- JDK 17 이상
- MariaDB (또는 다른 관계형 데이터베이스)
- Maven 3.x

### 2. **데이터베이스 설정**
1. MariaDB를 설치하고 실행합니다.
2. 데이터베이스와 테이블을 생성합니다.
   ```sql
   CREATE DATABASE todo_db;
   USE todo_db;

   CREATE TABLE todo (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       completed BOOLEAN DEFAULT FALSE
   );
   ```

3. `application.properties` 파일에 데이터베이스 연결 정보를 입력합니다.
   ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3306/todo_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

### 3. **프로젝트 빌드 및 실행**
1. 프로젝트를 클론합니다.
   ```bash
   git clone https://github.com/your-repository/todolist.git
   cd todolist
   ```

2. Maven을 사용하여 프로젝트를 빌드합니다.
   ```bash
   ./mvnw clean package
   ```

3. 빌드가 완료되면 애플리케이션을 실행합니다.
   ```bash
   java -jar target/todolist-0.0.1-SNAPSHOT.jar
   ```

4. 브라우저에서 `http://localhost:8080/todos`로 접속하여 애플리케이션을 사용합니다.

---

## 🚀 주요 기능 설명

### 1. **할 일 추가**
- 할 일의 제목을 입력하여 새로운 할 일을 추가할 수 있습니다.

### 2. **할 일 수정**
- 기존 할 일의 제목과 완료 상태를 수정할 수 있습니다.

### 3. **할 일 삭제**
- 할 일을 목록에서 삭제할 수 있습니다.

### 4. **할 일 완료 상태 토글**
- 할 일의 완료 상태를 토글하여 취소선을 표시하거나 숨길 수 있습니다.

### 5. **할 일 목록 조회**
- 모든 할 일을 목록 형태로 조회할 수 있습니다.

---

## 📂 프로젝트 구조

```
todolist/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/todolist/
│   │   │       ├── controller/
│   │   │       │   └── TodoController.java
│   │   │       ├── model/
│   │   │       │   └── Todo.java
│   │   │       ├── repository/
│   │   │       │   └── TodoRepository.java
│   │   │       ├── service/
│   │   │       │   └── TodoService.java
│   │   │       └── TodolistApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       │   ├── todo-list.html
│   │       │   └── edit-todo.html
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/todolist/
├── pom.xml
└── README.md
```

---

## 🛠️ 기술 스택 상세

- **Spring Boot**: 백엔드 애플리케이션 프레임워크
- **Thymeleaf**: 서버 사이드 템플릿 엔진
- **MariaDB**: 관계형 데이터베이스
- **Maven**: 프로젝트 빌드 및 의존성 관리 도구
- **Lombok**: 보일러플레이트 코드 자동 생성

---

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/E9hx3NDR)