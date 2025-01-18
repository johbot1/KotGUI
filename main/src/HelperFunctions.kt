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
 * Each of the names are assigned a prefix based on their function in the program
 * "btn_" is a number button prefix, while "oper_" is the operational button prefix
 *
 * @return Two lists of JButton objects ready for assignment
 */
fun createButtons(): Pair <List<JButton>, List<JButton>> {
    val numberButtons = mutableListOf<JButton>()
    val operationalButtons = mutableListOf<JButton>()
    //Creating all NUMBER buttons
    for (label in numberLabels){
        val buttonName = "$label"
        val button = JButton(label.toString())
        button.name = buttonName
        button.preferredSize = Dimension(calcButtonWidth,calcButtonHeight)
        button.setFont(Font("Verdana", Font.PLAIN, 25))
        numberButtons.add(button)
//        println("Button $buttonName has been added!")//Used for debugging purposes
    }

    //Creating all OPERATIONAL Buttons
    for (label in operandsLabels) {
        val button = JButton(label)
        button.name = label
        button.preferredSize = Dimension(opButtonDimensions, opButtonDimensions)
        button.setFont(Font("Verdana", Font.PLAIN, 30))
        operationalButtons.add(button)
//        println("Button $buttonName has been added!")//Used for debugging purposes
    }
    return Pair(numberButtons, operationalButtons)
}

/**
 * Filters a button list with a specified prefix, then attaches them to a specified JPanel
 * @param buttonList  A list of JButton objects to sort through
 * @param homePanel  The panel where each of the filtered buttons will be stuck to
 */
fun addNumButtons(buttonList: List<JButton>, homePanel: JPanel){
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
 */
fun numButtonsBehavior(button: JButton) {
    if (activeNum == 0) {
        val activeNumStr = button.name
        calcLabel.text = activeNumStr
        activeNum = activeNumStr.toInt()
    }else{
        val activeNumStr = activeNum.toString() + button.name
        calcLabel.text = activeNumStr
        activeNum = activeNumStr.toInt()
    }
//    println("activeNum: $activeNum")
    }

/**
 * Filters a button list with a specified prefix, then attaches them to a specified JPanel
 * @param buttonList  A list of JButton objects to sort through
 * @param homePanel  The panel where each of the filtered buttons will be stuck to
 */
fun addOpButtons(buttonList: List<JButton>, homePanel: JPanel){
        for (button in buttonList) {
            assignOperation(button)
            homePanel.add(button)
    }
}


/**
 * Assigns operations based on the button title
 * @param opButton
 */
fun assignOperation(opButton: JButton){
    when(opButton.text){
        //Other Operation Behavior
        "+", "-", "*", "/" -> {
            opButton.addActionListener {
                currentOperation = opButton.text
                storedNum = activeNum
                activeNum = 0
            }
        }
        //Equals Sign Behavior
        "=" -> {
            currentOperation = opButton.text
            opButton.addActionListener {
                equate()
            }
        }
        //Clear Display
        "clr" -> {opButton.addActionListener {
            activeNum = 0
            storedNum = 0
            calcLabel.text = activeNum.toString()
            currentOperation = ""
        }
        }
        "+/-" -> {opButton.addActionListener {
            //if no prefix, add a "-"
            //else
        }}
    }
}

/**
 * Handles what happens when the "=" is pressed, signaling a completed equation,
 * based on the currently selected operation
 */
fun equate(){
    when(currentOperation){
        "+" ->{
            val addReturn = storedNum + activeNum
            activeNum = addReturn
            calcLabel.text = addReturn.toString()
            println("ActiveNum: $activeNum, Operation: $currentOperation, storedNum: $storedNum")
        }
        "-" ->{
            val subReturn = storedNum - activeNum
            storedNum = subReturn
            calcLabel.text = subReturn.toString()
        }
        "/" ->{
            val divReturn = storedNum / activeNum
            storedNum = divReturn
            calcLabel.text = divReturn.toString()
        }
        "*" ->{
            val multReturn = storedNum * activeNum
            storedNum = multReturn
            calcLabel.text = multReturn.toString()
        }
    }

}