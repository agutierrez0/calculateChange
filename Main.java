import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);

    try {
        double purchasePrice = Double.parseDouble(in.readLine());
        double cash = Double.parseDouble(in.readLine());
        Main.calculateChange(purchasePrice, cash);
    } catch (Exception e) {
        System.out.println(e);
    }
  }

  public static void calculateChange(double purchasePrice, double cash) {
    String output = "";
    double[] myArray = new double[] {50, 20, 10, 5, 2, 1, .5, .2, .1, .05, .02, .01};
    String[] myCount = new String[] {"Fifty Pounds", "Twenty Pounds", "Ten Pounds", "Five Pounds", "Two Pounds", 
      "One Pound", "Fifty Pence", "Twenty Pence", "Ten Pence", "Five Pence", "Two pence", "One Pence"};
        double diff = cash - purchasePrice;
        if (cash < purchasePrice) {
          System.out.println("ERROR");
        } else if (cash == purchasePrice){
          System.out.println("ZERO");
        }else {
          for (int i = 0; i < myArray.length; i++) {
            if (diff >= myArray[i]) {
              int HowMany = (int)(diff / myArray[i]);

              for (int j = 0; j < HowMany; j++) {
                if (output.length() == 0) {
                  output = myCount[i];
                } else {
                  output = output + ", " + myCount[i];
                }
              }
              diff = diff % myArray[i];
            }
         }
        }
        System.out.println(output);
  }
}