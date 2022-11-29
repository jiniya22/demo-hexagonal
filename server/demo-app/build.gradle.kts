dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.13")

    implementation(project(":util:common-util"))
    implementation(project(":core:demo-core"))
    implementation(project(":infrastructure:datastore-mariadb"))
}