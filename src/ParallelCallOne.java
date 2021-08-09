

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

public class ParallelCallOne {
	
	
	
	public ResponseContent getOneMethod() {
		ResponseContent abc = null;
		for(int i=0;i<100;i++) {
			 abc = new ResponseContent();
			WirelessBean wirelessBean = new WirelesssBean();
			wirelessBean.setDaPlan(null);
			abc.setBean(wirelessBean);
		}
		
		return abc;
	}

}
