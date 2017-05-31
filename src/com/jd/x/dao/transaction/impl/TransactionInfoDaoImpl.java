package com.jd.x.dao.transaction.impl;

import org.springframework.stereotype.Repository;

import com.jd.x.dao.transaction.TransactionInfoDao;
import com.jd.x.orm.transaction.TransactionInfo;
import com.jd.x.util.BaseDaoImpl;

@Repository
public class TransactionInfoDaoImpl extends BaseDaoImpl<TransactionInfo> implements TransactionInfoDao{

}
