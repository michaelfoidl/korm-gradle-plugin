package at.michaelfoidl.korm.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MigrationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.create("addMigration", MigrationTask::class.java)
    }
}