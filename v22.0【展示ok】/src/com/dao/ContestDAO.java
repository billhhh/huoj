package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Contest;

/**
 * A data access object (DAO) providing persistence and search support for
 * Contest entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.Contest
 * @author MyEclipse Persistence Tools
 */

public class ContestDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ContestDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String DEFUNCT = "defunct";
	public static final String DESCRIPTION = "description";
	public static final String PRIVATE_ = "private_";
	public static final String LANGMASK = "langmask";

	public void save(Contest transientInstance) {
		log.debug("saving Contest instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Contest persistentInstance) {
		log.debug("deleting Contest instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contest findById(java.lang.Integer id) {
		log.debug("getting Contest instance with id: " + id);
		try {
			Contest instance = (Contest) getSession().get(
					"org.sf.model.Contest", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Contest instance) {
		log.debug("finding Contest instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Contest")
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
		log.debug("finding Contest instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Contest as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByDefunct(Object defunct) {
		return findByProperty(DEFUNCT, defunct);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByPrivate_(Object private_) {
		return findByProperty(PRIVATE_, private_);
	}

	public List findByLangmask(Object langmask) {
		return findByProperty(LANGMASK, langmask);
	}

	public List findAll() {
		log.debug("finding all Contest instances");
		try {
			String queryString = "from Contest";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Contest merge(Contest detachedInstance) {
		log.debug("merging Contest instance");
		try {
			Contest result = (Contest) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Contest instance) {
		log.debug("attaching dirty Contest instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contest instance) {
		log.debug("attaching clean Contest instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	
	// 比赛列表
		public List<Contest> contestList(int nowPage,int pageSize) {
			log.debug("finding all Contest instances");
			try {
				String queryString = "from Contest as contest order by contest.contestId desc";
				Query queryObject = getSession().createQuery(queryString);
				queryObject.setFirstResult(nowPage);
				queryObject.setMaxResults(pageSize);
				return queryObject.list();
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
		
		
		// 比赛总数
		public int contestCount() {
			String queryString = "select count(contestId) from Contest";
			Query queryObject = getSession().createQuery(queryString);
			return ((Number) queryObject.uniqueResult()).intValue();
		}
}