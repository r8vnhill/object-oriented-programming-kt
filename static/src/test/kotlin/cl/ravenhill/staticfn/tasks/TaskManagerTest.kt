package cl.ravenhill.staticfn.tasks

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.map
import io.kotest.property.arbs.products.Product
import io.kotest.property.arbs.products.products
import io.kotest.property.checkAll

class TaskManagerTest : FreeSpec({
    "A task manager" - {
        "when adding tasks" - {
            "should be able to get all tasks" {
                checkAll(Arb.list(arbTask())) { tasks ->
                    tasks.forEach { TaskManager += it }
                    TaskManager.tasks shouldBe tasks
                }
            }
        }

        "when clearing tasks" - {
            "should have an empty task list" {
                checkAll(Arb.list(arbTask())) { tasks ->
                    tasks.forEach { TaskManager += it }
                    TaskManager.clear()
                    TaskManager.tasks shouldBe emptyList()
                }
            }
        }
    }
})

private fun arbTask(): Arb<Task<Product>> = Arb.products()
    .map { product -> Task(product) }
