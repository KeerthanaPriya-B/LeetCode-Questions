class Solution {
    public String arrangeWords(String text) {
       
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
        
        text = text.toLowerCase();
        String words[] = text.split(" ");
        
        for(String wrd: words) {
            int len = wrd.length();
            
            if(map.containsKey(len)) {
                ArrayList<String> list = map.get(len);
                list.add(wrd);
                map.put(len, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(wrd);
                map.put(len, list);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(ArrayList<String> list : map.values()) {
            for(String wrd: list)
                sb.append(wrd+" ");
        }
        String ans = sb.toString();
        char[] ch = ans.toCharArray();
        // for(char c: ch)
        //     System.out.print(c+" ");
        ch[0] = (ch[0] >= 97 && ch[0] <= 122) ? (char)(ch[0]-32) : ch[0];
        
        return new String(ch).trim();
    }
}