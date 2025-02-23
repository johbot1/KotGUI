/**
 * Constants.kt
 * @author John Botonakis
 * @desc In here resides the unchanging constants and various variable and values
 * that the calculator will end up using. Either to build the appearance of the calculator,
 * define lists to pull from, or simply hang onto a magic number, the values in here can be
 * manipulated to change how the calculator looks and operates.
 */

import java.awt.Color
import java.text.NumberFormat
import javax.swing.JLabel
import javax.swing.JPanel

//Enums (NONE replaces "input"; both are for no operation selected)
enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, NONE
}

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
var currentOperation = Operation.NONE
var storedNum = 0
var activeNum = 0
var displayNum = NumberFormat.getIntegerInstance().format(activeNum)

//Declare Labels/Panels
val calculationResultLabel = JLabel("245")
val calculationResultPanel = JPanel()
val buttonFoundationPanel = JPanel()
val operationsFoundationPanel = JPanel()

//Lists for creating Buttons
val operandTextDisplays = listOf("+/-", "+", "-", "*", "/", "=", "clr")
val numberTextDisplays = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

//Style Constants
const val NUMBER_FONT_SIZE = 25
val NUMBER_BUTTON_BACKGROUND_COLOR = Color(220, 220, 220) // Light gray for numbers
val OPERATION_BUTTON_BACKGROUND_COLOR = Color(100, 100, 100) // Dark gray for operations
val SPECIAL_BUTTON_BACKGROUND_COLOR = Color(150, 100, 255) // Purple for "+/-"
val TEXT_COLOR = Color.BLACK // Default text color
val OPERATION_TEXT_COLOR = Color.WHITE // White text for operations
