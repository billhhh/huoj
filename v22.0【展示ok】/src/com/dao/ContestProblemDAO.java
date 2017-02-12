package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.ContestProblem;

/**
 * A data access object (DAO) providing persistence and search support for
 * ContestProblem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.sf.model.ContestProblem
 * @author MyEclipse Persistence Tools
 */

public class ContestProblemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ContestProblemDAO.class);

	// property constants

	public void save(ContestProblem transientInstance) {
		log.debug("saving ContestProblem instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ContestProblem persistentInstance) {
		log.debug("deleting ContestProblem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContestProblem findById(com.model.ContestProblemId id) {
		log.debug("getting ContestProblem instance with id: " + id);
		try {
			ContestProblem instance = (ContestProblem) getSession().get(
					"org.sf.model.ContestProblem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ContestProblem instance) {
		log.debug("finding ContestProblem instance by example");
		try {
			List results = getSession()
					.createCriteria("org.sf.model.ContestProblem")
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
		log.debug("finding ContestProblem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ContestProblem as model where model."
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
		log.debug("finding all ContestProblem instances");
		try {
			String queryString = "from ContestProblem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ContestProblem merge(ContestProblem detachedInstance) {
		log.debug("merging ContestProblem instance");
		try {
			ContestProblem result = (ContestProblem) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ContestProblem instance) {
		log.debug("attaching dirty ContestProblem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContestProblem instance) {
		log.debug("attaching clean ContestProblem instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}