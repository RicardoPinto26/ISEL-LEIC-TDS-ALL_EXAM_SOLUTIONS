class TodoList constructor(val tasks: List<Task> = emptyList())

fun TodoList.add(task: Task): TodoList {
    require(!tasks.contains(task)) {"Task is already in the List"}
    return TodoList(tasks + task)
}

fun TodoList.remove(task: Task): TodoList {
    require(tasks.contains(task)) {"Task isn't on the list"}
    return TodoList(tasks - task)
}