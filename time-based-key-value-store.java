# Time Based Key-Value Store
class TimeMap {

    private class TimeValue {
        int timestamp;
        String value;
        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<TimeValue> list = map.get(key);

        // Binary search for largest timestamp <= given timestamp
        int l = 0, r = list.size() - 1;
        String result = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;  // candidate
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
