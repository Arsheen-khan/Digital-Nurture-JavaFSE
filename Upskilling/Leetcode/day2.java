class Solution {
    public boolean checkString(String s) {
        boolean foundb=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                foundb=true;
            }
            else if(s.charAt(i)=='a' && foundb){
                return false;
            }
        }
        return true;
        
    }
}