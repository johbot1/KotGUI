//Main.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import javax.swing.*
import javax.swing.border.Border

fun main() {
    val mainJframe = JFrame("Calculator")
    mainJframe.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    mainJframe.size = Dimension(500, 500)
    mainJframe.setLocationRelativeTo(null)

    //Calculator Display Panel
    val calcDisplay = JPanel()
    calcDisplay.background = Color.CYAN
    calcDisplay.preferredSize = Dimension(200, mainJframe.height/4)
    calcDisplay.border = BorderFactory.createLineBorder(Color.BLACK,3,false)



    //Calculator Display Label
    //TODO: Align this box to the right to display values
    val calcLabel = JLabel("Hello, World!")
    calcLabel.setFont(Font("Verdana", Font.BOLD, 30))
    calcDisplay.add(calcLabel)

    //Button Section
    val buttonPanel = JPanel()
    buttonPanel.border = BorderFactory.createLoweredBevelBorder()
    mainJframe.add(buttonPanel)




    mainJframe.add(calcDisplay, BorderLayout.NORTH)

    mainJframe.isVisible = true
    mainJframe.isResizable = false
}