package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Compileinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Compileinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.sf.model.Compileinfo
 * @author MyEclipse Persistence Tools
 */

public class CompileinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompileinfoDAO.class);
	// property constants
	public static final String ERROR = "error";

	public void save(Compileinfo transientInstance) {
		log.debug("saving Compileinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Compileinfo persistentInstance) {
		log.debug("deleting Compileinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Compileinfo findById(java.lang.Integer id) {
		log.debug("getting Compileinfo instance with id: " + id);
		try {
			Compileinfo instance = (Compileinfo) getSession().get(
					"org.sf.model.Compileinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Compileinfo instance) {
		log.debug("finding Compileinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("org.sf.model.Compileinfo")
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
		log.debug("finding Compileinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Compileinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByError(Object error) {
		return findByProperty(ERROR, error);
	}

	public List findAll() {
		log.debug("finding all Compileinfo instances");
		try {
			String queryString = "from Compileinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Compileinfo merge(Compileinfo detachedInstance) {
		log.debug("merging Compileinfo instance");
		try {
			Compileinfo result = (Compileinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Compileinfo instance) {
		log.debug("attaching dirty Compileinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Compileinfo instance) {
		log.debug("attaching clean Compileinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}