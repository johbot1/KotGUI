/**
 * Helper Functions.kt
 * @author John Botonakis
 * @desc These helper functions are created with the sole intent of
 * building off of one another to handle button creation,
 * button behavior, and calculation.
 */
import java.awt.Dimension
import java.awt.Font
import javax.swing.JButton
import javax.swing.JPanel

var isNewEntry = true // New flag to track when to clear input
/**
 * Creates buttons for numbers and operations, and returns them in a populated list.
 * Each of the names is assigned a prefix based on their function in the program
 * "btn_" is a number button prefix, while "oper_" is the operational button prefix
 *
 * @return A pair of lists, populated with buttons for specific areas <numberButtons,operationalButtons>
 */
fun createButtons(): Pair<List<JButton>, List<JButton>> {
    val numberButtons = mutableListOf<JButton>()
    val operationalButtons = mutableListOf<JButton>()

    //Creating all NUMBER buttons
    for (label in numberLabels) {
        val buttonName = "$label"
        val button = JButton(label.toString())
        button.name = buttonName
        button.preferredSize = Dimension(CALCULATION_BUTTON_WIDTH, CALCULATION_BUTTON_HEIGHT)
        button.setFont(Font("Verdana", Font.PLAIN, 25))
        numberButtons.add(button)
    }

    //Creating all OPERATIONAL Buttons
    for (label in operandsLabels) {
        val button = JButton(label)
        button.name = label
        button.preferredSize = Dimension(OPERATION_BUTTON_DIMENSIONS, OPERATION_BUTTON_DIMENSIONS)
        button.setFont(Font("Verdana", Font.PLAIN, 30))
        operationalButtons.add(button)
    }
    return Pair(numberButtons, operationalButtons)
}

/**
 * Filters a button list with a specified prefix, then attaches them to a specified JPanel
 * @param buttonList  A list of JButton objects to sort through
 * @param homePanel  The JPanel where each of the filtered buttons will be stuck to
 */
fun addNumberButtons(buttonList: List<JButton>, homePanel: JPanel) {
    for (button in buttonList) {
        button.addActionListener {
            numButtonsBehavior(button)
        }
        homePanel.add(button)
    }
}

/**
 * Assigns behavior to a number button; that behavior is to strip it of its prefix
 * then apply that number as text to the calcLabel display
 *
 * @param button The specific button that needs to be assigned behavior
 */
fun numButtonsBehavior(button: JButton) {
    if (isNewEntry) {
        // Clear the display and set the new number (after an operation)
        calculationResultLabel.text = button.name
        activeNum = button.name.toInt()
        isNewEntry = false // Reset the flag after first digit
    } else {
        // Append digits normally (after the first number is entered)
        val activeNumStr = calculationResultLabel.text + button.name
        calculationResultLabel.text = activeNumStr
        activeNum = activeNumStr.toInt()
    }
//    println("activeNum: $activeNum")//Used for debugging
}

/**
 * Takes in a list of JButtons, then attaches them to a specified JPanel
 * @param buttonList  A list of JButton objects to sort through
 * @param homePanel  The panel where each of the buttons will be stuck to
 */
fun addOperationalButtons(buttonList: List<JButton>, homePanel: JPanel) {
    for (button in buttonList) {
        opButtonsBehavior(button)
        homePanel.add(button)
    }
}

fun setOperation(operation: Operation) {
    fun setOperation(op: Operation) {
        currentOperation = op
        storedNum = activeNum
        activeNum = 0
    }
}
fun updateClrButtonText() {
    val clrButton = operationsPanel.components
        .filterIsInstance<JButton>() // Only keep instances of JButton
        .find { it.text == "clr" } // Find the clr button

    // Only update if the clrButton is found
    clrButton?.let {
        // Toggle text based on the current state of the button
        if (it.text == "clr") {
            it.text = "all clr" // Change to all clr if it's currently "clr"
        } else {
            it.text = "clr" // Reset back to "clr"
        }
    }
}



/**
 * Assigns a behavior based on the button title
 * @param opButton The button that will be assigned a behavior
 */
fun opButtonsBehavior(opButton: JButton) {
    when (opButton.text) {
        "+" -> {
            opButton.addActionListener {
                currentOperation = Operation.ADD
                storedNum = activeNum
                isNewEntry = true // Set to true to clear the display for the next number
            }
        }
        "-" -> {
            opButton.addActionListener {
                currentOperation = Operation.SUBTRACT
                storedNum = activeNum
                isNewEntry = true // Set to true to clear the display for the next number
            }
        }
        "*" -> {
            opButton.addActionListener {
                currentOperation = Operation.MULTIPLY
                storedNum = activeNum
                isNewEntry = true // Set to true to clear the display for the next number
            }
        }
        "/" -> {
            opButton.addActionListener {
                currentOperation = Operation.DIVIDE
                storedNum = activeNum
                isNewEntry = true // Set to true to clear the display for the next number
            }
        }
        "=" -> {
            opButton.addActionListener {
                equate() // Handle the equation after operation is set
                updateClrButtonText() // Update clr button text based on activeNum
            }
        }
        "clr" -> {
            updateClrButtonText() // Update clr button text based on activeNum
            opButton.addActionListener {
                if (activeNum == 0) {
                    activeNum = 0
                    storedNum = 0
                    calculationResultLabel.text = activeNum.toString()
                    currentOperation = Operation.NONE
                } else {
                    // Just clear the active number
                    activeNum = 0
                    calculationResultLabel.text = activeNum.toString()
                    currentOperation = Operation.NONE
                }
            }
        }
        "+/-" -> {
            opButton.addActionListener {
                activeNum *= -1
                calculationResultLabel.text = activeNum.toString()
            }
        }
    }
}



    /**
     * Handles what happens when the "=" is pressed, signaling a completed equation,
     * based on the currently selected operation
     */
    fun equate() {
        when (currentOperation) {
            Operation.ADD -> storedNum += activeNum
            Operation.SUBTRACT -> storedNum -= activeNum
            Operation.MULTIPLY -> storedNum *= activeNum
            Operation.DIVIDE -> {
                if (activeNum != 0) {
                    storedNum /= activeNum
                } else {
                    calculationResultLabel.text = "Error"
                    return
                }
            }

            Operation.NONE -> return
        }
        calculationResultLabel.text = storedNum.toString()
        activeNum = storedNum
        currentOperation = Operation.NONE // Resets operation after equating
    }
