package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Table1;

/**
 * A data access object (DAO) providing persistence and search support for
 * Table1 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.Table1
 * @author MyEclipse Persistence Tools
 */

public class Table1DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(Table1DAO.class);

	// property constants

	public void save(Table1 transientInstance) {
		log.debug("saving Table1 instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Table1 persistentInstance) {
		log.debug("deleting Table1 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Table1 findById(com.model.Table1Id id) {
		log.debug("getting Table1 instance with id: " + id);
		try {
			Table1 instance = (Table1) getSession().get("org.sf.model.Table1",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Table1 instance) {
		log.debug("finding Table1 instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Table1")
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
		log.debug("finding Table1 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Table1 as model where model."
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
		log.debug("finding all Table1 instances");
		try {
			String queryString = "from Table1";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Table1 merge(Table1 detachedInstance) {
		log.debug("merging Table1 instance");
		try {
			Table1 result = (Table1) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Table1 instance) {
		log.debug("attaching dirty Table1 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Table1 instance) {
		log.debug("attaching clean Table1 instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}