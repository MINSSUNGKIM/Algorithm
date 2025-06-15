import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
  
    public static void main(String[] args) throws IOException {
     
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = br.readLine();

      int missingPosition = -1;
      int currentSum = 0;

      for (int i = 0; i < 13; i++) {
          char digit = input.charAt(i);

          if (digit == '*') {
              missingPosition = i;
              continue;
          }

          int digitValue = digit - '0';

          if (i % 2 == 0) {
              currentSum += digitValue;
          } else {
              currentSum += digitValue * 3;
          }
      }

      int missingDigit = calculateMissingDigit(currentSum, missingPosition);
      System.out.println(missingDigit);
      
    }


  private static int calculateMissingDigit(int currentSum, int position) {
      int targetRemainder = (10 - (currentSum % 10)) % 10;

      if (position % 2 == 0) {
          return targetRemainder;
      } else {
          
          for (int digit = 0; digit <= 9; digit++) {
              if ((digit * 3) % 10 == targetRemainder) {
                  return digit;
              }
          }
      }

      return -1;
  }
}