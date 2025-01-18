//Main.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import javax.swing.*



//Declare Labels/Panels
val calcLabel = JLabel("245")
val calcScreenDisplay = JPanel()
val buttonPanel = JPanel()
val operationsPanel = JPanel()
var currentOperation = ""
var storedNum = 0
var activeNum = 0

//Constants
const val borderThickness = 2
const val screenWidth = 250
const val screenHeight = screenWidth / 2
const val calcDisplayFont = 65
const val buttonPanelWidth = 350
const val buttonPanelHeight = 250
const val operationDimensions = 150
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
    calcLabel.text = activeNum.toString()
    calcScreenDisplay.add(calcLabel, "display")


    //Button Panel
    //Using the PanelConstructor, create a buttons panel
    //ButtonPanelWidth MUST equal 500 when combining with operationDimensions
    buttonPanel.border = BorderFactory.createRaisedBevelBorder()
    buttonPanel.background = Color.GREEN
    buttonPanel.setLayout(GridLayout(3, 2))
    buttonPanel.preferredSize = Dimension(buttonPanelWidth, buttonPanelHeight)
    mainJframe.add(buttonPanel, BorderLayout.WEST)
    //Buttons
    addNumButtons(numberButtons, buttonPanel)


    //Operations Panel
    //Using the PanelConstructor, create an operations panel
    //OperationDimenesions MUST equal 500 when combining with ButtonPanelWidth
    operationsPanel.border = BorderFactory.createLoweredBevelBorder()
    operationsPanel.background = Color.LIGHT_GRAY
    operationsPanel.preferredSize = Dimension(operationDimensions, operationDimensions)
    operationsPanel.setLayout(GridLayout(7, 1))
    mainJframe.add(operationsPanel, BorderLayout.EAST)
    //Buttons
    addOpButtons(operationalButtons, operationsPanel)

    //MainJFrame attributes
    mainJframe.isVisible = true
    mainJframe.isResizable = false
}
