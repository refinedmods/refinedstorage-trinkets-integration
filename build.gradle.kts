plugins {
    id("refinedarchitect.root")
    id("refinedarchitect.fabric")
}

repositories {
    maven {
        url = uri("https://maven.pkg.github.com/refinedmods/refinedstorage2")
        credentials {
            username = "anything"
            password = "\u0067hp_oGjcDFCn8jeTzIj4Ke9pLoEVtpnZMP4VQgaX"
        }
    }
    maven {
        name = "ModMenu"
        url = uri("https://maven.terraformersmc.com/")
    }
    maven {
        name = "Cloth Config"
        url = uri("https://maven.shedaniel.me/")
    }
    maven {
        name = "Trinkets"
        url = uri("https://maven.ladysnake.org/releases")
    }
}

refinedarchitect {
    modId = "refinedstorage_trinkets_integration"
    fabric()
    sonarQube("refinedmods_refinedstorage-trinkets-integration", "refinedmods")
    publishing {
        maven = true
    }
}

group = "com.refinedmods.refinedstorage"

base {
    archivesName.set("refinedstorage-trinkets-integration")
}

val refinedstorageVersion: String by project
val trinketsVersion: String by project
val cardinalComponentsVersion: String by project

dependencies {
    modApi("com.refinedmods.refinedstorage:refinedstorage-fabric:${refinedstorageVersion}")
    modApi("dev.emi:trinkets:${trinketsVersion}")
    modApi("dev.onyxstudios.cardinal-components-api:cardinal-components-base:${cardinalComponentsVersion}")
    modApi("dev.onyxstudios.cardinal-components-api:cardinal-components-entity:${cardinalComponentsVersion}")
}

