package com.osdoctor.util.copy;


import java.util.List;


public class BaseServiceImpl<T> implements BaseService<T> {
	
	private BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public void save(T entity) {
		baseDao.save(entity);
	}

	public void update(T entity) {
		baseDao.update(entity);
	}

	public void delete(Integer id) {
		baseDao.delete(id);
	}

	public T getById(Integer id) {
		return baseDao.getById(id);
	}

	public List<T> findAll() {
		return baseDao.findAll();
	}


	public List<T> findObjects(HqlHelper hqlHelper) {
		return baseDao.findObjects(hqlHelper);
	}

	public PageBean getPageBean(HqlHelper hqlHelper, int pageNo, int pageSize) {
		return baseDao.getPageBean(pageNo,pageSize, hqlHelper);
	}

}
