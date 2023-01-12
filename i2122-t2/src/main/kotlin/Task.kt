data class Task(val name: String) {
    init {
        require(name.canBeTask())
    }
}

fun String.canBeTask(): Boolean = this.length in 4..40 && this.first() != ' ' && this.last() != ' '