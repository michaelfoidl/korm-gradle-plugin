package at.michaelfoidl.korm.plugin.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class MigrateTask : DefaultTask() {
    @TaskAction
    fun migrate() {
        println("migrate")
    }
}