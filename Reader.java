package source;
//This class it's it's in chaarge of reading the file and printing the calculations

// Juan Eduardo Villegas Rios A00826615
// Creation date 5/7/2022

import java.util.*;
import java.io.FileNotFoundException;

public class Reader {
  protected MyFile file;
  protected int blankLines, commentLines, codeLines, totalLines;

  Reader() {
    this.blankLines = 0;
    this.commentLines = 0;
    this.codeLines = 0;
    this.totalLines = 0;
    this.file = new MyFile();
  }

  public void print() { // This function prints the desired output
    System.out.println(
        "\nNombre del archivo: " + file.getFilename() + "\n--------------------------------------------" +
            "\nCantidad de líneas en blanco: " + blankLines +
            "\nCantidad de líneas con comentarios: " + commentLines +
            "\nCantidad de líneas con código: " + codeLines +
            "\n--------------------------------------------" +
            "\nCantidad total de líneas: " + totalLines);
  }

  public void read() { // This function reads the the given input file name and do the calculations
    try {
      Scanner scanner = new Scanner(file.fileNameSet());
      boolean gate = false;

      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        data = data.trim();

        // THIS BLOCK IT'S FOR BLANK LINES
        // ------------------------------------------
        if (data.isEmpty() || scanner.hasNextLine() == false) {
          blankLines++;
        }
        // ------------------------------------------

        // THIS BLOCK IT'S FOR COMMENTS
        // ------------------------------------------
        if (data.startsWith("//")) {
          commentLines++;
        }
        if (gate) {
          commentLines++;
        }
        if (gate && data.endsWith("*/")) {
          commentLines--;
        }
        if (data.startsWith("/*")) {
          commentLines++;
          gate = true;
        }
        if (data.endsWith("*/")) {
          commentLines++;
          gate = false;
        }
        // ------------------------------------------

        totalLines++;
      }
      scanner.close();
      codeLines = totalLines - commentLines - blankLines;
    } catch (FileNotFoundException e) {
      System.out.println("Uknown error");
    }
  }

}