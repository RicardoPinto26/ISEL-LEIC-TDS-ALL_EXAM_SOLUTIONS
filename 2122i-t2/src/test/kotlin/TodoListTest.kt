import kotlin.test.*

class TodoListTest {
    @Test
    fun `adding a task to TodoList correctly adds it to tasks`() {
        val tl = TodoList()
        val task = Task("Task")
        val newTL = tl.add(task)

        assert(newTL.tasks.size == 1)
        assertEquals(task, newTL.tasks.first())
    }

    @Test
    fun `removing a non existent task throws IllegalArgumentException`() {
        val tl = TodoList()
        val task = Task("Task")

        val ex = assertFailsWith<IllegalArgumentException> {
            tl.remove(task)
        }

        assertEquals("Task isn't on the list", ex.message)
    }
}