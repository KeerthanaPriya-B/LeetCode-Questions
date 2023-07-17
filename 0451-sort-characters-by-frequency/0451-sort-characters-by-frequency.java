class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        
        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        
        for(char c: map.keySet()) 
            q.add(c);
        
        StringBuilder sb = new StringBuilder();
        
        while(q.size() > 0) {
            char c = q.remove();
            
            int size = map.get(c);
            while(size--> 0)
                sb.append(c);
        }
       
        return sb.toString();
    }
}