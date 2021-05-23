package javaweb.daos.inter;

import javaweb.Entity.*;

public interface LoginDAO {
	public Account findByUserName(String username);
	public Account findByEmail(String email);
	public void saveAccount(Account account); 
	public void updateAccount(Account account);
	public Account findByResetPasswordToken(String token);
}
