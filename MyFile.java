
//This class it's meant to be used in another class called Reader to give it more facilty and better administration for the program
// Juan Eduardo Villegas Rios A00826615
// Creation date 5/8/2022 //.m
//.b=90
//.d=43

import java.io.File;

public class MyFile {
  MyFile() {
  }

  // .i
  protected File getFile(String file_Name) { // Returns an object file that was read from the disk //.m
    File file = new File(file_Name); // .m

    if (isNumeric(file_Name)) {// .m
      System.out.println("This is an integer");
      System.exit(1);
    }
    if (!(file.exists())) {// .m
      System.out.println("This file does not exists");
      System.exit(1);
    }
    if (file.length() == 0) {// .m
      System.out.println("This file it is empty");
      System.exit(1);
    }
    return file;
  }

  // .i
  protected int isSingleInteger(String data, int xk) {
    try {
      xk = Integer.parseInt(data);
    } catch (NumberFormatException ex) {
      System.out.println("This is not the format asked");
      System.exit(1);
    }
    return xk;
  }

  // .i
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