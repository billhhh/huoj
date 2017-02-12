package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Baoming;

/**
 * A data access object (DAO) providing persistence and search support for
 * Baoming entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.Baoming
 * @author MyEclipse Persistence Tools
 */

public class BaomingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BaomingDAO.class);
	// property constants
	public static final String NM = "nm";
	public static final String CLAS = "clas";
	public static final String XUEYUAN = "xueyuan";
	public static final String IPHONE = "iphone";
	public static final String QQ = "qq";
	public static final String EMAI = "emai";
	public static final String AD = "ad";
	public static final String INTRO = "intro";
	public static final String TI = "ti";
	public static final String SEX = "sex";

	public void save(Baoming transientInstance) {
		log.debug("saving Baoming instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Baoming persistentInstance) {
		log.debug("deleting Baoming instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Baoming findById(java.lang.String id) {
		log.debug("getting Baoming instance with id: " + id);
		try {
			Baoming instance = (Baoming) getSession().get(
					"org.sf.model.Baoming", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Baoming instance) {
		log.debug("finding Baoming instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Baoming")
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
		log.debug("finding Baoming instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Baoming as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNm(Object nm) {
		return findByProperty(NM, nm);
	}

	public List findByClas(Object clas) {
		return findByProperty(CLAS, clas);
	}

	public List findByXueyuan(Object xueyuan) {
		return findByProperty(XUEYUAN, xueyuan);
	}

	public List findByIphone(Object iphone) {
		return findByProperty(IPHONE, iphone);
	}

	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List findByEmai(Object emai) {
		return findByProperty(EMAI, emai);
	}

	public List findByAd(Object ad) {
		return findByProperty(AD, ad);
	}

	public List findByIntro(Object intro) {
		return findByProperty(INTRO, intro);
	}

	public List findByTi(Object ti) {
		return findByProperty(TI, ti);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findAll() {
		log.debug("finding all Baoming instances");
		try {
			String queryString = "from Baoming";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Baoming merge(Baoming detachedInstance) {
		log.debug("merging Baoming instance");
		try {
			Baoming result = (Baoming) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Baoming instance) {
		log.debug("attaching dirty Baoming instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Baoming instance) {
		log.debug("attaching clean Baoming instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}