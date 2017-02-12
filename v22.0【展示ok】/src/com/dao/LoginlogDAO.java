package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Loginlog;

/**
 * A data access object (DAO) providing persistence and search support for
 * Loginlog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.Loginlog
 * @author MyEclipse Persistence Tools
 */

public class LoginlogDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LoginlogDAO.class);

	// property constants

	public void save(Loginlog transientInstance) {
		log.debug("saving Loginlog instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Loginlog persistentInstance) {
		log.debug("deleting Loginlog instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Loginlog findById(com.model.LoginlogId id) {
		log.debug("getting Loginlog instance with id: " + id);
		try {
			Loginlog instance = (Loginlog) getSession().get(
					"org.sf.model.Loginlog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Loginlog instance) {
		log.debug("finding Loginlog instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Loginlog")
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
		log.debug("finding Loginlog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Loginlog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Loginlog instances");
		try {
			String queryString = "from Loginlog";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Loginlog merge(Loginlog detachedInstance) {
		log.debug("merging Loginlog instance");
		try {
			Loginlog result = (Loginlog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Loginlog instance) {
		log.debug("attaching dirty Loginlog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Loginlog instance) {
		log.debug("attaching clean Loginlog instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}