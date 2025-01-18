/**
 * Constants.kt
 * @author John Botonakis
 * @desc In here resides the unchanging constants and various variable and values
 * that the calculator will end up using. Either to build the appearance of the calculator,
 * define lists to pull from, or simply hang onto a magic number, the values in here can be
 * manipulated to change how the calculator looks and operates.
 */

import javax.swing.JLabel
import javax.swing.JPanel

//Constants
const val borderThickness = 2
const val screenWidth = 250
const val screenHeight = screenWidth / 2
const val calcDisplayFont = 65
//ButtonPanelWidth MUST equal 500 when combining with operationDimensions
const val buttonPanelWidth = 350
const val buttonPanelHeight = 250
//OperationDimenesions MUST equal 500 when combining with ButtonPanelWidth
const val operationsPanelDimensions = 150
const val opButtonDimensions = 25
const val calcButtonWidth = 80
const val calcButtonHeight = 75

//Declare variables for calculation
var currentOperation = ""
var storedNum = 0
var activeNum = 0

//Declare Labels/Panels
val calcLabel = JLabel("245")
val calcScreenDisplay = JPanel()
val buttonPanel = JPanel()
val operationsPanel = JPanel()

//Lists for creating Buttons
val operandsLabels = listOf("+/-","+","-","*","/","=","clr")
val numberLabels = listOf(0,1,2,3,4,5,6,7,8,9)