package com.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Users;

/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.sf.model.Users
 * @author MyEclipse Persistence Tools
 */

public class UsersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String SUBMIT = "submit";
	public static final String SOLVED = "solved";
	public static final String DEFUNCT = "defunct";
	public static final String IP = "ip";
	public static final String VOLUME = "volume";
	public static final String LANGUAGE = "language";
	public static final String PASSWORD = "password";
	public static final String NICK = "nick";
	public static final String SCHOOL = "school";

	public void save(Users transientInstance) {
		log.debug("saving Users instance");
		try {
			Transaction ts = getSession().beginTransaction();
			getSession().save(transientInstance);
			ts.commit();
			getSession().close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.String id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getSession().get("com.model.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List results = getSession().createCriteria("com.model.Users")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Users> findByProperty(String propertyName, Object value) {
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Users> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Users> findBySubmit(Object submit) {
		return findByProperty(SUBMIT, submit);
	}

	public List<Users> findBySolved(Object solved) {
		return findByProperty(SOLVED, solved);
	}

	public List<Users> findByDefunct(Object defunct) {
		return findByProperty(DEFUNCT, defunct);
	}

	public List<Users> findByIp(Object ip) {
		return findByProperty(IP, ip);
	}

	public List<Users> findByVolume(Object volume) {
		return findByProperty(VOLUME, volume);
	}

	public List<Users> findByLanguage(Object language) {
		return findByProperty(LANGUAGE, language);
	}

	public List<Users> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Users> findByNick(Object nick) {
		return findByProperty(NICK, nick);
	}

	public List<Users> findBySchool(Object school) {
		return findByProperty(SCHOOL, school);
	}

	public List<Users> findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = (Users) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	// 存在返回true
	public boolean user_exist(String user_id) {
		if (user_id == null)
			return false;
		Users user = this.findById(user_id);
		if (user != null)
			return true;
		else
			return false;

	}

	// 获取ip
	public String getIp() {
		HttpServletRequest req = ServletActionContext.getRequest();
		return req.getRemoteAddr();
	}

	// 排名
	public List<Users> rankList(int nowPage,int pageSize) {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users as users order by users.solved desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult(nowPage);
			queryObject.setMaxResults(pageSize);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	// 用户总数
	public int usersCount() {
		String queryString = "select count(userId) from Users";
		Query queryObject = getSession().createQuery(queryString);
		return ((Number) queryObject.uniqueResult()).intValue();
	}

}
