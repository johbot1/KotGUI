//Main.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import java.util.concurrent.Flow
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
    calcDisplay.preferredSize = Dimension(mainJframe.width/2, mainJframe.height/4)
    calcDisplay.border = BorderFactory.createLineBorder(Color.BLACK,3,false)

    //Calculator Display Label
    val calcLabel = JLabel("450,321.06")
    calcLabel.setFont(Font("Verdana", Font.PLAIN, 65))
    calcDisplay.add(calcLabel)

    //FlowLayout test
    val flowLayout = FlowLayout(FlowLayout.RIGHT)
    calcDisplay.layout = flowLayout

    //Button Section
    val buttonPanel = JPanel()
    buttonPanel.border = BorderFactory.createLoweredBevelBorder()
    buttonPanel.background = Color.LIGHT_GRAY
    buttonPanel.border = BorderFactory.createLineBorder(Color.BLACK,3,false)




    mainJframe.add(calcDisplay, BorderLayout.NORTH)
    mainJframe.add(buttonPanel)

    mainJframe.isVisible = true
    mainJframe.isResizable = false
}