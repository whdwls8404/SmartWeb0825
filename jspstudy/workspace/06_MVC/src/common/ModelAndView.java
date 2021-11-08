package common;

public class ModelAndView {

	// String view : 응답 View
	// boolean isRedirect : true(redirect) / false(forward)
	private String view;
	private boolean isRedirect;
	
	public ModelAndView() {
		
	}
	public ModelAndView(String view, boolean isRedirect) {
		super();
		this.view = view;
		this.isRedirect = isRedirect;
	}
	
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
