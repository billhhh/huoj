package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Acmteam;

/**
 * A data access object (DAO) providing persistence and search support for
 * Acmteam entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.Acmteam
 * @author MyEclipse Persistence Tools
 */

public class AcmteamDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AcmteamDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String TEAM_ID = "teamId";
	public static final String PERIOD = "period";
	public static final String NAME = "name";

	public void save(Acmteam transientInstance) {
		log.debug("saving Acmteam instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Acmteam persistentInstance) {
		log.debug("deleting Acmteam instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Acmteam findById(java.lang.Integer id) {
		log.debug("getting Acmteam instance with id: " + id);
		try {
			Acmteam instance = (Acmteam) getSession().get(
					"org.sf.model.Acmteam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Acmteam instance) {
		log.debug("finding Acmteam instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Acmteam")
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
		log.debug("finding Acmteam instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Acmteam as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByTeamId(Object teamId) {
		return findByProperty(TEAM_ID, teamId);
	}

	public List findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Acmteam instances");
		try {
			String queryString = "from Acmteam";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Acmteam merge(Acmteam detachedInstance) {
		log.debug("merging Acmteam instance");
		try {
			Acmteam result = (Acmteam) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Acmteam instance) {
		log.debug("attaching dirty Acmteam instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Acmteam instance) {
		log.debug("attaching clean Acmteam instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}