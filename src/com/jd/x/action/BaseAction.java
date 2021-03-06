package com.jd.x.action;

import java.io.File;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.jd.x.service.common.UserInfoService;
import com.jd.x.service.transaction.ProjectInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	@Resource
	protected UserInfoService userInfoService;

	@Resource
	protected ProjectInfoService projectInfoService;
	
	protected T model;
	
	
	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];

			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
}
