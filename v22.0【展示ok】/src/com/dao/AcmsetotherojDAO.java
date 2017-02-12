package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Acmsetotheroj;

/**
 * A data access object (DAO) providing persistence and search support for
 * Acmsetotheroj entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.sf.model.Acmsetotheroj
 * @author MyEclipse Persistence Tools
 */

public class AcmsetotherojDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AcmsetotherojDAO.class);
	// property constants
	public static final String OJ_NAME = "ojName";
	public static final String OJ_LINK = "ojLink";

	public void save(Acmsetotheroj transientInstance) {
		log.debug("saving Acmsetotheroj instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Acmsetotheroj persistentInstance) {
		log.debug("deleting Acmsetotheroj instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Acmsetotheroj findById(java.lang.Integer id) {
		log.debug("getting Acmsetotheroj instance with id: " + id);
		try {
			Acmsetotheroj instance = (Acmsetotheroj) getSession().get(
					"org.sf.model.Acmsetotheroj", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Acmsetotheroj instance) {
		log.debug("finding Acmsetotheroj instance by example");
		try {
			List results = getSession()
					.createCriteria("org.sf.model.Acmsetotheroj")
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
		log.debug("finding Acmsetotheroj instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Acmsetotheroj as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOjName(Object ojName) {
		return findByProperty(OJ_NAME, ojName);
	}

	public List findByOjLink(Object ojLink) {
		return findByProperty(OJ_LINK, ojLink);
	}

	public List findAll() {
		log.debug("finding all Acmsetotheroj instances");
		try {
			String queryString = "from Acmsetotheroj";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Acmsetotheroj merge(Acmsetotheroj detachedInstance) {
		log.debug("merging Acmsetotheroj instance");
		try {
			Acmsetotheroj result = (Acmsetotheroj) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Acmsetotheroj instance) {
		log.debug("attaching dirty Acmsetotheroj instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Acmsetotheroj instance) {
		log.debug("attaching clean Acmsetotheroj instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}