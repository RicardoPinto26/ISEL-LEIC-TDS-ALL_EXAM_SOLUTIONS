data class Student(val number: Int, val classId: String, val group: Int) {
    override fun toString() = "$number $classId $group"
}

fun List<String>.toStudent(): Student {
    require(this.size == 3)
    return Student(this[0].toInt(), this[1], this[2].toInt())
}