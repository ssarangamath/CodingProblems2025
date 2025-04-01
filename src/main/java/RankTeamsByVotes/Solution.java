package RankTeamsByVotes;

import java.util.*;

public class Solution {
    public String rankTeams(String[] votes) {
        Map<Character , int[]> map = new HashMap<>();

        for(String str: votes){
            for(int i=0;i<str.toCharArray().length;i++){
                char c = str.charAt(i);
                map.computeIfAbsent(c, k -> new int[str.length()]);

                int[] voteCounts = map.get(c);
                voteCounts[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a,b) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a-b;
        });

        StringBuilder sb = new StringBuilder();

        for(Character c: list){
            sb.append(c);
        }
        return sb.toString();
    }

    private void print(Map<Character, int[]> map){
        for(Map.Entry entry: map.entrySet()){
            System.out.println("Key :: "+entry.getKey()+" ");

            System.out.print("Votes :: ");
            for(int vote: (int[])entry.getValue()){
                System.out.print(vote + " ");
            }
            System.out.println();
        }
    }
}
