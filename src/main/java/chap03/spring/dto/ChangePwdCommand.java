package chap03.spring.dto;

// 자바 빈즈
public class ChangePwdCommand {
	private String currentPassword; 
	private String newPassword;
	
	public ChangePwdCommand() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	} 
}
