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

/**
 * Creates buttons for numbers and operations, and returns them in a populated list.
 * Each of the names is assigned a prefix based on their function in the program
 * "btn_" is a number button prefix, while "oper_" is the operational button prefix
 *
 * @return A pair of lists, populated with buttons for specific areas <numberButtons,operationalButtons>
 */
fun createAllButtons(): Pair<List<JButton>, List<JButton>> {
    val numberButtons = mutableListOf<JButton>()
    val operationalButtons = mutableListOf<JButton>()

    //Creating/Stylizing all NUMBER buttons
    for (label in numberTextDisplays) {
        val buttonName = "$label"
        val button = JButton(buttonName)
        button.name = buttonName
        //Stylizing the NUMBER buttons
        styleButtons(button, true)
        numberButtons.add(button)
    }

    // Creating all OPERATIONAL buttons
    for (label in operandTextDisplays) {
        val button = JButton(label)
        button.name = label
        //Stylizing the OPERATIONAL buttons
        styleButtons(button, false)
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
    if (isNewEquationCheck) {
        // Clear the display and set the new number (after an operation)
        calculationResultLabel.text = button.name
        activeNum = button.name.toInt()
        isNewEquationCheck = false // Reset the flag after first digit
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
        operationalButtonsBehavior(button)
        homePanel.add(button)
    }
}


/**
 * Updates the "clr" button depending on the caller; "=" will always set the title to "all_clr"
 * @param caller Defines who is actually calling this function as behavior changes based on this
 */
fun updateClrButtonText(caller: Int) {
    val clrButton = operationsFoundationPanel.components
        .filterIsInstance<JButton>()
        .firstOrNull { it.text in listOf("clr", "all_clr") }

    clrButton?.let {
        when (caller) {
            1 -> if (it.text == "clr") it.text = "all_clr"  // Change only if caller is equate()
            2 -> if (it.text == "all_clr") it.text = "clr"  // Change only if caller is clr button
        }
    }
}


/**
 * Assigns a behavior based on the button title
 * @param opButton The button that will be assigned a behavior
 */
fun operationalButtonsBehavior(opButton: JButton) {
    when (opButton.text) {
        "+" -> {
            opButton.addActionListener {
                currentOperation = Operation.ADD
                storedNum = activeNum
                isNewEquationCheck = true // Set to true to clear the display for the next number
            }
        }
        "-" -> {
            opButton.addActionListener {
                currentOperation = Operation.SUBTRACT
                storedNum = activeNum
                isNewEquationCheck = true // Set to true to clear the display for the next number
            }
        }
        "*" -> {
            opButton.addActionListener {
                currentOperation = Operation.MULTIPLY
                storedNum = activeNum
                isNewEquationCheck = true // Set to true to clear the display for the next number
            }
        }
        "/" -> {
            opButton.addActionListener {
                currentOperation = Operation.DIVIDE
                storedNum = activeNum
                isNewEquationCheck = true // Set to true to clear the display for the next number
            }
        }
        "=" -> {
            opButton.addActionListener {
                calculate() // Handle the equation after operation is set
            }
        }
        "clr" -> {
            opButton.addActionListener {
                updateClrButtonText(2) // Update clr button text based on activeNum
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
fun calculate() {
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
        updateClrButtonText(1) // Update clr button text based on activeNum
    }


/**
 * Stylizes each of the buttons passed in, based on their value
 *
 * @param button The button to be customized
 * @param isNumber A boolean check if the passed in buttons are part of the Numbers or Operations
 */
fun styleButtons(button: JButton, isNumber: Boolean) {
    if (isNumber) {
        button.isOpaque = true
        button.preferredSize = Dimension(CALCULATION_BUTTON_WIDTH, CALCULATION_BUTTON_HEIGHT)
        button.font = Font("Arial", Font.BOLD, NUMBER_FONT_SIZE)  // Bigger, bold font
        button.background = NUMBER_BUTTON_BACKGROUND_COLOR  // Light gray
        button.foreground = TEXT_COLOR
    } else {
        button.isOpaque = true
        button.setBorderPainted(false)
        button.font = Font("Arial", Font.BOLD, 20)
        button.background = OPERATION_BUTTON_BACKGROUND_COLOR  // Dark gray for operations
        button.foreground = OPERATION_TEXT_COLOR
        if (button.name == "+/-") {
            button.isOpaque = true
            button.setBorderPainted(false)
            button.font = Font("Arial", Font.BOLD, 20)
            button.background = SPECIAL_BUTTON_BACKGROUND_COLOR  // Unique purple for "+/-"
            button.foreground = OPERATION_TEXT_COLOR
        }
    }

}
