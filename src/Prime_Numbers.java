public void primeNumbers() {
		 for(int i=1;i<=25;i++) {
			 int count = 0;
			 for(int j=i;j>=1;j--) {
				 if(i%j==0) {
					 count++;
				 }
			 }
			 if(count==2) {
				 System.out.print(i);
			 }
		 }
	 }
