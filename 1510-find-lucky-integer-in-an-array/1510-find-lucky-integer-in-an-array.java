class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSofar = -1;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)==key){
                if(key>maxSofar) maxSofar = key;
            }
        }
        return maxSofar;
    }
}