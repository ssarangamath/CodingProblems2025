package QueueReconstructionByHeight;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (p1, p2) -> {
            return (p1[0] == p2[0])? (p1[1] - p2[1]) : (p2[0] - p1[0]);
        });

        List<int[]> list = new LinkedList<>();

        for(int[] p: people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][2]);
    }
}
