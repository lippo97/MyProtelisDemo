plugins {
    java
    application
}

repositories {
    jcenter() 
}

dependencies {
    //implementation("com.google.guava:guava:26.0-jre") 
    //testImplementation("junit:junit:4.12") 
    compile("org.protelis:protelis:12.1.0")
    runtime(files("src/main/resources"))
}

application {
    mainClassName = "demo.App" 
}

defaultTasks("run")
