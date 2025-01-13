//Main.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import javax.swing.*


fun main() {
    val mainJframe = JFrame("Calculator")
    mainJframe.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    mainJframe.size = Dimension(500, 500)
    mainJframe.setLocationRelativeTo(null)

    //Calculator Display Panel
    val calcDisplay = PanelConstructor("display")
    mainJframe.add(calcDisplay.panel, BorderLayout.NORTH)



    //Calculator Display Label
    val calcLabel = JLabel("450,321.06")//Test number to gauge size
    calcLabel.setFont(Font("Verdana", Font.PLAIN, 65))
    calcDisplay.add(calcLabel, "display")
    //FlowLayout test
    val flowLayout = FlowLayout(FlowLayout.RIGHT)


    //Button Panel
    //Using the PanelConstructor, create a buttons panel
    val buttonPanel = PanelConstructor("buttons")
    mainJframe.add(buttonPanel.panel)

    //Operations Panel
    //Using the PanelConstructor, create an operations panel
    val operationsPanel = PanelConstructor("operands")
    mainJframe.add(operationsPanel.panel, BorderLayout.EAST)


    //MainJFrame attributes
    mainJframe.isVisible = true
    mainJframe.isResizable = false
}