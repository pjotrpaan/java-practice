package ee.omis;

import org.springframework.stereotype.Component;

@Component("bootItem")
public class Boot implements Item {

	@Override
	public String getItemDescription() {
		// TODO Auto-generated method stub
		return "Boot in da ass and thou shall not pass";
	}

}
