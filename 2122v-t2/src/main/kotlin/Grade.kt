class Grade private constructor(val value: Int) {
    companion object {
        const val MIN = 1; const val MAX = 20
        private val scale = (MIN..MAX).map { Grade(it) }
        operator fun invoke(value: Int) = scale[ value - MIN ]
    }
    override fun toString() = "$value values"
}