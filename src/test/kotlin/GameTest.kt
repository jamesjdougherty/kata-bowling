import junit.framework.Assert.assertEquals
import org.junit.Test

class GameTest : Game() {

    @Test
    fun testGutterGame() {
        rollMany(20, 0)
        assertEquals(0, this.score())
    }

    @Test
    fun testAllOnes() {
        rollMany(20, 1)
        assertEquals(20, this.score())
    }

    @Test
    fun testOneSpare() {
        rollSpare()
        this.roll(3)
        rollMany(17, 0)
        assertEquals(16, this.score())
    }

    @Test
    fun testOneStrike() {
        rollStrike()
        this.roll(3)
        this.roll(4)
        rollMany(16, 0)
        assertEquals(24, this.score())
    }

    @Test
    fun testPerfectGame() {
        rollMany(12, 10)
        assertEquals(300, this.score())
    }

    private fun rollMany(n: Int, pins: Int) {
        for (i in 1..n) {
            this.roll(pins)
        }
    }

    private fun rollSpare() {
        this.roll(5)
        this.roll(5)
    }

    private fun rollStrike() {
        this.roll(10)
    }
}