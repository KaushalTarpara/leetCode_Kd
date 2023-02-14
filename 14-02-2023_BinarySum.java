class 14-02-2023_BinarySum{
	 public String addBinary(String a, String b) {
         		StringBuilder sb = new StringBuilder();
   
		 int carry = 0, i = a.length()-1, j = b.length()-1;
    		
		while (i >= 0 || j >= 0 || carry > 0) {
        		       int sum = carry;
		        if (i >= 0) sum += a.charAt(i--) - '0';
		        if (j >= 0) sum += b.charAt(j--) - '0';
		        sb.append(sum % 2);
		        carry = sum / 2;
		    }
    		
		return sb.reverse().toString();
  	  }
}