package Test;
import java.util.*;
//拓扑排序
public class Cmp {
	
//	public static void main(String[] args) {
//		int[][] arr = {
//				{1,2},
//				{2,4},
//				{1,3},
//				{4,3}
//		};
//		System.out.println(cmp(2,3,arr,4));
//	}
	
    public static int cmp(int g1, int g2, int[][] records, int n) {
        // write code here
    	if(records == null || records.length < 1 || n == 0) return 0;
    	int size = 0;
    	for (int i = 0; i < records.length; i++) {
			for (int j = 0; j < records[i].length; j++) {
				if(records[i][j] > size) size = records[i][j];
			}
		}
    	int[][] graph = new int[size][size];
    	for (int i = 0; i < n; i++) {
            int _i = records[i][0]-1;
            int _j = records[i][1]-1;
            if(_i == _j) continue;
			graph[_i][_j] = 1;
		}
    	Queue<Integer> queue = topologicalSort(graph);
    	for (Integer integer : queue) {
			if(integer + 1 == g1 || integer + 1 == g2) {
				return integer + 1 == g1 ? 1 : -1;
			}
		}
    	return 0;
    }
    private static Queue<Integer> topologicalSort(int[][] graph) {
		Queue<Integer> queue = new LinkedList<Integer>();
		//所有列不全为0时
		while(queue.size() < graph.length) {
			//查找列全为0对应的节点
			for (int i = 0; i < graph[0].length; i++) {
				for (int j = 0; j < graph.length; j++) {
					if(graph[j][i] != 0) break;
					if(j == graph[i].length - 1){
						//去队列检查该节点是否已存在，不存在则入队
						if(!queue.contains(i)){
							queue.add(i);
						}
					}
				}
			}
			//列全为0的节点对应的行置0
			for (Integer i : queue) {
				for (int k = 0; k < graph[0].length; k++) {
					if(graph[i][k] != 0) graph[i][k] = 0;
				}
			}
		}
		//所有列全为0，返回队列
        return queue;
	}
    
}