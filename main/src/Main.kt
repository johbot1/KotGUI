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

fun main() {
    //mainJframe setup
    val foundationJFrame = JFrame("Calculator")
    foundationJFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    foundationJFrame.size = Dimension(500, 500)
    foundationJFrame.setLocationRelativeTo(null)

    //Button Creation
    val (numberButtons, operationalButtons) = createAllButtons()

    //Calculator "Screen" Panel
    calculationResultPanel.name = "calculationResultDisplay"
    calculationResultPanel.background = Color.WHITE
    calculationResultPanel.preferredSize = Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)
    calculationResultPanel.border = BorderFactory.createLineBorder(Color.DARK_GRAY, BORDER_THICKNESS, false)
    foundationJFrame.add(calculationResultPanel, BorderLayout.NORTH)

    //Calculator Display Label
    calculationResultLabel.horizontalAlignment = SwingConstants.RIGHT
    calculationResultLabel.setFont(Font("Verdana", Font.PLAIN, CALC_DISPLAY_HEIGHT))
    calculationResultLabel.text = displayNum
    calculationResultPanel.add(calculationResultLabel, "display")


    //Button Panel
    //Using the PanelConstructor, create a buttons panel
    buttonFoundationPanel.border = BorderFactory.createRaisedBevelBorder()
    buttonFoundationPanel.background = Color.GRAY
    buttonFoundationPanel.setLayout(GridLayout(3, 2))
    buttonFoundationPanel.preferredSize = Dimension(BUTTON_PANEL_WIDTH, BUTTON_PANEL_HEIGHT)
    foundationJFrame.add(buttonFoundationPanel, BorderLayout.WEST)
    //Buttons
    addNumberButtons(numberButtons, buttonFoundationPanel)


    //Operations Panel
    //Using the PanelConstructor, create an operations panel
    operationsFoundationPanel.border = BorderFactory.createLoweredBevelBorder()
    operationsFoundationPanel.background = Color.LIGHT_GRAY
    operationsFoundationPanel.preferredSize = Dimension(OPERATION_PANEL_DIMENSIONS, OPERATION_PANEL_DIMENSIONS)
    operationsFoundationPanel.setLayout(GridLayout(7, 1))
    foundationJFrame.add(operationsFoundationPanel, BorderLayout.EAST)
    //Buttons
    addOperationalButtons(operationalButtons, operationsFoundationPanel)

    //MainJFrame attributes
    foundationJFrame.isVisible = true
    foundationJFrame.isResizable = false
}
