import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Main {

        public static void main(String[] args) throws IOException{
        File params = new File("params.txt");
        FileReader fr = new FileReader(params);
        BufferedReader bf = new BufferedReader(fr);
        
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

    public int calcV(int b, int r, double c, int t) {
        
    }
}