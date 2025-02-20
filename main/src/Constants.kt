/**
 * Constants.kt
 * @author John Botonakis
 * @desc In here resides the unchanging constants and various variable and values
 * that the calculator will end up using. Either to build the appearance of the calculator,
 * define lists to pull from, or simply hang onto a magic number, the values in here can be
 * manipulated to change how the calculator looks and operates.
 */

import java.text.NumberFormat
import javax.swing.JLabel
import javax.swing.JPanel

//Constants
const val BORDER_THICKNESS = 2
const val SCREEN_WIDTH = 250
const val SCREEN_HEIGHT = SCREEN_WIDTH / 2
const val CALC_DISPLAY_HEIGHT = 65

//ButtonPanelWidth MUST equal 500 when combining with operationDimensions
const val BUTTON_PANEL_WIDTH = 350
const val BUTTON_PANEL_HEIGHT = 250

//OperationDimenesions MUST equal 500 when combining with ButtonPanelWidth
const val OPERATION_PANEL_DIMENSIONS = 150
const val OPERATION_BUTTON_DIMENSIONS = 25
const val CALCULATION_BUTTON_WIDTH = 80
const val CALCULATION_BUTTON_HEIGHT = 75

//Declare variables for calculation
var currentOperation = "input"
var storedNum = 0
var activeNum = 0
var displayNum = NumberFormat.getIntegerInstance().format(activeNum)

//Declare Labels/Panels
val calcLabel = JLabel("245")
val calcScreenDisplay = JPanel()
val buttonPanel = JPanel()
val operationsPanel = JPanel()

//Lists for creating Buttons
val operandsLabels = listOf("+/-", "+", "-", "*", "/", "=", "clr")
val numberLabels = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)