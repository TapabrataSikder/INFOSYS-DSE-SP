import java.util.Scanner;

static class Avg_prev_next {
    public int findCount(int[] num){
        int count=0;
        for(int i=1; i<num.length-1; i++){
            if((num[i-1]+num[i+1]) / 2.0 == num[i]){
                count++;
            }
        }


        return count;
    }
}

public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    String input[] = sc.nextLine().trim().split(",");
    int num[] = new int[n];
    for(int i=0; i<n; i++){
        num[i] = Integer.parseInt(input[i].trim());
    }

    Avg_prev_next ob = new Avg_prev_next();

    System.out.print(ob.findCount(num));

    sc.close();
}
