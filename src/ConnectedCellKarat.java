 public int connectedGrid(int[][] input) {
    	boolean[][] isVisisted = new boolean[input.length][input[0].length];
    	int max = 0;
    	for(int i=0;i<input.length;i++) {
    		for(int j=0;j<input[0].length;j++) {
    			int[] count = {0};
    			if(!isVisisted[i][j]) {
    				findAll(i,j,input,count,isVisisted);
    				max = Math.max(max, count[0]);
    				//System.out.println(count[0]);
    			}
    		}
    	}
    	return max;
    }
    
    private void findAll(int i, int j, int[][] input, int[] count,boolean[][]isVisisted) {
    	if(i>input.length||j>input[0].length||i<0||j<0||input[i][j]!=1|| isVisisted[i][j]) {
    		return;
    	}
    	isVisisted[i][j] = true;
    	count[0]++;
    	findAll(i+1,j,input,count,isVisisted);
    	findAll(i-1,j,input,count,isVisisted);
    	findAll(i,j+1,input,count,isVisisted);
    	findAll(i,j-1,input,count,isVisisted);
		
	}

int[][] input8 = {{ 1, 0, 0, 0, 0 },
			          { 0, 1, 1, 0, 0 },
			          { 0, 1, 1, 1, 0 },
			          { 1, 0, 0, 0, 0 },
			          { 0, 1, 1, 0, 0 },
			          { 0, 0, 0, 0, 0 }};
	
	System.out.println( k.connectedGrid(input8)); //5
