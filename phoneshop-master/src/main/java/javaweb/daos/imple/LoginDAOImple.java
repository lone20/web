package javaweb.daos.imple;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javaweb.Entity.Account;
import javaweb.daos.inter.LoginDAO;

@Repository("loginDAO")
public class LoginDAOImple implements LoginDAO {

	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public void saveAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (account != null) {
			try {
				session.save(account);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

	@Override
	public Account findByUserName(String username) {
		Account a = new Account();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Account where username=?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, username);
			a = (Account) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Account findByEmail(String email) {
		Account b = new Account();
		Session session1 = sessionFactory.openSession();
		Transaction tx = session1.beginTransaction();
		String hq = "from Account where email=?";
		try {
			Query query1 = session1.createQuery(hq);
			query1.setParameter(0, email);
			b = (Account) query1.uniqueResult();
			tx.commit();
			session1.close();
		} catch (Exception e) {
			tx.rollback();
			session1.close();
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Account findByResetPasswordToken(String token) {
		Account c = new Account();
		Session session1 = sessionFactory.openSession();
		Transaction tx = session1.beginTransaction();
		String hq = "from Account where reset_password_token=?";
		try {
			Query query1 = session1.createQuery(hq);
			query1.setParameter(0, token);
			c = (Account) query1.uniqueResult();
			tx.commit();
			session1.close();
		} catch (Exception e) {
			tx.rollback();
			session1.close();
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void updateAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (account != null) {
			try {
				session.update(account);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}
}
