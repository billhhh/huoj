package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Problem;

/**
 * A data access object (DAO) providing persistence and search support for
 * Problem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sf.model.Problem
 * @author MyEclipse Persistence Tools
 */

public class ProblemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProblemDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String INPUT = "input";
	public static final String OUTPUT = "output";
	public static final String INPUT_PATH = "inputPath";
	public static final String OUTPUT_PATH = "outputPath";
	public static final String SAMPLE_INPUT = "sampleInput";
	public static final String SAMPLE_OUTPUT = "sampleOutput";
	public static final String HINT = "hint";
	public static final String SOURCE = "source";
	public static final String TIME_LIMIT = "timeLimit";
	public static final String MEMORY_LIMIT = "memoryLimit";
	public static final String DEFUNCT = "defunct";
	public static final String CONTEST_ID = "contestId";
	public static final String ACCEPTED = "accepted";
	public static final String SUBMIT = "submit";
	public static final String SOLVED = "solved";
	public static final String SPJ = "spj";
	
	public java.lang.Integer getLastId() {
		
		java.lang.Integer id=new Integer(0);
		try {
			
			/*String queryString = "SELECT problem_id FROM jol.problem order by problem_id desc limit 1;";
			Query queryObject = getSession().createQuery(queryString);
			List list = queryObject.list();*/
			
			List list = this.findAll();
			Problem p=(Problem) list.get(list.size()-1);
			//System.out.println("problemId == "+p.getProblemId());
			
			id=p.getProblemId();
			return id;
		} catch (RuntimeException re) {
			log.error("failed", re);
			throw re;
		}
	}
	
	
public java.lang.Integer getLastId2() {
		
		java.lang.Integer id=new Integer(0);
		try {
			//System.out.println("0");
			String queryString = "select max(problemId) from Problem";
			//System.out.println("1");
			Query queryObject = getSession().createQuery(queryString);
			//System.out.println("2");
			List list = queryObject.list();
			
			//System.out.println("id=="+list.get(0));
			id=(java.lang.Integer)list.get(0);
			return id;
		} catch (RuntimeException re) {
			log.error("failed", re);
			throw re;
		}
	}

	public void save(Problem transientInstance) {
		log.debug("saving Problem instance");
		try {
			Transaction ts=getSession().beginTransaction();
			getSession().save(transientInstance);
			ts.commit();
			getSession().close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Problem persistentInstance) {
		log.debug("deleting Problem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Problem findById(java.lang.Integer id) {
		log.debug("getting Problem instance with id: " + id);
		try {
			//System.out.println("debug");
			Problem instance = (Problem) getSession().get(
					"com.model.Problem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Problem instance) {
		log.debug("finding Problem instance by example");
		try {
			List results = getSession().createCriteria("org.sf.model.Problem")
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
		log.debug("finding Problem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Problem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByInput(Object input) {
		return findByProperty(INPUT, input);
	}

	public List findByOutput(Object output) {
		return findByProperty(OUTPUT, output);
	}

	public List findByInputPath(Object inputPath) {
		return findByProperty(INPUT_PATH, inputPath);
	}

	public List findByOutputPath(Object outputPath) {
		return findByProperty(OUTPUT_PATH, outputPath);
	}

	public List findBySampleInput(Object sampleInput) {
		return findByProperty(SAMPLE_INPUT, sampleInput);
	}

	public List findBySampleOutput(Object sampleOutput) {
		return findByProperty(SAMPLE_OUTPUT, sampleOutput);
	}

	public List findByHint(Object hint) {
		return findByProperty(HINT, hint);
	}

	public List findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	public List findByTimeLimit(Object timeLimit) {
		return findByProperty(TIME_LIMIT, timeLimit);
	}

	public List findByMemoryLimit(Object memoryLimit) {
		return findByProperty(MEMORY_LIMIT, memoryLimit);
	}

	public List findByDefunct(Object defunct) {
		return findByProperty(DEFUNCT, defunct);
	}

	public List findByContestId(Object contestId) {
		return findByProperty(CONTEST_ID, contestId);
	}

	public List findByAccepted(Object accepted) {
		return findByProperty(ACCEPTED, accepted);
	}

	public List findBySubmit(Object submit) {
		return findByProperty(SUBMIT, submit);
	}

	public List findBySolved(Object solved) {
		return findByProperty(SOLVED, solved);
	}

	public List findBySpj(Object spj) {
		return findByProperty(SPJ, spj);
	}

	public List findAll() {
		log.debug("finding all Problem instances");
		try {
			String queryString = "from Problem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Problem merge(Problem detachedInstance) {
		log.debug("merging Problem instance");
		try {
			Problem result = (Problem) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Problem instance) {
		log.debug("attaching dirty Problem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Problem instance) {
		log.debug("attaching clean Problem instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List ProblemList(int nowPage,int pageSize){
		String queryString = "from Problem as problem order by problem.problemId";
		Query queryObject = getSession().createQuery(queryString);
		queryObject.setFirstResult(nowPage);
		queryObject.setMaxResults(pageSize);
		return queryObject.list();
	}
	
	//问题总数
	public int problemCount(){
		String queryString = "select count(title) from Problem";
		Query queryObject = getSession().createQuery(queryString);
		return ((Number) queryObject.uniqueResult()).intValue();  
	}
}