package mdmnw.exception;

import com.dwl.base.error.DWLStatus;

public class CustomMDMException extends Exception {
	
	DWLStatus theStatus = null;	
	
	public DWLStatus getTheStatus() {
		return theStatus;
	}

	public void setTheStatus(DWLStatus theStatus) {
		this.theStatus = theStatus;
	}

	public CustomMDMException(DWLStatus status) {
		super();
		theStatus = status;
	}

}
