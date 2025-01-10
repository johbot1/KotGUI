import javax.swing.*
import java.awt.Dimension

fun main() {
    val frame = JFrame("Hello, World!")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.size = Dimension(500, 500)

    val label = JLabel("Hello, World!")
    label.verticalAlignment = SwingConstants.CENTER
    label.horizontalAlignment = SwingConstants.CENTER
    frame.add(label)


    //Initializes the frame in the center of the screen
    frame.setLocationRelativeTo(null)

    frame.isVisible = true
}