# Detect Squares
class DetectSquares {

    // x -> (y -> count)
    private Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] query) {
        int qx = query[0];
        int qy = query[1];

        if (!map.containsKey(qx)) return 0;

        int ways = 0;
        Map<Integer, Integer> sameX = map.get(qx);

        // Iterate over all possible y' where (qx, y') exists
        for (int yPrime : sameX.keySet()) {
            if (yPrime == qy) continue;

            int side = yPrime - qy;

            // Two possible squares: left and right
            int x1 = qx + side;
            int x2 = qx - side;

            // (x1, qy) and (x1, y')
            if (map.containsKey(x1)) {
                Map<Integer, Integer> col = map.get(x1);
                if (col.containsKey(qy) && col.containsKey(yPrime)) {
                    ways += sameX.get(yPrime)
                          * col.get(qy)
                          * col.get(yPrime);
                }
            }

            // (x2, qy) and (x2, y')
            if (map.containsKey(x2)) {
                Map<Integer, Integer> col = map.get(x2);
                if (col.containsKey(qy) && col.containsKey(yPrime)) {
                    ways += sameX.get(yPrime)
                          * col.get(qy)
                          * col.get(yPrime);
                }
            }
        }

        return ways;
    }
}
