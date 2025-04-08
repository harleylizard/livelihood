import soul.software.snail.dependency.snail

plugins {
    id("soul.software.snail") version "3.1-SNAPSHOT"
}

group = "com.harleylizard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.nucleoid.xyz")
    maven("https://api.modrinth.com/maven")
}

dependencies {
    snail {
        implementation("eu.pb4:polymer-core:0.11.8+1.21.4")
        implementation("eu.pb4:polymer-blocks:0.11.8+1.21.4")
        implementation("eu.pb4:polymer-resource-pack:0.11.8+1.21.4")
        implementation("maven.modrinth:lithostitched:1.4.5-fabric-1.21.4")
    }

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

snail {
    fabric("1.21.4") {
        name = "Livelihood"
        id = "livelihood"
        version = "1.0-SNAPSHOT"
        description = "."
        entryPoints {
            main = listOf("com.harleylizard.livelihood.common.livelihood")
        }
    }
}