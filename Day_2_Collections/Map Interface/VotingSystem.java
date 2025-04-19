import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap;
    private Map<String, Integer> sortedVoteMap;
    private LinkedHashMap<String, Integer> orderedVoteMap;

    public VotingSystem() {
        this.voteMap = new HashMap<>();
        this.sortedVoteMap = new TreeMap<>();
        this.orderedVoteMap = new LinkedHashMap<>();
    }

    public void vote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVoteMap.put(candidate, orderedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, voteMap.get(candidate));
    }

    public void displaySortedResults() {
        System.out.println("Voting results sorted by candidate name:");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displayOrderedResults() {
        System.out.println("\nVoting results in the order of votes:");
        for (Map.Entry<String, Integer> entry : orderedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public int getTotalVotesForCandidate(String candidate) {
        return voteMap.getOrDefault(candidate, 0);
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");
        votingSystem.vote("Charlie");
        votingSystem.vote("Bob");
        votingSystem.vote("Bob");

        votingSystem.displaySortedResults();
        votingSystem.displayOrderedResults();

        System.out.println("\nTotal votes for Alice: " + votingSystem.getTotalVotesForCandidate("Alice"));
    }
}
