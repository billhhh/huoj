package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.SourceCodeBak;

/**
 * A data access object (DAO) providing persistence and search support for
 * SourceCodeBak entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.sf.model.SourceCodeBak
 * @author MyEclipse Persistence Tools
 */

public class SourceCodeBakDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SourceCodeBakDAO.class);

	// property constants

	public void save(SourceCodeBak transientInstance) {
		log.debug("saving SourceCodeBak instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SourceCodeBak persistentInstance) {
		log.debug("deleting SourceCodeBak instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SourceCodeBak findById(com.model.SourceCodeBakId id) {
		log.debug("getting SourceCodeBak instance with id: " + id);
		try {
			SourceCodeBak instance = (SourceCodeBak) getSession().get(
					"org.sf.model.SourceCodeBak", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SourceCodeBak instance) {
		log.debug("finding SourceCodeBak instance by example");
		try {
			List results = getSession()
					.createCriteria("org.sf.model.SourceCodeBak")
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
		log.debug("finding SourceCodeBak instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SourceCodeBak as model where model."
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
		log.debug("finding all SourceCodeBak instances");
		try {
			String queryString = "from SourceCodeBak";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SourceCodeBak merge(SourceCodeBak detachedInstance) {
		log.debug("merging SourceCodeBak instance");
		try {
			SourceCodeBak result = (SourceCodeBak) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SourceCodeBak instance) {
		log.debug("attaching dirty SourceCodeBak instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SourceCodeBak instance) {
		log.debug("attaching clean SourceCodeBak instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}