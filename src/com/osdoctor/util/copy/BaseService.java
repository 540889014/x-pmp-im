package com.osdoctor.util.copy;


import java.util.List;


public interface BaseService<T> {
	//新增
	public void save(T entity);
	//更新
	public void update(T entity);
	//根据id删除
	public void delete(Integer id);
	//根据id查找
	public T getById(Integer id);
	//查找列表
	public List<T> findAll();
	//条件查询实体列表--查询助手queryHelper
	public List<T> findObjects(HqlHelper hqlHelper);
	//分页条件查询实体列表--查询助手queryHelper
	public 	PageBean getPageBean(HqlHelper hqlHelper,int pageNum, int Pagesize);

}
