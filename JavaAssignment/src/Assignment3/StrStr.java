package Assignment3;

public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(strStr("b", "baba"));
		
	}

	public static int strStr(final String A, final String B) {
        
	       if(A == null || B == null){
	            return -1;
	        }
	        
	        for(int i=0;i<A.length(); i++){
	            if(B.toCharArray()[0]==A.toCharArray()[i]){
	                int j;
	                for(j = 0 ; j<B.length() && j+i < A.length();j++){
	                    if(B.toCharArray()[j]!=A.toCharArray()[j+i]){
	                        break;
	                    }
	                }
	                if(j==B.length())
	                    return i;
	            }
	        }
	        return -1;
	    }



public int strStr1(final String haystack, final String needle) {
    if((haystack.isEmpty() && needle.isEmpty()) || needle.isEmpty()){
        return -1;
    }
    int m=haystack.length();
    int n=needle.length();
    if(n>m){
        return -1;
    }
    int j=0;
    for(int i=0 ;i<m;i++){
        if(haystack.charAt(i)==needle.charAt(j)){
            if((i+n<=m) && haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
    }
    
    return -1;
}



public static int strStr2(String haystack, String needle) {
    if(haystack==null || needle==null)    
        return 0;
 
    if(needle.length() == 0)
        return 0;
 
    for(int i=0; i<haystack.length(); i++){
        if(i + needle.length() > haystack.length())
            return -1;
 
        int m = i;
        for(int j=0; j<needle.length(); j++){
            if(needle.charAt(j)==haystack.charAt(m)){
                if(j==needle.length()-1)
                    return i;
                m++;
            }else{
                break;
            }
 
        }    
    }   
 
    return -1;
}
}
