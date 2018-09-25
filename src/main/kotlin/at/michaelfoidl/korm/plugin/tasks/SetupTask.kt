package at.michaelfoidl.korm.plugin.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class SetupTask : DefaultTask() {
    @TaskAction
    fun setup() {
        println("setupKorm")
    }
}