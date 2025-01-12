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
    val calcDisplay = JPanel()
    calcDisplay.background = Color.CYAN
    calcDisplay.preferredSize = Dimension(mainJframe.width/2, mainJframe.height/4)
    calcDisplay.border = BorderFactory.createLineBorder(Color.BLACK,3,false)
    //Calculator Display Label
    val calcLabel = JLabel("450,321.06")//Test number to gauge size
    calcLabel.setFont(Font("Verdana", Font.PLAIN, 65))
    calcDisplay.add(calcLabel)
    //FlowLayout test
    val flowLayout = FlowLayout(FlowLayout.RIGHT)
    calcDisplay.layout = flowLayout
    mainJframe.add(calcDisplay, BorderLayout.NORTH)

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