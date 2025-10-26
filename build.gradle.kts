plugins {
    id("com.refinedmods.refinedarchitect.root")
    id("com.refinedmods.refinedarchitect.fabric")
}

repositories {
    maven {
        name = "Refined Storage"
        url = uri("https://maven.creeperhost.net")
        content {
            includeGroup("com.refinedmods.refinedstorage")
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
        curseForge = "1230748"
        curseForgeRequiredDependencies = listOf("fabric-api", "refined-storage", "trinkets")
        modrinth = "EkNHO3Uw"
        modrinthRequiredDependencies = listOf("fabric-api", "refined-storage", "trinkets")
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

