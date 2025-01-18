/**
 * Helper Functions
 * @author John Botonakis
 * @desc
 */
import java.awt.Dimension
import java.awt.Font
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

val operandsLabels = listOf("+",".","-","*","/","=","clr")
val numberLabels = listOf(0,1,2,3,4,5,6,7,8,9)
val opButtonDimensions = 25
val calcButtonWidth = 80
val calcButtonHeight = 75


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
        val buttonName = "btn_$label"
        val button = JButton(label.toString())
        button.name = buttonName
        button.preferredSize = Dimension(calcButtonWidth,calcButtonHeight)
        button.setFont(Font("Verdana", Font.PLAIN, 25))
        numberButtons.add(button)
//        println("Button $buttonName has been added!")//Used for debugging purposes
    }

    //Creating all OPERATIONAL Buttons
    for (label in operandsLabels){
        val buttonName = "oper_$label"
        val button = JButton(label)
        button.name = buttonName
        button.preferredSize = Dimension(opButtonDimensions,opButtonDimensions)
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
            numButtonsBehavior("btn_",button,calcLabel)
        }
        homePanel.add(button)
    }
}

/**
 * Assigns behavior to a number button; that behavior is to strip it of its prefix
 * then apply that number as text to the calcLabel display
 */
fun numButtonsBehavior(prefix: String, button: JButton, label: JLabel) {
    val tempname = button.name.removePrefix(prefix)
    val activeNumStr = activeNum.toString() + tempname
    calcLabel.text = activeNumStr
    activeNum = activeNumStr.toInt()
    println("activeNum: $activeNum")
}

/**
 * Filters a button list with a specified prefix, then attaches them to a specified JPanel
 * @param prefix  The prefix string that each button name has to identify its button type
 * @param buttonList  A list of JButton objects to sort through
 * @param homePanel  The panel where each of the filtered buttons will be stuck to
 */
fun addOpButtons(buttonList: List<JButton>, homePanel: JPanel){
        for (button in buttonList) {
            val tempname = button.name.removePrefix("oper_")
            assignOperation(button,tempname)
            homePanel.add(button)
    }
}

/**
 * Resets the calculator display to 0, disregarding any operations previously entered.
 */
fun resetCalcDisplay(label: JLabel){
    label.text = ""
    currentOperation = ""
    }

/**
 *
 * @param opButton
 * @param tempName
 */
fun assignOperation(opButton: JButton, tempName: String){
    when(opButton.text){
        "+" -> {
            opButton.addActionListener {
                storedNum = activeNum
                activeNum = 0
//                println("ActiveNum: $activeNum, Operation: ${opButton.text}, storedNum: $storedNum")
                currentOperation = opButton.text
//                println(opButton.text + " clicked!") //Used for debugging purposes
            }
        }
        "-" -> {
            opButton.addActionListener {
                storedNum = activeNum
                currentOperation = opButton.text
//                println(opButton.text + " clicked!") //Used for debugging purposes
            }
        }
        "*" -> {
            opButton.addActionListener {
                currentOperation = opButton.text
//                println(currentOperation) //Used for debugging purposes
            }
        }
        "/" -> {
            opButton.addActionListener {
                currentOperation = opButton.text
//                println(opButton.text + " clicked!") //Used for debugging purposes
            }
        }
        "=" -> {
            opButton.addActionListener {
                equate()
//                println(opButton.text + " clicked!") //Used for debugging purposes
            }
        }
        "." -> {
            opButton.addActionListener {

//                println(opButton.text + " clicked!") //Used for debugging purposes
            }
        }
        "clr" -> {opButton.addActionListener {
            activeNum = 0
            storedNum = 0
            resetCalcDisplay(calcLabel)
//            println(opButton.text + " clicked!") //Used for debugging purposes
        }
        }
    }
}

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
            val multReturn = storedNum + activeNum
            storedNum = multReturn
            calcLabel.text = multReturn.toString()
        }
    }

}