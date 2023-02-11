class Grade private constructor(val value: Int) {
    companion object {
        val scale = (0..20).map { Grade(it) }
    }
}

enum class QualitativeGrade(val range: IntRange, val description: String) {
    MB(18..20, "Muito Bom"), B(14..17, "Bom"), S(10..13, "Suficiente"),
    I(6..9, "Insuficiente"), M(0..5, "Mau")
}

fun Int.toGradeOrNull(): Grade? = Grade.scale.firstOrNull { this == it.value }

fun Grade.toQualitative() = QualitativeGrade.values().first { value in it.range }

val Int.grade get() = toGradeOrNull() ?: error("Invalid grade $this")

data class GradeConverter(val quantitative: Grade) {
    val qualitative = quantitative.toQualitative()
}
