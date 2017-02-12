package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Sim;

/**
 * A data access object (DAO) providing persistence and search support for Sim
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.sf.model.Sim
 * @author MyEclipse Persistence Tools
 */

public class SimDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SimDAO.class);
	// property constants
	public static final String SIM_SID = "simSId";
	public static final String SIM = "sim";

	public void save(Sim transientInstance) {
		log.debug("saving Sim instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sim persistentInstance) {
		log.debug("deleting Sim instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sim findById(java.lang.Integer id) {
		log.debug("getting Sim instance with id: " + id);
		try {
			Sim instance = (Sim) getSession().get("org.sf.model.Sim", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sim instance) {
		log.debug("finding Sim instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Sim")
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
		log.debug("finding Sim instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sim as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySimSId(Object simSId) {
		return findByProperty(SIM_SID, simSId);
	}

	public List findBySim(Object sim) {
		return findByProperty(SIM, sim);
	}

	public List findAll() {
		log.debug("finding all Sim instances");
		try {
			String queryString = "from Sim";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sim merge(Sim detachedInstance) {
		log.debug("merging Sim instance");
		try {
			Sim result = (Sim) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sim instance) {
		log.debug("attaching dirty Sim instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sim instance) {
		log.debug("attaching clean Sim instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}