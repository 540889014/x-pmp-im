package com.osdoctor.dao.topiccommon.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.osdoctor.dao.topiccommon.TopicLabelDao;
import com.osdoctor.orm.topicCommon.TopicLabel;
import com.osdoctor.util.BaseDaoImpl;
@Repository
public class TopicLabelDaoImpl extends BaseDaoImpl<TopicLabel> implements TopicLabelDao{

	public List<Map<Object, Object>> findByHot(String type) {
		return getSession().createSQLQuery("SELECT\n" +
				"	tl.id,\n" +
				"	tl. NAME\n" +
				"FROM\n" +
				"	topic_label tl\n" +
				"LEFT JOIN ospatient_topiclabel ot ON tl.id = ot.topicLabelId\n" +
				"WHERE\n" +
				"	tl.type = ? and tl.views=1\n" +
				"GROUP BY\n" +
				"	tl.id\n" +
				"ORDER BY\n" +
				"	COUNT(ot.osPatientId) DESC\n" +
				"LIMIT 0,\n" +
				" 4").setString(0, type).list();
	}

	public List<Map<Object, Object>> findHotByUser(String type,String userId, int num,
			int size) {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery("SELECT\n" +
				"	tl.id,\n" +
				"	tl. NAME,\n" +
				"IF (\n" +
				"	(\n" +
				"		SELECT\n" +
				"			GROUP_CONCAT(ot_e.topicLabelId)\n" +
				"		FROM\n" +
				"			ospatient_topiclabel ot_e\n" +
				"		WHERE\n" +
				"			ot_e.osPatientId = ?\n" +
				"		AND ot_e.topicLabelId = tl.id\n" +
				"	),\n" +
				"	1,\n" +
				"	0\n" +
				")\n" +
				"FROM\n" +
				"	topic_label tl\n" +
				"LEFT JOIN ospatient_topiclabel ot ON tl.id = ot.topicLabelId\n" +
				"WHERE\n" +
				"	tl.type = ?\n" +
				"AND tl.views = 1\n" +
				"GROUP BY\n" +
				"	tl.id\n" +
				"ORDER BY\n" +
				"	COUNT(ot.osPatientId) DESC\n" +
				"LIMIT ?,\n" +
				" ?").setString(0, userId).setString(1, type).setInteger(2, num*size).setInteger(3, size).list();
	}

}
