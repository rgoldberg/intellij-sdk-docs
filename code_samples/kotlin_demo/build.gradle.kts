// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

plugins {
  id("java")
  id("org.jetbrains.intellij") version "1.13.1"
  id("org.jetbrains.kotlin.jvm") version "1.8.10"
}

group = "org.intellij.sdk"
version = "2.0.0"

repositories {
  mavenCentral()
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
  version.set("2022.1.4")
}

tasks {
  buildSearchableOptions {
    enabled = false
  }

  patchPluginXml {
    version.set("${project.version}")
    sinceBuild.set("221")
    untilBuild.set("223.*")
  }

  compileKotlin {
    kotlinOptions.jvmTarget = "11"
  }

  compileTestKotlin {
    kotlinOptions.jvmTarget = "11"
  }
}
