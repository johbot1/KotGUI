/**
 * Main.kt
 * @author John Botonakis
 * @desc This is the main function that will run the entire calculator
 * In here, the main JFrame is created. After the others are created in
 * Constants.kt, they are stylized and applied to the mainJFrame,
 * along with their respective buttons
 */

import java.awt.*
import javax.swing.BorderFactory
import javax.swing.JFrame
import javax.swing.SwingConstants
import java.text.NumberFormat

/**
 * Main
 *
 * This is the main function that will run the entire calculator
 * In here, the main JFrame is created. After the others are created in
 * Constants.kt, they are stylized and applied to the mainJFrame,
 * along with their respective buttons
 *
 * @author John Botonakis
 */
fun main() {
    //mainJframe setup
    val mainJframe = JFrame("Calculator")
    mainJframe.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    mainJframe.size = Dimension(500, 500)
    mainJframe.setLocationRelativeTo(null)

    //Button Creation
    val (numberButtons, operationalButtons) = createButtons()

    //Calculator "Screen" Panel
    calcScreenDisplay.name = "calcDisplay"
    calcScreenDisplay.background = Color.CYAN
    calcScreenDisplay.preferredSize = Dimension(screenWidth, screenHeight)
    calcScreenDisplay.border = BorderFactory.createLineBorder(Color.DARK_GRAY, borderThickness, false)
    mainJframe.add(calcScreenDisplay, BorderLayout.NORTH)

    //Calculator Display Label
    calcLabel.horizontalAlignment = SwingConstants.RIGHT
    calcLabel.setFont(Font("Verdana", Font.PLAIN, calcDisplayFont))
    calcLabel.text = displayNum
    calcScreenDisplay.add(calcLabel, "display")


    //Button Panel
    //Using the PanelConstructor, create a buttons panel
    buttonPanel.border = BorderFactory.createRaisedBevelBorder()
    buttonPanel.background = Color.GREEN
    buttonPanel.setLayout(GridLayout(3, 2))
    buttonPanel.preferredSize = Dimension(buttonPanelWidth, buttonPanelHeight)
    mainJframe.add(buttonPanel, BorderLayout.WEST)
    //Buttons
    addNumButtons(numberButtons, buttonPanel)


    //Operations Panel
    //Using the PanelConstructor, create an operations panel
    operationsPanel.border = BorderFactory.createLoweredBevelBorder()
    operationsPanel.background = Color.LIGHT_GRAY
    operationsPanel.preferredSize = Dimension(operationsPanelDimensions, operationsPanelDimensions)
    operationsPanel.setLayout(GridLayout(7, 1))
    mainJframe.add(operationsPanel, BorderLayout.EAST)
    //Buttons
    addOpButtons(operationalButtons, operationsPanel)

    //MainJFrame attributes
    mainJframe.isVisible = true
    mainJframe.isResizable = false
}
