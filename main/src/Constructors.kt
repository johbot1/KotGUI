//Constructors.kt
//Author: John Botonakis
//Desc:
//
import java.awt.Button
import java.awt.Color
import java.awt.FlowLayout
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JPanel

fun createNumberButtons(number: Int): JButton {
    return JButton(number.toString())
}

class ButtonSection(private val buttonLabels: List<String>){
    private val buttonList: MutableList<Button> = mutableListOf()
    val buttonPanel: JPanel = TODO()

}