//Constructors.kt
//Author: John Botonakis
//Desc:
//
import java.awt.*
import javax.swing.*



//PanelConstructor


//    //createNumberButtons
//    //Creates buttons for numbers, and returns them with
//    //their name being "btn_number"
//    private fun createNumberButtons(number: Int): JButton {
//        val buttonName = "btn_$number"
//        return JButton(number.toString()).also{
//            it.name = buttonName
//            //TODO: Add functionality to these buttons aside from just printing name
//            it.addActionListener {
//                println("${getButton(buttonName)} clicked!")
//            }
////            println("Created Button: ${it.name}")//Debugging tool
//        }
//    }
//
//    //createOperationButtons
//    //Creates buttons for operations, and returns them with
//    //their name being "btn_operation"
//    private fun createOperationButtons(operation: String): JButton {
//        val buttonName = "btn_$operation"
//        val button = JButton(operation.toString()).also{
//            it.name = buttonName
//            //TODO: Add functionality to these buttons
//            it.addActionListener {
//                println("$buttonName clicked!")
//            }
////            println("Created Button: ${it.name}")//Debugging tool
//        }
//            buttons[buttonName] = button
//        return button
//    }


//val numberLabels = listOf(0,1,2,3,4,5,6,7,8,9)
//                val buttonWidth = 80
//                val buttonHeight = 70
//                for (label in numberLabels){
//                    val button = createNumberButtons(label)
//                    button.preferredSize = Dimension(buttonWidth,buttonHeight)
//                    button.setFont(Font("Verdana", Font.PLAIN, 25))
//                    panel.add(button)
//                }

//val operandsLabels = listOf("+",".","-","*","/","=","clr")
//val buttonWidth =25
//val buttonHeight = 25
//for (label in operandsLabels){
//    val button = createOperationButtons(label)
//    button.preferredSize = Dimension(buttonWidth,buttonHeight)
//    button.setFont(Font("Verdana", Font.PLAIN, 25))
//    panel.add(button)
//}