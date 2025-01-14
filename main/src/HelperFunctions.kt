/**
 * Helper Functions
 * @author John Botonakis
 * @desc
 */
import java.awt.Dimension
import java.awt.Font
import java.awt.Label
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
 * @return A mutable list of JButton objects ready for assignment
 */
fun createButtons(): MutableList<JButton> {
    val buttonStorage = mutableListOf<JButton>()
    //Creating all NUMBER buttons
    for (label in numberLabels){
        val buttonName = "btn_$label"
        val button = JButton(label.toString())
        button.name = buttonName
        button.preferredSize = Dimension(calcButtonWidth,calcButtonHeight)
        button.setFont(Font("Verdana", Font.PLAIN, 25))
        buttonStorage.add(button)
        println("Button $buttonName has been added!")
    }

    //Creating all OPERATIONAL Buttons
    for (label in operandsLabels){
        val buttonName = "oper_$label"
        val button = JButton(label)
        button.name = buttonName
        button.preferredSize = Dimension(opButtonDimensions,opButtonDimensions)
        button.setFont(Font("Verdana", Font.PLAIN, 25))
        buttonStorage.add(button)
        println("Button $buttonName has been added!")
    }
    return buttonStorage
}

/**
 * Filters a button list with a specified prefix, then attaches them to a specified JPanel
 * @param prefix  The prefix string that each button name has to identify its button type
 * @param buttonList  A list of JButton objects to sort through
 * @param homePanel  The panel where each of the filtered buttons will be stuck to
 */
fun addButtons(prefix: String, buttonList: MutableList<JButton>, homePanel: JPanel){
    val filteredButtons = buttonList.filter { it.name.startsWith(prefix) }
    for (button in filteredButtons) {
        button.addActionListener {
            buttonBehavior(prefix,button,calcLabel)
        }
        homePanel.add(button)
    }
}

fun buttonBehavior(prefix: String,button: JButton, label: JLabel) {
    val tempname = button.name.removePrefix(prefix)
    label.text = tempname
}

fun reset(label: JLabel){
    label.text = "0"
}