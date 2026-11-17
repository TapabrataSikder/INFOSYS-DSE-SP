import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class hashmap {
    public static void main(String args[]){
        String s="automation";
        Map <Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        System.out.println(map);

        // List<Character> list = new ArrayList<>(map.entrySet());
        // for(Map.Entry<Character, Integer> entry : list){
        
        // }
    }
}
