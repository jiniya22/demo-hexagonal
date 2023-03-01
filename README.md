# demo-hexagonal

### Hexagonal Architecture 구조로 만든 코프링 웹 애플리케이션<br>

<p>
    <img src="https://img.shields.io/static/v1?label=OpenJDK&message=17.0.2&color=007396&logo=openjdk" alt="OpenJDK">
    <img src="https://img.shields.io/static/v1?label=Kotlin&message=1.6.21&color=7F52FF&logo=kotlin&logoColor=fff" alt="Kotlin">
    <img src="https://img.shields.io/static/v1?label=Spring%20Boot&message=2.7.3&color=6DB33F&logo=springboot&logoColor=fff" alt="Spring Boot">
    <img src="https://img.shields.io/static/v1?label=Gradle&message=7.5.1&color=02303A&logo=Gradle&logoColor=fff" alt="Gradle">
    <img src="https://img.shields.io/static/v1?label=MariaDB&message=10.8.3&color=003545&logo=MariaDB" alt="MariaDB">
    <img src="https://img.shields.io/static/v1?label=MongoDB&message=6.0.4&color=47A248&logo=MongoDB&logoColor=fff">
    <img src="https://img.shields.io/static/v1?label=Swagger&message=3.0.3&color=85EA2D&logo=swagger&logoColor=fff" alt="Swagger 3">
</p>

1. demo-app (JDK 17 + Kotlin + Spring Boot 2 + Spring MVC + Spring Data JPA)
   1. [프로젝트 구성](#a01-1)
   2. [Tech Stacks](#a01-2)
   3. [demo-app](#a01-3)
   4. [demo-all-in-one-app](#a01-4)
2. demo-reactive (JDK 17 + Spring Boot 2 + Spring WebFlux + Spring Data MongoDB Reactive)
   1. [프로젝트 구성](#a02-1)
   2. [Tech Stacks](#a02-2)
   3. [demo-reactive-app](#a02-3)



***

## <div id="a01-1">1. demo-app</div>

### 1.1. 프로젝트 구성

demo-app 프로젝트는 멀티 모듈로 구성되어있습니다.

<img width="344" alt="architecture-1" src="https://user-images.githubusercontent.com/31076826/204638756-a9a8b9b8-d0e5-4a27-bf14-4c8f12e93448.png">

- core
  - 헥사고날 아키텍처의 application core 영역에 해당
  - 프로젝트의 핵심적인 비즈니스 로직이 들어있습니다
  - domain, port를 포함하고 있으며, 모든 클래스는 public 접근제한자로 설정되어 있습니다.
- infrastructure
  - 헥사고날 아키텍처의 `adapter - out` 영역에 해당
  - datasource에 관련된 모듈이 들어갑니다.
  - persistence adapter, JpaRepository, ORM Entity 가 포함되어있습니다.
- server
  - 헥사고날 아키텍처의 `adapter - in` 영역에 해당
  - controller를 포함하고 있으며, 모든 클래스는 internal 접근제한자로 설정되어 있습니다.
- util
  - core, server, infrastructure 모듈에서 공통적으로 사용할 유틸이 들어있습니다.

<br>

### <div id="a01-2">1.2. Tech Stacks</div>

- JDK 17
- Kotlin 1.6.21
- Build Tools
  - Gradle
  - Kotlin DSL
- Spring MVC
  - Tomcat
- Spring Boot 2
- Spring Data JPA
- MariaDB 10.8.3
- OpenAPI Specification
  - Swagger v3
    - springdoc-openapi ui 1.6.13

<br>

### <div id="a01-3">1.3. demo-app</div>

demo 웹 애플리케이션의 실행 진입점은 `server - demo-app` 모듈의 DemoAppApplication 입니다.

<img width="779" alt="DemoAppApplication" src="https://user-images.githubusercontent.com/31076826/204640445-cfcfb9db-a35b-492c-b6d2-4cf7c05030fb.png">
<br><br>

demo-app은 아래와 같이 `:util:common-util`, `:core:demo-core`, `:infrastructure:datastore-mariadb` 모듈을 포함합니다.

<img width="724" alt="build.gradle.kts" src="https://user-images.githubusercontent.com/31076826/204640772-f1846649-a21d-459a-9883-3dae61b44536.png">

<br>

### <div id="a01-4">1.4. demo-all-in-one-app</div>

demo-app을 하나의 모듈로 만든 웹 애플리케이션

adapter + core + domain 을 하나의 프로젝트 내에 구성했습니다.

<img width="382" alt="스크린샷 2022-12-02 오후 2 08 10" src="https://user-images.githubusercontent.com/31076826/205219195-fd9fef03-5a0d-4673-8020-8c7f353c7a05.png">

***

## <div id="a02-1">2. demo-reactive-app</div>

### 2.1. 프로젝트 구성

demo-reactive-app 프로젝트도는 멀티 모듈로 구성되어있습니다.

<img width="277" alt="2-1" src="https://user-images.githubusercontent.com/31076826/222085102-abbe7a55-f66e-430e-a1ed-3658b72d2600.png">

- core
  - 헥사고날 아키텍처의 application core 영역에 해당
  - 프로젝트의 핵심적인 비즈니스 로직이 들어있습니다
  - domain, port를 포함하고 있으며, 모든 클래스는 public 접근제한자로 설정되어 있습니다.
- infrastructure
  - 헥사고날 아키텍처의 `adapter - out` 영역에 해당
  - datasource에 관련된 모듈이 들어갑니다.
  - persistence adapter, JpaRepository, ORM Entity 가 포함되어있습니다.
- server
  - 헥사고날 아키텍처의 `adapter - in` 영역에 해당
  - controller를 포함하고 있으며, 모든 클래스는 internal 접근제한자로 설정되어 있습니다.
- util
  - core, server, infrastructure 모듈에서 공통적으로 사용할 유틸이 들어있습니다.

<br>

### <div id="a02-2">2.2. Tech Stacks</div>

- JDK 17
- Kotlin 1.6.21
- Build Tools
  - Gradle
  - Kotlin DSL
- Spring WebFlux
  - Netty
  - Coroutines
- Spring Boot 2
- Spring Data MongoDB Reactive
- MongoDB 6.0.4
- OpenAPI Specification
  - Swagger v3
    - springdoc-openapi-kotlin 1.6.14
    - springdoc-openapi-webflux-ui 1.6.14

<br>

### <div id="a02-3">2.3. demo-reactive-app</div>

demo 웹 애플리케이션의 실행 진입점은 `server - demo-reactive-app` 모듈의 DemoReactiveAppApplication 입니다.

demo-reactive-app은 아래와 같이 `:util:common-util`, `:core:demo-reactivecore`, `:infrastructure:datastore-mongodb-reactive` 모듈을 포함합니다.

<img width="687" alt="demo-reactive-app" src="https://user-images.githubusercontent.com/31076826/222084603-a63918ae-0105-45d4-b4da-0f1b0dd42600.png">
