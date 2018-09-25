package at.michaelfoidl.korm.plugin

import at.michaelfoidl.korm.plugin.tasks.AddMigrationTask
import at.michaelfoidl.korm.plugin.tasks.MigrateTask
import at.michaelfoidl.korm.plugin.tasks.SetupTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention


class MigrationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val setupTask = createAndAddSetupTask(target)
        createAndAddAddMigrationTask(target, setupTask)
        createAndAddMigrateTask(target, setupTask)
        val sourceSet = target.convention.getPlugin(JavaPluginConvention::class.java).sourceSets.create("korm")
        sourceSet.java.srcDir(target.buildDir.absolutePath + "/korm/src")
        val compileTask = target.tasks.find { it.name == "compileKormKotlin" }!!
        compileTask.dependsOn("setupKorm")
    }

    private fun createAndAddAddMigrationTask(target: Project, setupTask: SetupTask): AddMigrationTask {
        val task = target.tasks.create("addMigration", AddMigrationTask::class.java)
        task.dependsOn(setupTask)
        return task
    }

    private fun createAndAddMigrateTask(target: Project, setupTask: SetupTask): MigrateTask {
        val task = target.tasks.create("migrate", MigrateTask::class.java)
        task.dependsOn(setupTask)
        return task
    }

    private fun createAndAddSetupTask(target: Project): SetupTask {
        val task = target.tasks.create("setupKorm", SetupTask::class.java)
        task.dependsOn("kaptKotlin")
        return task
    }
}