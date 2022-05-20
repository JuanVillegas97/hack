package source;
//This class it's meant to be used in another class called Reader to give it more facilty and better administration program

// Juan Eduardo Villegas Rios A00826615
// Creation date 5/7/2022

import java.io.File;
import java.util.*;

public class MyFile {
 private String file_Name;
 private File file;

 MyFile() {
  this.file_Name = "";
 }

 protected File fileNameSet() { // Returns an object file meant to be read for an scanner

  System.out.print("Type the name of the file with the extension\nExample: archivo.src\nType: ");
  Scanner sc = new Scanner(System.in);
  this.file_Name = sc.nextLine();
  this.file = new File(this.file_Name);

  if (isNumeric(this.file_Name)) {
   System.out.println("This is an integer");
   System.exit(1);
  }
  if (!(this.file.exists())) {
   System.out.println("This file does not exists");
   System.exit(1);
  }
  if (this.file.length() == 0) {
   System.out.println("This file it is empty");
   System.exit(1);
  }
  sc.close();
  return this.file;
 }

 protected String getFilename() {
  return this.file_Name;
 }

 private boolean isNumeric(String string) {
  if (string == null || string.equals("")) {
   return false;
  }
  try {
   int intValue = Integer.parseInt(string);
   return true;
  } catch (NumberFormatException e) {
  }
  return false;
 }
}