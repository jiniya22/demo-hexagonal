dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.13")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")

    implementation(project(":core:demo-core"))
    implementation(project(":infrastructure:datastore-mariadb"))
}