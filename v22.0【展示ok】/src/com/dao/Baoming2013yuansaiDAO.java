package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Baoming2013yuansai;

/**
 * A data access object (DAO) providing persistence and search support for
 * Baoming2013yuansai entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.sf.model.Baoming2013yuansai
 * @author MyEclipse Persistence Tools
 */

public class Baoming2013yuansaiDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(Baoming2013yuansaiDAO.class);

	// property constants

	public void save(Baoming2013yuansai transientInstance) {
		log.debug("saving Baoming2013yuansai instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Baoming2013yuansai persistentInstance) {
		log.debug("deleting Baoming2013yuansai instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Baoming2013yuansai findById(com.model.Baoming2013yuansaiId id) {
		log.debug("getting Baoming2013yuansai instance with id: " + id);
		try {
			Baoming2013yuansai instance = (Baoming2013yuansai) getSession()
					.get("org.sf.model.Baoming2013yuansai", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Baoming2013yuansai instance) {
		log.debug("finding Baoming2013yuansai instance by example");
		try {
			List results = getSession()
					.createCriteria("org.sf.model.Baoming2013yuansai")
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
		log.debug("finding Baoming2013yuansai instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Baoming2013yuansai as model where model."
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
		log.debug("finding all Baoming2013yuansai instances");
		try {
			String queryString = "from Baoming2013yuansai";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Baoming2013yuansai merge(Baoming2013yuansai detachedInstance) {
		log.debug("merging Baoming2013yuansai instance");
		try {
			Baoming2013yuansai result = (Baoming2013yuansai) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Baoming2013yuansai instance) {
		log.debug("attaching dirty Baoming2013yuansai instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Baoming2013yuansai instance) {
		log.debug("attaching clean Baoming2013yuansai instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}