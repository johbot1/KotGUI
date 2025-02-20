# KotGUI
One of three Kotlin related projects for my final semester, this one a GUI project. This was a fun project, if only for the fact that I got to interact with javax swing. I like how easy it was to quickly get a template going and skeletonize what I want and how I want it. One major issue with this project, was the resetting of the active number to be able to quickly go into a new equation after hitting the equals sign. The easiest was the implementation of the positive negative button, which simply multiplied the active number by -1 to change it's sign! All in all, I liked the simplicity of this project and how quick I was able to complete it. 

# Requirements
- Kotlin v2.1.10 (JRE 23.0.2)
  - Ensure you have Kotlin by running the following command in a terminal: `kotlin -version`
- Java v23.0.2
  - Ensure you have a Java Runtime Environment (JRE) by running the following command in a terminal: `java -version`

# How to Run:
- Download the files, then navigate to the directory they are stored in via a command line
- Run the following command:
  -   `kotlinc Main.kt Constants.kt HelperFunctions.kt -include-runtime -d kotgui.jar`
  -   This will create a ".jar" file to run with the Java Environment
- Finally, run the following command to run the program:
  - `java -jar kotgui.jar`
