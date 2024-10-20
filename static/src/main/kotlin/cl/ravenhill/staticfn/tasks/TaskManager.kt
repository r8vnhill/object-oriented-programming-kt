package cl.ravenhill.staticfn.tasks

object TaskManager {
    private val _tasks = mutableListOf<Task<*>>()

    val tasks: List<Task<*>>
        get() = _tasks.toList()

    operator fun plusAssign(task: Task<*>) {
        _tasks += task
    }

    fun clear() {
        _tasks.clear()
    }
}
