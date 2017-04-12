package com.osdoctor.util.copy;

import java.util.List;

import com.osdoctor.util.HqlHelper;
import com.osdoctor.util.PageBean;


/**
 * 数据访问接口
 * 
 * @author java_one
 * 
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	T getById(Integer id);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Integer[] ids);

	/**
	 * 查询�?��
	 * 
	 * @return
	 */
	List<T> findAll();
	//条件查询实体列表--查询助手hqlHelper
	public List<T> findObjects(HqlHelper hqlHelper);

	/**
	 * 分页信息，传进来的参数为 起始页，�?��显示多少
	 * 
	 */
	PageBean getPageBean(int pageNum, int Pagesize, HqlHelper hqlHelper);
}
