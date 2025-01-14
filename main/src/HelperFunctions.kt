//HelperFunctions.kt
//Author: John Botonakis
//Desc:
//
import java.awt.Dimension
import java.awt.Font
import javax.swing.JButton
import javax.swing.JPanel

val operandsLabels = listOf("+",".","-","*","/","=","clr")
val numberLabels = listOf(0,1,2,3,4,5,6,7,8,9)
val opButtonDimensions = 25
val calcButtonWidth = 80
val calcButtonHeight = 75

//createNumberButtons
//Creates buttons for numbers, and returns them with
//their name being "btn_number"
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

fun addButtons(prefix: String, buttonList: MutableList<JButton>, homePanel: JPanel){
    val filteredButtons = buttonList.filter { it.name.startsWith(prefix) }
    for (button in filteredButtons) {
        homePanel.add(button)
    }
}