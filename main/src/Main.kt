import java.awt.BorderLayout
import java.awt.Color
import javax.swing.*
import java.awt.Dimension

fun main() {
    val main_Jframe = JFrame("Hello, World!")
    main_Jframe.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    main_Jframe.size = Dimension(500, 500)

    val label = JLabel("Hello, World!")
    label.verticalAlignment = SwingConstants.CENTER
    label.horizontalAlignment = SwingConstants.CENTER
    main_Jframe.add(label)

    //Calculator Display
    val calcDisplay = JPanel()
    calcDisplay.background = Color.CYAN
    calcDisplay.preferredSize = Dimension(450, main_Jframe.height/4)
    //This doesn't work. Why? No px border, it's stuck to both left and right sides
    //TODO: Fix the way this is rendered to give it a border
    calcDisplay.border = BorderFactory.createEmptyBorder(150, 150, 150, 150)
    main_Jframe.add(calcDisplay, BorderLayout.NORTH)




    //Initializes the frame in the center of the screen
    main_Jframe.setLocationRelativeTo(null)

    main_Jframe.isVisible = true
    main_Jframe.isResizable = false
}