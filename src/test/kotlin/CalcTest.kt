
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.Mockito

internal class CalcTest {
    @Test
    fun `Addition 15 and 32 should be equal to 47`() {
        assertEquals(47L, Calc.ADD.operation(15L, 32L))
    }

    @Test
    fun `Addition -48 and -70 should be equal to -118`() {
        assertEquals(-118L, Calc.ADD.operation(-48L, -70L))
    }

    @Test
    fun `Addition 73 and -211 should be equal to -138`() {
        assertEquals(-138L, Calc.ADD.operation(73L, -211L))
    }

    @Test
    fun `Subtraction 68 from 347 should be equal to 279`() {
        assertEquals(279, Calc.SUB.operation(347L, 68L))
    }

    @Test
    fun `Subtraction -42 from -95 should be equal to -53`() {
        assertEquals(-53L, Calc.SUB.operation(-95L, -42L))
    }

    @Test
    fun `Subtraction 27 from -63 should be equal to 90`() {
        assertEquals(90L, Calc.SUB.operation(27L, -63L))
    }

    @ParameterizedTest
    @CsvSource(
        "15, 23, 345",
        "24, -9, -216",
        "-30, -4, 120")
    fun multiplication(x: Long, y: Long, result: Long) {
        assertEquals(result, Calc.MULT.operation(x, y))
    }

    @Test
    fun `Division 45 by 3 should be equal to 15`() {
        assertEquals(15, Calc.DIV.operation(45L, 3L))
    }

    @Test
    fun `Division -84 by -3 should be equal to 28`() {
        assertEquals(28L, Calc.DIV.operation(-84L, -3L))
    }

    @Test
    fun `Division 36 by -6 should be equal to -6`() {
        assertEquals(-6L, Calc.DIV.operation(36L, -6L))
    }

    @Test
    fun `Division by 0 should be exception`() {
        val exception: Exception= assertThrows (IllegalArgumentException::class.java) {
            Calc.DIV.operation(1L, 0L)
        }
        assertEquals("Can't divide by zero", exception.message)
    }

    @Test
    fun `Adding mockito numbers should be 357`() {
        val mockRemoteData = Mockito.mock(GetRemoteData::class.java)
        Mockito.`when`(mockRemoteData.getData()).thenReturn(Pair(145L, 212L))
        val data = mockRemoteData.getData()
        assertEquals(357, Calc.ADD.operation(data.first, data.second))
    }
}