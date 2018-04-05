package Test;
import java.util.Scanner;
public class Main_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] machines = new int[n][2];
        int[][] tasks = new int[m][3];
        for (int i = 0; i < machines.length; i++) {
			machines[i][0] = in.nextInt();
			machines[i][1] = in.nextInt();
		}
        for (int i = 0; i < tasks.length; i++) {
			tasks[i][0] = in.nextInt();
			tasks[i][1] = in.nextInt();
			tasks[i][2] = 0;
		}
        
        int ntask = 0;
        int profit = 0;
        for (int i = 0; i < machines.length; i++) {
        	int _profit = 0;
        	int taskNO = -1;
			for (int j = 0; j < tasks.length; j++) {
				if(tasks[j][2] == 0) {
					if(machines[i][0] >= tasks[j][0] && machines[i][1] >= tasks[j][1]) {
						int temp = 200 * tasks[j][0] + 3 * tasks[j][1];
						if(temp > _profit) {
							_profit = temp;
							taskNO = j;
						}
					}
				}
			}
			if(_profit > 0) {
				ntask++;
				profit += _profit;
				tasks[taskNO][2] = 1;
			}
		}
        
        System.out.printf("%d %d", ntask, profit);
    }
}
