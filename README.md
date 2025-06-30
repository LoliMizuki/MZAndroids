Need to do something stupid first ... 🤮

- add to `settings.gradle`
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") } // ⭐️
    }
}
```

- add to `build.gradle(.kts)`, then convert to .kts new format 🤮
```
dependencies {
    implementation("com.github.LoliMizuki:MZAndroids:Tag") // ⭐️ TAG!!!
}
```
