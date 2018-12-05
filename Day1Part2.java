import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class Day1Part2{
    int answer;
    String filename;
    Set<Integer> frequencies;
    int currentFrequency;
    
    public Day1Part2(){
        answer = 0;
        filename = "Day1Input.txt";
        frequencies = new HashSet<Integer>();
        currentFrequency = 0;
    }
    
    public void calculateFrequency(){
        boolean answerfound = false;
        while(!answerfound){
            try(BufferedReader br = new BufferedReader(new FileReader("Day1Input.txt"))) {
                for(String line; (line = br.readLine()) != null; ) {
                    if(line.charAt(0) == '+'){
                        currentFrequency = currentFrequency + Integer.parseInt(line.substring(1));
                    }else if(line.charAt(0) == '-'){
                        currentFrequency = currentFrequency - Integer.parseInt(line.substring(1));
                    }else{
                        //Do nothing, must be a zero
                    }
                    
                    System.out.println("Current frequency: " + currentFrequency);
                    if(frequencies.add(new Integer(currentFrequency)) == false){
                        answer = currentFrequency;
                        answerfound = true;
                        break;
                    }
                }
            }catch(Exception e){
            e.printStackTrace();
            }
        }
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("Solution is: " + answer);
    }
    
    public static void main(String[] args){
        Day1Part2 solver = new Day1Part2();
        solver.calculateFrequency();
        
    }
    
}