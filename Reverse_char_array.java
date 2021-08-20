

public class Test {

	public static void main(String[] args) {
		char[] x = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i',
				'c', 'e' };
		int start = 0;
		int end = x.length;
		for(int i=0;i<x.length/2;i++) {
			char temp = x[i];
			x[i] = x[x.length-1-i];
			x[x.length-1-i] =temp;
		}
    System.out.println(x); //ecitcarp sekam tcefrep. Reverse the array - Last to first
		while(start<end) {
			int ret = indexOf(x,start);
			if(ret == -1) {
				end = x.length;
				for(int i = 0,k=start;i<(end-start)/2;i++) {
					char t = x[k];
					x[k] = x[end-1-i];
					x[end-1-i] = t;
					k++;
				}
				start = end+1;
			}else {
				end = ret;
				for(int i = 0,k=start;i<(end-start)/2;i++) {
					char t = x[k];
					x[k] = x[end-1-i];
					x[end-1-i] = t;
					k++;
				}
				start = end+1;
				end = x.length;
			}
		}
		System.out.println(x); //practice makes perfect

	}
	
	public static int indexOf(char[]x,int start) {
		for(int i = start;i<x.length;i++) {
			if(x[i]==' ') {
				return i;
			}
		}
		return -1;
	}

}
