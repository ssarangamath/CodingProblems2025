package RankTeamsByVotes;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] votes = {"WXYZ","XYZW"};

        System.out.println("Winner List is :: "+ solution.rankTeams(votes));
    }
}
