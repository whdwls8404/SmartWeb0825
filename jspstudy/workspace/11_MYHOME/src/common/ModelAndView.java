package common;

// 어디로 어떻게 이동할 것인지 저장하는 클래스
public class ModelAndView {

	private String view;         // 어디로 이동할 것인가?
	private boolean isRedirect;  // 어떻게 이동할 것인가? true는 redirect, false는 forward

	public ModelAndView() { }
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
