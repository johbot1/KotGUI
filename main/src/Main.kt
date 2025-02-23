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

//TODO: Visually differentiate the operations from the +/-
//TODO: Better naming conventions

fun main() {
    //mainJframe setup
    val foundationJFrame = JFrame("Calculator")
    foundationJFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    foundationJFrame.size = Dimension(500, 500)
    foundationJFrame.setLocationRelativeTo(null)

    //Button Creation
    val (numberButtons, operationalButtons) = createButtons()

    //Calculator "Screen" Panel
    calculationResultScreen.name = "calculationResultDisplay"
    calculationResultScreen.background = Color.WHITE
    calculationResultScreen.preferredSize = Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)
    calculationResultScreen.border = BorderFactory.createLineBorder(Color.DARK_GRAY, BORDER_THICKNESS, false)
    foundationJFrame.add(calculationResultScreen, BorderLayout.NORTH)

    //Calculator Display Label
    calculationResultLabel.horizontalAlignment = SwingConstants.RIGHT
    calculationResultLabel.setFont(Font("Verdana", Font.PLAIN, CALC_DISPLAY_HEIGHT))
    calculationResultLabel.text = displayNum
    calculationResultScreen.add(calculationResultLabel, "display")


    //Button Panel
    //Using the PanelConstructor, create a buttons panel
    buttonPanel.border = BorderFactory.createRaisedBevelBorder()
    buttonPanel.background = Color.GRAY
    buttonPanel.setLayout(GridLayout(3, 2))
    buttonPanel.preferredSize = Dimension(BUTTON_PANEL_WIDTH, BUTTON_PANEL_HEIGHT)
    foundationJFrame.add(buttonPanel, BorderLayout.WEST)
    //Buttons
    addNumberButtons(numberButtons, buttonPanel)


    //Operations Panel
    //Using the PanelConstructor, create an operations panel
    operationsPanel.border = BorderFactory.createLoweredBevelBorder()
    operationsPanel.background = Color.LIGHT_GRAY
    operationsPanel.preferredSize = Dimension(OPERATION_PANEL_DIMENSIONS, OPERATION_PANEL_DIMENSIONS)
    operationsPanel.setLayout(GridLayout(7, 1))
    foundationJFrame.add(operationsPanel, BorderLayout.EAST)
    //Buttons
    addOperationalButtons(operationalButtons, operationsPanel)

    //MainJFrame attributes
    foundationJFrame.isVisible = true
    foundationJFrame.isResizable = false
}
