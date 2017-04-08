package com.osdoctor.dao.topicpatient.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.osdoctor.dao.topicpatient.PatientTopicDao;
import com.osdoctor.orm.topicpatient.PatientTopic;
import com.osdoctor.util.BaseDaoImpl;
@Repository
public class PatientTopicDaoImpl extends BaseDaoImpl<PatientTopic> implements PatientTopicDao{

	public List<Map<Object, Object>> findByCountHot(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery("SELECT\n" +
				"	COUNT(pr.id),\n" +
				"	pt.id as id01,\n" +
				"	pt.title as title02,\n" +
				"	pt.content as content03,\n" +
				"	pt.praiseId as praiseId04,\n" +
				"	pt.praiseCount as praiseCount05,\n" +
				"	pt.patientReplyCount as patientReplyCount06,\n" +
				"	\n" +
				"	CAST((\n" +
				"		SELECT\n" +
				"			GROUP_CONCAT(pto.photoPath)\n" +
				"		FROM\n" +
				"			patient_topicphoto pto\n" +
				"		WHERE\n" +
				"			pto.patientTopicId = pt.id\n" +
				"	) as char) as 图片07,\n" +
				"	CAST((\n" +
				"		SELECT\n" +
				"			GROUP_CONCAT(left(pr1.content,10),'<WhoAreYou>',(SELECT op_e.name FROM os_patient op_e WHERE op_e.id=pr1.authorId) SEPARATOR '<AnyMore>')\n" +
				"		FROM\n" +
				"			patient_reply pr1\n" +
				"		WHERE\n" +
				"			pr1.authorId = pt.id and pr1.views=1\n" +
				"		ORDER BY pr1.fabiaoTime DESC LIMIT 0,3\n" +
				"	) as char) as 回复08,\n" +
				"	cast(CONCAT(\n" +
				"		(\n" +
				"			SELECT\n" +
				"			(	group_concat(\n" +
				"					tl_e.id,\n" +
				"					'||',\n" +
				"					tl_e. NAME SEPARATOR '<splite key=label>'\n" +
				"				) ) #帖子所属话题，多个话题用<splite key=label>分开,话题的ID和name用||连接\n" +
				"			FROM\n" +
				"				topic_label tl_e\n" +
				"			LEFT JOIN topiclabel_patienttopic tp_e ON tl_e.id = tp_e.topicLabelId\n" +
				"			WHERE\n" +
				"				tp_e.patientTopicId = pt.id\n" +
				"			AND tl_e.views = 1\n" +
				"		),\n" +
				"		''\n" +
				"	) as char) as 话题09,\n" +
				"	(SELECT ps.name FROM patient_section ps WHERE ps.id=pt.patientSectionId) as 版块10 ,\n" +
				"	DATE_FORMAT(pt.fabiaoTime,'%Y年%m月%d日 %H:%i:%S')as fabiaoTime11,	(SELECT op.name from os_patient op where op.id=pt.author) as name12 ,	(SELECT op.personalNote from os_patient op where op.id=pt.author) as name13 \n" +
				"FROM\n" +
				"	patient_topic pt\n" +
				"LEFT JOIN patient_reply pr ON (pt.id = pr.patientTopicId)\n" +
				"WHERE\n" +
				"	(\n" +
				"		pt.views != 0\n" +
				"		OR pt.views IS NULL\n" +
				"	)\n" +
				"AND (\n" +
				"	pr.views != 0\n" +
				"	OR pr.views IS NULL\n" +
				")\n" +
				"GROUP BY\n" +
				"	pt.id\n" +
				"ORDER BY\n" +
				"	COUNT(pr.id) DESC\n" +
				"LIMIT ?,\n" +
				" ?").setInteger(0, pagenum*pagesize).setInteger(1, pagesize).list();
	}

	public List<Map<Object, Object>> findUserByHot(int num, int size) {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery("SELECT\n" +
											"	COUNT(pr.authorId),\n" +
											"	op.id,\n" +
											"	op.name,\n" +
											"	op.photoPath\n" +
											"FROM\n" +
											"	patient_reply pr\n" +
											"RIGHT JOIN os_patient op ON pr.authorId = op.id\n" +
											"WHERE\n" +
											"	(\n" +
											"		pr.views IS NULL\n" +
											"		OR pr.views != 0\n" +
											"	)\n" +
											"GROUP BY\n" +
											"	op.id\n" +
											"ORDER BY\n" +
											"	COUNT(pr.authorId) DESC\n" +
											"LIMIT ?,?").setInteger(0, num).setInteger(1, size).list();
	}

	public List<Map<Object, Object>> findNewTopic(int num, int size) {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery("SELECT\n" +
											"	pt.id,\n" +
											"	pt.title, #话题标题 位置1\n" +
											" 	ps.name as hhname, #板块名称 位置2\n" +
											"	pt.praiseCount,#点赞的数量 位置3\n" +
											"	pt.praiseId,\n" +
											"	cast(CONCAT(\n" +
											"		(\n" +
											"			SELECT\n" +
											"				group_concat(\n" +
											"					tl_e.id,\n" +
											"					'||',\n" +
											"					tl_e. NAME SEPARATOR '<splite key=label>'\n" +
											"				) #帖子所属话题，多个话题用<splite key=label>分开,话题的ID和name用||连接\n" +
											"			FROM\n" +
											"				topic_label tl_e\n" +
											"			LEFT JOIN topiclabel_patienttopic tp_e ON tl_e.id = tp_e.topicLabelId\n" +
											"			WHERE\n" +
											"				tp_e.patientTopicId = pt.id\n" +
											"			AND tl_e.views = 1\n" +
											"		),\n" +
											"		''\n" +
											"	)as char)as q,#所属的话题 位置5\n" +
											"	op.id, \n" +
											"	op.name as name1, \n" +
											"	op.photoPath, #8\n" +
											"	DATE_FORMAT(pt.fabiaoTime,'%Y年%m月%d日 %H:%i:%S'), #9\n" +
											"	left(pt.content,20),pt.patientReplyCount " +
											"FROM\n" +
											"	patient_topic pt\n" +
											"LEFT JOIN (\n" +
											"	patient_section ps,\n" +
											"	os_patient op\n" +
											") ON (\n" +
											"	op.id = pt.author\n" +
											"	AND pt.patientSectionId = ps.id\n" +
											")\n" +
											"WHERE\n" +
											"	pt.views = 1 \n" +
											"ORDER BY\n" +
											"	pt.fabiaoTime DESC\n" +
											"LIMIT ?,\n" +
											" ?").setInteger(0, num*size).setInteger(1, size).list();
	}

}
