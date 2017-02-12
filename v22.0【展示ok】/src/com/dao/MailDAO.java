package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Mail;

/**
 * A data access object (DAO) providing persistence and search support for Mail
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.sf.model.Mail
 * @author MyEclipse Persistence Tools
 */

public class MailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MailDAO.class);
	// property constants
	public static final String TO_USER = "toUser";
	public static final String FROM_USER = "fromUser";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String NEW_MAIL = "newMail";
	public static final String REPLY = "reply";
	public static final String DEFUNCT = "defunct";

	public void save(Mail transientInstance) {
		log.debug("saving Mail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mail persistentInstance) {
		log.debug("deleting Mail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mail findById(java.lang.Integer id) {
		log.debug("getting Mail instance with id: " + id);
		try {
			Mail instance = (Mail) getSession().get("org.sf.model.Mail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mail instance) {
		log.debug("finding Mail instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Mail")
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
		log.debug("finding Mail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByToUser(Object toUser) {
		return findByProperty(TO_USER, toUser);
	}

	public List findByFromUser(Object fromUser) {
		return findByProperty(FROM_USER, fromUser);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByNewMail(Object newMail) {
		return findByProperty(NEW_MAIL, newMail);
	}

	public List findByReply(Object reply) {
		return findByProperty(REPLY, reply);
	}

	public List findByDefunct(Object defunct) {
		return findByProperty(DEFUNCT, defunct);
	}

	public List findAll() {
		log.debug("finding all Mail instances");
		try {
			String queryString = "from Mail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mail merge(Mail detachedInstance) {
		log.debug("merging Mail instance");
		try {
			Mail result = (Mail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mail instance) {
		log.debug("attaching dirty Mail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mail instance) {
		log.debug("attaching clean Mail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}