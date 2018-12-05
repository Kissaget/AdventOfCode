import java.io.*;

public class Day1Part1{
    int answer;
    String filename;
    
    public Day1Part1(){
        answer = 0;
        filename = "Day1Part1Input.txt";
    }
    
    public void calculateFrequency(){
        try(BufferedReader br = new BufferedReader(new FileReader("Day1Input.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                if(line.charAt(0) == '+'){
                    answer = answer + Integer.parseInt(line.substring(1));
                }else if(line.charAt(0) == '-'){
                    answer = answer - Integer.parseInt(line.substring(1));
                }else{
                    //Do nothing, must be a zero
                }
                System.out.println("Current frequency: " + answer);
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println("Solution is: " + answer);
    }
    
    public static void main(String[] args){
        Day1Part1 solver = new Day1Part1();
        solver.calculateFrequency();
        
    }
    
}