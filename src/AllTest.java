import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static final Logger LOG = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String s = "2021-08-16 23:22:17";
		LocalDate l = LocalDate.parse(s, FOMATTER);
		System.out.println(l);//2021-08-16
		String te = null;
		if(!Optional.ofNullable(te).isPresent()) {
			LOG.error("yes its {} null", 58);//yes its 58 null
		}else {
			System.out.println("No its not");
		}
		
		Queue<String> p = new PriorityQueue<>();
		p.add("son");
		p.add("phan");
		p.add("appe");
		p.add("zen");
		while(!p.isEmpty())
		System.out.println(p.remove());//appe
		                               //phan
		                               //son
		                               //zen
		
		Comparator<String> t = (String s1, String s2)->s2.compareTo(s1);
		Queue<String> pq = new PriorityQueue<>(t);
		pq.add("son");
		pq.add("phan");
		pq.add("appe");
		pq.add("zen");
		while(!pq.isEmpty())
			System.out.println(pq.remove());//zen
		                                    //son
		                                    //phan
		                                    //appe
	}

}
