class Solution {
    public String arrangeWords(String text) {
       
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        
        text = text.toLowerCase();
        String words[] = text.split(" ");
        
        for(String wrd: words) {
            int len = wrd.length();
            ArrayList<String> list = new ArrayList<>();
            
            if(map.containsKey(len)) 
                list = map.get(len);
            
            list.add(wrd);
            map.put(len, list);
        }
        
        for(ArrayList<String> list : map.values()) {
            for(String wrd: list)
                sb.append(wrd+" ");
        }
        
        char[] ch = sb.toString().toCharArray();
        ch[0] = (ch[0] >= 97 && ch[0] <= 122) ? (char)(ch[0]-32) : ch[0];
        
        return new String(ch).trim();
    }
}