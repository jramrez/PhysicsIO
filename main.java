import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws IOException {
    File params = new File("params.txt");
    File rc = new File("rc.txt");
    rc.delete();
    rc.createNewFile();
    FileWriter writer = new FileWriter(rc, true);
    Scanner scan = new Scanner(params);
    scan.useDelimiter(" = [a-z]\\n");  
     
    int bVal = Integer.parseInt(scan.next());
        
    int rVal = Integer.parseInt(scan.next());

    double cVal = Double.parseDouble(scan.next());

    int tStart = Integer.parseInt(scan.next());

    int tEnd = Integer.parseInt(scan.next());

    for (double i = tStart; i <= tEnd; i += (double)(tEnd - tStart)/100) {
      writer.write(calcV(bVal,rVal,cVal,i) + " " + i + "\n");
    }
    writer.close();
    scan.close();

    Scanner rcScan = new Scanner(rc);
    rcScan.useDelimiter(" |\\n");
    double lowBound = 0;
    double highBound = 0;
    double current;
    double closestHigh = 0;
    double closestLow = 0;

    while (rcScan.hasNext()) {
      current = Double.parseDouble(rcScan.next());
      if (Math.abs((bVal*0.95) - current) < Math.abs((bVal*0.95) - closestHigh)) {
        closestHigh = current;
      }
      else if (Math.abs((bVal*0.05) - current) < Math.abs((bVal*0.05) - closestLow)) {
        closestLow = current;
      }
      rcScan.next();
    }
    
    rcScan.close();
    rcScan = new Scanner(rc);
    rcScan.useDelimiter(" |\\n");
    
    do {
      current = Double.parseDouble(rcScan.next());
      if (current == closestHigh) {
        highBound = Double.parseDouble(rcScan.next());
      }
      else if (current == closestLow) {
        lowBound = Double.parseDouble(rcScan.next());
      }
    }
    while (rcScan.hasNext());
    System.out.println("Rise time is " + calcRise(lowBound, highBound));
    rcScan.close();
  }

  public static double calcV(int b, int r, double c, double t) {
    return (b*(1 - (Math.exp((-t/(r*c))))));
  }

  public static double calcRise(double ti, double tf) {
    return (tf - ti);
  }
}
