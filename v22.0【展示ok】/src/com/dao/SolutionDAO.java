package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Solution;

/**
 * A data access object (DAO) providing persistence and search support for
 * Solution entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.Solution
 * @author MyEclipse Persistence Tools
 */

public class SolutionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SolutionDAO.class);
	// property constants
	public static final String PROBLEM_ID = "problemId";
	public static final String USER_ID = "userId";
	public static final String TIME = "time";
	public static final String MEMORY = "memory";
	public static final String CLASS_NAME = "className";
	public static final String RESULT = "result";
	public static final String LANGUAGE = "language";
	public static final String IP = "ip";
	public static final String CONTEST_ID = "contestId";
	public static final String VALID = "valid";
	public static final String NUM = "num";
	public static final String CODE_LENGTH = "codeLength";

	public void save(Solution transientInstance) {
		log.debug("saving Solution instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Solution persistentInstance) {
		log.debug("deleting Solution instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Solution findById(java.lang.Integer id) {
		log.debug("getting Solution instance with id: " + id);
		try {
			Solution instance = (Solution) getSession().get(
					"org.sf.model.Solution", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Solution instance) {
		log.debug("finding Solution instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Solution")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Solution instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Solution as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProblemId(Object problemId) {
		return findByProperty(PROBLEM_ID, problemId);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findByMemory(Object memory) {
		return findByProperty(MEMORY, memory);
	}

	public List findByClassName(Object className) {
		return findByProperty(CLASS_NAME, className);
	}

	public List findByResult(Object result) {
		return findByProperty(RESULT, result);
	}

	public List findByLanguage(Object language) {
		return findByProperty(LANGUAGE, language);
	}

	public List findByIp(Object ip) {
		return findByProperty(IP, ip);
	}

	public List findByContestId(Object contestId) {
		return findByProperty(CONTEST_ID, contestId);
	}

	public List findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List findByCodeLength(Object codeLength) {
		return findByProperty(CODE_LENGTH, codeLength);
	}

	public List findAll() {
		log.debug("finding all Solution instances");
		try {
			String queryString = "from Solution";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Solution merge(Solution detachedInstance) {
		log.debug("merging Solution instance");
		try {
			Solution result = (Solution) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Solution instance) {
		log.debug("attaching dirty Solution instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Solution instance) {
		log.debug("attaching clean Solution instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	//现有状态列表
	public List StatusList(int nowPage,int pageSize){
		String queryString = "from Solution as solution order by solution.solutionId desc";
		Query queryObject = getSession().createQuery(queryString);
		queryObject.setFirstResult(nowPage);
		queryObject.setMaxResults(pageSize);
		return queryObject.list();
	}
	
}