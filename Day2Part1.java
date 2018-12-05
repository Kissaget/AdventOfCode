import java.io.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class Day2Part1{
    int doubles;
    int triples;
    int answer;
    String filename;
    boolean doublefound;
    boolean triplefound;
    
    public Day2Part1(){
        doubles = 0;
        triples = 0;
        answer = 0;
        filename = "Day2Input.txt";
        doublefound = false;
        triplefound = false;
    }
    
    public void calculateChecksum(){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
                for(String line; (line = br.readLine()) != null; ) {
                    
                    doublefound = false;
                    triplefound = false;
                    
                    Map<Character, Integer> map = new HashMap<Character, Integer>();
                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if (map.containsKey(c)) {
                        
                            int count = map.get(c);
                            map.put(c, ++count);
                        } else {
                            map.put(c, 1);
                        }
                    }
                    
                    for(Map.Entry<Character, Integer> entry : map.entrySet()){
                        if(entry.getValue() == 2){
                            doublefound = true;
                        }else if(entry.getValue() == 3){
                            triplefound = true;
                        }
                    }
                    
                    if(doublefound){
                        doubles++;
                    }
                    
                    if(triplefound){
                        triples++;
                    }
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Doubles: " + doubles);
        System.out.println("Triples: " + triples);
        answer = doubles * triples;
        System.out.println("Solution checksum is: " + answer);
    }
    
    
    
    
    public static void main(String[] args){
        Day2Part1 solver = new Day2Part1();
        solver.calculateChecksum();
        
    }
    
}