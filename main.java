import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Main {

        public static void main(String[] args) throws IOException{
        File params = new File("params.txt");
        File rc = new File("rc.txt");
        FileReader fr = new FileReader(params);
        BufferedReader bf = new BufferedReader(fr);
        FileWriter writer = new FileWriter(rc);
        
        String line = ""; 
        
        line = bf.readLine();
        int bVal = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
        
        line = bf.readLine();
        int rVal = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));

        line = bf.readLine();
        double cVal = Double.parseDouble(line.substring(line.lastIndexOf(" ") + 1));

        line = bf.readLine();
        int time = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));

        line = bf.readLine();
        int timeend = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));

        

        fr.close();
        bf.close();
    }

    public static double calcV(int b, int r, double c, int t) {
        double result =  b*(1 - (Math.exp((-t/(r*c)))));
        return result;
    }
}