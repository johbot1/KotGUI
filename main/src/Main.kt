//Main.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import javax.swing.*


fun main() {
    //mainJframe setup
    val mainJframe = JFrame("Calculator")
    mainJframe.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    mainJframe.size = Dimension(500, 500)
    mainJframe.setLocationRelativeTo(null)

    val borderThickness = 2

    //Calculator Display Panel
    val calcDisplay = JPanel()
    val displayWidth = 250
    val displayHeight = 125
    calcDisplay.name = "calcDisplay"
    calcDisplay.background = Color.CYAN
    calcDisplay.preferredSize = Dimension(displayWidth, displayHeight)
    calcDisplay.border = BorderFactory.createLineBorder(Color.DARK_GRAY,borderThickness,false)
    mainJframe.add(calcDisplay, BorderLayout.NORTH)

    //Calculator Display Label
    val calcLabel = JLabel("450,321.06")//Test number to gauge size
    calcLabel.setFont(Font("Verdana", Font.PLAIN, 65))
    calcDisplay.add(calcLabel, "display")



    //Button Panel
    //Using the PanelConstructor, create a buttons panel
    val buttonPanel = JPanel()
    buttonPanel.background = Color.GREEN
    buttonPanel.border = BorderFactory.createLineBorder(Color.DARK_GRAY,borderThickness,false)
    mainJframe.add(buttonPanel)

    //Operations Panel
    //Using the PanelConstructor, create an operations panel
    val operationsPanel = JPanel()
    operationsPanel.border = BorderFactory.createLoweredBevelBorder()
    operationsPanel.background = Color.LIGHT_GRAY
    operationsPanel.preferredSize = Dimension(250,250)
    operationsPanel.border = BorderFactory.createLineBorder(Color.DARK_GRAY,borderThickness,false)
    mainJframe.add(operationsPanel, BorderLayout.EAST)


    //MainJFrame attributes
    mainJframe.isVisible = true
    mainJframe.isResizable = false
}