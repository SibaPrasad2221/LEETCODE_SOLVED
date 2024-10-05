class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> freqMp = new HashMap<>();
        for(var num : arr){
            int numModK = ((num % k) + k) % k;
            freqMp.put(numModK, freqMp.getOrDefault(numModK, 0)+1);
        }
        for(var freqEntry : freqMp.entrySet()){
            int numModK = freqEntry.getKey(), numModKFreq = freqEntry.getValue();
            if(numModK == 0){
                if(numModKFreq % 2 != 0)return false;
            }else{
                int compNumModK = k - numModK, compFreq = freqMp.getOrDefault(compNumModK, 0);
                if(numModKFreq != compFreq){
                   return false;
                }
            }    
        }
        return true;
    }
}