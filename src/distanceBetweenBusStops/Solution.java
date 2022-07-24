package distanceBetweenBusStops;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        var sum = 0;
        for (var dist:distance) {
            sum += dist;
        }
        if (start > destination) {
            var temp = start;
            start = destination;
            destination = temp;
        }
        var directDist = 0;
        for (var i = start;i < destination;i++) {
            directDist += distance[i];
        }
        return directDist << 1 > sum ? sum - directDist : directDist;
    }
}
