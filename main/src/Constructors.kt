//Constructors.kt
//Author: John Botonakis
//Desc:
//
import javax.swing.JButton

fun createNumberButtons(number: Int): JButton {
    return JButton(number.toString())
}