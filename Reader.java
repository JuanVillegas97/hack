
//This class it's it's in chaarge of reading the file and printing the calculations
// Juan Eduardo Villegas Rios A00826615 
// Creation date 5/21/2022 //.m
//.b=193
//.d=136
//.d=12
import java.util.*;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.text.DecimalFormat;

public class Reader extends MyFile {
  private static final DecimalFormat df = new DecimalFormat("0.00000");
  private int N, xk;
  private double r2, b1, b0, yk, r;
  private Vector<Double> x = new Vector<>();
  private Vector<Double> y = new Vector<>();

  Reader() {
    this.N = this.xk = 0;
    this.b0 = this.r = this.r2 = this.b1 = this.yk = 0.0;
  }

  // .i
  private void printValues() {
    System.out.println(
        "\nN = " + N + "\n" +
            "xk = " + xk + "\n" +
            "r = " + df.format(r) + "\n" +
            "r2 = " + df.format(r2) + "\n" +
            "b0 = " + df.format(b0) + "\n" +
            "b1 = " + df.format(b1) + "\n" +
            "yk = " + df.format(yk) + "\n");
  }
  // .d=19

  // .i
  private void Arithmetics() {
    Double xi = (double) 0;
    Double yi = (double) 0;
    Double x2 = (double) 0;
    Double y2 = (double) 0;
    Double xiyi = (double) 0;
    int i = 0;
    for (Double element : x) {
      xi += element;
      x2 += (Double) Math.pow(element, 2);
      xiyi += x.get(i) * y.get(i);
      i++;
    }
    for (Double element : y) {
      yi += element;
      y2 += (Double) Math.pow(element, 2);
    }
    double xavg = xi / N;
    double yavg = yi / N;

    b1 = ((xiyi) - (N * xavg) * yavg) / ((x2) - (N * (xavg * xavg)));
    r = ((N * xiyi) - ((xi) * (yi))) / Math.sqrt((N * (x2) - (xi * xi)) * (N * (y2) - (yi) * (yi)));
    r2 = Math.pow(r, 2);
    b0 = yavg - (b1) * xavg;
    yk = (b0 + (b1) * xk);
    printValues();
  }

  // .i
  public void read() { // This function reads the the given input file name and do the
    boolean first_Line = true;
    Scanner sc = new Scanner(System.in);
    System.out.println("Type the name of the file with the extension .txt: ");
    String file_Name = sc.nextLine();
    sc.close();
    try {
      Scanner scanner = new Scanner(getFile(file_Name));
      scanner.useDelimiter("[\\s\\(\\),]+");
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        data = data.trim();
        if (first_Line) {
          xk = isSingleInteger(data, xk);
          first_Line = false;
        }
        N++;
        x.add(scanner.nextDouble());
        y.add(scanner.nextDouble());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Uknown error");
    }
    Arithmetics();
  }
}
