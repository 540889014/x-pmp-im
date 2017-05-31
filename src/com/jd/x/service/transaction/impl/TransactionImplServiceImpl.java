package com.jd.x.service.transaction.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jd.x.dao.transaction.TransactionInfoDao;
import com.jd.x.orm.transaction.TransactionInfo;
import com.jd.x.util.BaseServiceImpl;
@Service
public class TransactionImplServiceImpl extends BaseServiceImpl<TransactionInfo>{


	private TransactionInfoDao transactionInfoDao;
	
	@Resource
	public void setTransactionInfoDao(TransactionInfoDao transactionInfoDao) {
		super.setBaseDao(transactionInfoDao);
		this.transactionInfoDao = transactionInfoDao;
	}
}
