plugins {
    java
    application
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    //implementation("com.google.guava:guava:26.0-jre") 
    //testImplementation("junit:junit:4.12") 
    compile("org.protelis:protelis:12.1.0")
    //compile("org.jgrapht:jgrapht:1.1.0")
    //compile("org.jgrapht:jgrapht-io:1.1.0")
    //compile("org.jgrapht:jgrapht-core:1.1.0")
    compile("org.jgrapht:jgrapht-core:1.3.1")
    runtime(files("src/main/resources"))
}


application {
    mainClassName = "demo.HelloProtelis"
}

defaultTasks("run")
