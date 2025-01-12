//Constructors.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import javax.swing.*



//PanelConstructor
//Creates and populates the section for the individual digit numbers
//And puts them on the mainJFrame
class PanelConstructor(val panelName: String){
    val panel = JPanel().also{
        it.name = panelName
        println("Created panel: $panelName")
    }
    init{
        when(panelName){
            "buttons" -> {
                val numberLabels = listOf(0,1,2,3,4,5,6,7,8,9)
                val buttonWidth = 80
                val buttonHeight = 70
                panel.background = Color.GREEN
                panel.border = BorderFactory.createLineBorder(Color.RED)
                for (label in numberLabels){
                    val button = createNumberButtons(label)
                    button.preferredSize = Dimension(buttonWidth,buttonHeight)
                    button.setFont(Font("Verdana", Font.PLAIN, 25))
                    panel.add(button)
                }
            }
            "operands"->{
                val operandsLabels = listOf("+","-","*","/","=","clr")
                val operationsPanel = JPanel()
                val buttonWidth =20
                val buttonHeight = 50
                operationsPanel.border = BorderFactory.createLoweredBevelBorder()
                operationsPanel.background = Color.BLACK
                operationsPanel.preferredSize = Dimension(250,250)
                operationsPanel.border = BorderFactory.createLineBorder(Color.BLACK,3,false)
                for (label in operandsLabels){
                    val button = createOperationButtons(label)
                    button.preferredSize = Dimension(buttonWidth,buttonHeight)
                    button.setFont(Font("Verdana", Font.PLAIN, 5))
                    panel.add(button)
                }
            }
        }

    }
    //createNumberButtons
    //Creates buttons for numbers, and returns them with
    //their name being "btn_number"
    private fun createNumberButtons(number: Int): JButton {
        val buttonName = "btn_$number"
        return JButton(number.toString()).also{
            it.name = buttonName
            println("Created Button: ${it.name}")//Debugging tool
        }
    }

    //createOperationButtons
    //Creates buttons for numbers, and returns them with
    //their name being "btn_number"
    private fun createOperationButtons(operation: String): JButton {
        val buttonName = "btn_$operation"
        return JButton(operation.toString()).also{
            it.name = buttonName
            println("Created Button: ${it.name}")//Debugging tool
        }
    }
}
