import java.util.*;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;

class Main{

    // A U T O M A T I O N
    // A-2
    // T-2
    // O-2
    static void freqWords(String s){
        Map <Character, Integer> count = new LinkedHashMap<>();

        s = s.toLowerCase();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry : count.entrySet()){
            if(entry.getValue()>1)
                System.out.println(entry.getKey() +": "+entry.getValue());
        }
        
    }

    static void sortCharacters(String s){
        s = s.toLowerCase();
        Map <Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2)-> e2.getValue() - e1.getValue());

        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list){
            char ch= entry.getKey();
            int freq=entry.getValue();
            for(int i=0; i<freq; i++){
                res.append(ch);
            }
        }
        System.out.println(res);


    }

    public static void main(String argsp[]){
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        freqWords(s);
        sortCharacters(s);
        sc.close();
    }

}
