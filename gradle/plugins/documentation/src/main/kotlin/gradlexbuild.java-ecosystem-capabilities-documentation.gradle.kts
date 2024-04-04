import gradlexbuild.javaecosystem.conflict.documentation.ReadmeUpdate
import gradlexbuild.javaecosystem.conflict.documentation.SamplesCompletenessCheck

plugins {
    id("java")
    id("gradlexbuild.java-ecosystem-capabilities-lifecycle")
    id("gradlexbuild.asciidoctor-conventions")
    id("gradlexbuild.exemplar-conventions")
}

val updateReadme = tasks.register<ReadmeUpdate>("updateReadme") {
    pluginClasses.from(tasks.jar)
    readme = layout.projectDirectory.file("README.MD")
}

val checkSamplesForCompleteness = tasks.register<SamplesCompletenessCheck>("checkSamplesForCompleteness") {
    pluginClasses.from(tasks.jar)
    samplesBuildFiles.from(layout.projectDirectory.file("samples/sample-all/build.gradle.kts"))
    samplesBuildFiles.from(layout.projectDirectory.file("samples/sample-all-deactivated/build.gradle.kts"))
}

tasks.quickCheck {
    dependsOn(updateReadme)
    dependsOn(checkSamplesForCompleteness)
}
