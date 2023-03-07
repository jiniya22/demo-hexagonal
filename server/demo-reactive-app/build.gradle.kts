dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("org.springframework.boot:spring-boot-starter-validation")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.14")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.14")

    implementation(project(":util:common-util"))
    implementation(project(":core:demo-reactive-core"))
    implementation(project(":infrastructure:datastore-mongodb-reactive"))

//    implementation(project(":infrastructure:datastore-mariadb-reactive"))
//    implementation("io.netty:netty-resolver-dns-native-macos:4.1.86.Final:osx-aarch_64")
}