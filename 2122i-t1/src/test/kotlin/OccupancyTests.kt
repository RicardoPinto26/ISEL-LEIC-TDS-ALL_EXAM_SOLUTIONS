import kotlin.test.*

class OccupancyTests {
    @Test
    fun `creation success`() {
        val sut = Occupancy(0, 20)
        assertEquals(0, sut.current)
        assertEquals(20, sut.capacity)
        assertTrue(sut.isEmpty)
        assertFalse(sut.isFull)
    }

    @Test
    fun `invalid creation`() {
        assertFailsWith<IllegalArgumentException> {
            Occupancy(10, 5)
        }
    }

    @Test
    fun `valid increment`() {
        val sut = Occupancy(2, 20).increment()
        assertEquals(3, sut.current)
    }

    @Test
    fun `invalid increment`() {
        assertFailsWith<IllegalStateException> {
            Occupancy(20, 20).increment()
        }
    }
}
