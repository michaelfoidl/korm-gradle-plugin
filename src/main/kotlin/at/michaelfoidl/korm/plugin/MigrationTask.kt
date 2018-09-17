package at.michaelfoidl.korm.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MigrationTask : DefaultTask() {
    @TaskAction
    fun doIt() {
        println("HELLO!")
    }
}