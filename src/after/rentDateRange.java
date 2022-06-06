package after;

import java.util.Date;

public class rentDateRange {
	private Date startRent;
	private Date endRent;
	
	public rentDateRange(java.util.Date startRent, java.util.Date endRent) {
		super();
		this.startRent = startRent;
		this.endRent = endRent;
	}
	
	public java.util.Date getStartRent() {
		return startRent;
	}
	public void setStartRent(java.util.Date startRent) {
		this.startRent = startRent;
	}
	public java.util.Date getEndRent() {
		return endRent;
	}
	public void setEndRent(java.util.Date endRent) {
		this.endRent = endRent;
	}
	
	
}
