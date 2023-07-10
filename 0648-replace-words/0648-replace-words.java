class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(String str: dictionary) 
            set.add(str);
        
        
        String[] arr = sentence.split(" ");
        
        for(int k=0; k<arr.length; k++) {
            String wrd = arr[k];
            String prefix = "";
            
            for(int i=0; i<wrd.length(); i++) {
                prefix = wrd.substring(0, i+1);
                
                if(set.contains(prefix)) {
                    wrd = prefix;
                    break;
                  // sb.append(prefix);
                }
            }
            sb.append(" "+wrd);
            // if(Present == false) {
            //     sb.append(wrd);
            //     if(k != arr.length-1)
            //         sb.append(" ");
            // }
        }
        return sb.deleteCharAt(0).toString();
        
    }
}