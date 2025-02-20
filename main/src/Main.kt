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

//TODO: Persist previous answer when doing operations
//TODO: Visually differentiate the operations from the +/-
//TODO: calcScreen -> CalcResult Screen
//TODO: Better naming conventions

//TODO: Use ENUMS for operations

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
    calcScreenDisplay.background = Color.WHITE
    calcScreenDisplay.preferredSize = Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)
    calcScreenDisplay.border = BorderFactory.createLineBorder(Color.DARK_GRAY, BORDER_THICKNESS, false)
    mainJframe.add(calcScreenDisplay, BorderLayout.NORTH)

    //Calculator Display Label
    calcLabel.horizontalAlignment = SwingConstants.RIGHT
    calcLabel.setFont(Font("Verdana", Font.PLAIN, CALC_DISPLAY_HEIGHT))
    calcLabel.text = displayNum
    calcScreenDisplay.add(calcLabel, "display")


    //Button Panel
    //Using the PanelConstructor, create a buttons panel
    buttonPanel.border = BorderFactory.createRaisedBevelBorder()
    buttonPanel.background = Color.GRAY
    buttonPanel.setLayout(GridLayout(3, 2))
    buttonPanel.preferredSize = Dimension(BUTTON_PANEL_WIDTH, BUTTON_PANEL_HEIGHT)
    mainJframe.add(buttonPanel, BorderLayout.WEST)
    //Buttons
    addNumButtons(numberButtons, buttonPanel)


    //Operations Panel
    //Using the PanelConstructor, create an operations panel
    operationsPanel.border = BorderFactory.createLoweredBevelBorder()
    operationsPanel.background = Color.LIGHT_GRAY
    operationsPanel.preferredSize = Dimension(OPERATION_PANEL_DIMENSIONS, OPERATION_PANEL_DIMENSIONS)
    operationsPanel.setLayout(GridLayout(7, 1))
    mainJframe.add(operationsPanel, BorderLayout.EAST)
    //Buttons
    addOpButtons(operationalButtons, operationsPanel)

    //MainJFrame attributes
    mainJframe.isVisible = true
    mainJframe.isResizable = false
}
