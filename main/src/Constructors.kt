//Constructors.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import javax.swing.*



//PanelConstructor
//Creates panels
class PanelConstructor(val panelName: String){
    val panel = JPanel().also{
        it.name = panelName
        println("Created panel: $panelName")
    }
    val buttons: MutableMap<String, JButton> = mutableMapOf()

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
            //TODO: Add functionality to these buttons aside from just printing name
            it.addActionListener {
                println("${buttonName} clicked!")
            }
//            println("Created Button: ${it.name}")//Debugging tool
        }
    }

    //createOperationButtons
    //Creates buttons for operations, and returns them with
    //their name being "btn_operation"
    private fun createOperationButtons(operation: String): JButton {
        val buttonName = "btn_$operation"
        val button = JButton(operation.toString()).also{
            it.name = buttonName
            //TODO: Add functionality to these buttons
            it.addActionListener {
                println("$buttonName clicked!")
            }
//            println("Created Button: ${it.name}")//Debugging tool
        }
            buttons[buttonName] = button
        return button
    }

    //getButton
    //Returns the button object
    fun getButton(buttonName: String): JButton? {
         return buttons[buttonName]
    }
}
