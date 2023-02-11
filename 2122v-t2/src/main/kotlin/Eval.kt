class Eval private constructor(val quotation: Int) {
    companion object {
        const val DELTA = 5
        const val MIN = 0
        const val MAX = 100
        val default = Eval(MIN)
        fun of(q: Int) = if (q in MIN..MAX && q % DELTA == 0) Eval(q) else null
    }

    override fun equals(other: Any?): Boolean {
        return other is Eval && other.quotation == this.quotation
    }

    override fun hashCode() = this.quotation

    fun inc(): Eval = if (quotation == MAX) this else Eval(quotation + DELTA)
}

fun Eval.dec(): Eval = if (quotation == Eval.MIN) this else Eval.of(quotation - Eval.DELTA) ?: this

fun Grade.partialValue(eval: Eval): Double {
    val multiplier = eval.quotation.toDouble() / 100
    return this.value * multiplier
}
