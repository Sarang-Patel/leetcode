# Reconstruct Itinerary
class Solution {
    List<String> result = new ArrayList<>();
    int total;

    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        dfs("JFK");
        return result;
    }

    public void dfs(String curr) {
        PriorityQueue<String> neighbors = map.get(curr);
        
        while(neighbors != null && !neighbors.isEmpty()) {
            String n = neighbors.poll();
            dfs(n);
        }

        result.add(0, curr);
    }
}