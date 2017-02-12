package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.SourceCode;

/**
 * A data access object (DAO) providing persistence and search support for
 * SourceCode entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.SourceCode
 * @author MyEclipse Persistence Tools
 */

public class SourceCodeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SourceCodeDAO.class);
	// property constants
	public static final String SOURCE = "source";

	public void save(SourceCode transientInstance) {
		log.debug("saving SourceCode instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SourceCode persistentInstance) {
		log.debug("deleting SourceCode instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SourceCode findById(java.lang.Integer id) {
		log.debug("getting SourceCode instance with id: " + id);
		try {
			SourceCode instance = (SourceCode) getSession().get(
					"org.sf.model.SourceCode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SourceCode instance) {
		log.debug("finding SourceCode instance by example");
		try {
			List results = getSession()
					.createCriteria("org.sf.model.SourceCode")
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
		log.debug("finding SourceCode instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SourceCode as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	public List findAll() {
		log.debug("finding all SourceCode instances");
		try {
			String queryString = "from SourceCode";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SourceCode merge(SourceCode detachedInstance) {
		log.debug("merging SourceCode instance");
		try {
			SourceCode result = (SourceCode) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SourceCode instance) {
		log.debug("attaching dirty SourceCode instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SourceCode instance) {
		log.debug("attaching clean SourceCode instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}