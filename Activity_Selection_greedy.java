import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Activity{
    int start, end;
    public Activity(int start, int end){
        this.start=start;
        this.end=end;
    }
}

public class Activity_Selection_greedy{

    public static void find(ArrayList<Activity> list){
        Comparator <Activity> c = Comparator.comparingInt(o -> o.end);
        list.sort(c);  // Collections.sort(c);

        Activity previous = list.get(0);
        System.out.println(previous.start + " to " + previous.end);

        int count=1;
        for(int i=0; i<list.size(); i++)
        {
            Activity current = list.get(i);
            if(current.start >= previous.end)
            {
                System.out.println(current.start + " to " + current.end);
                previous = current;
                count++;
            }
        }
        System.out.print(count);
    }

    public static void main(String[] args) throws Exception{
        // ArrayList<Activity> list = new ArrayList<>();
        // list.add(new Activity(0, 6));
        // list.add(new Activity(3,4));
        // list.add(new Activity(1, 2));
        // list.add(new Activity(5, 8));
        // list.add(new Activity(5,7));
        // list.add(new Activity(8, 9));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;

        String[] strtInput = line.trim().split("\\s+");
        String[] endInput = br.readLine().trim().split("\\s+");

        ArrayList<Activity> list = new ArrayList<>();
        for(int i=0; i<strtInput.length; i++)
        {
            int start = Integer.parseInt(strtInput[i]);
            int end = Integer.parseInt(endInput[i]);

            list.add(new Activity(start, end));
        }
        find(list);
    }

}