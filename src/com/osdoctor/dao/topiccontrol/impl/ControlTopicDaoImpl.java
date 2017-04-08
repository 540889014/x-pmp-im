package com.osdoctor.dao.topiccontrol.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.osdoctor.dao.topiccontrol.ControlTopicDao;
import com.osdoctor.orm.topiccontrol.ControlTopic;
import com.osdoctor.util.BaseDaoImpl;
@Repository
public class ControlTopicDaoImpl extends BaseDaoImpl<ControlTopic> implements ControlTopicDao{

	public List<Map<Object, Object>> findNewTopic(int num, int size) {
		return getSession().createSQLQuery("SELECT\n" +
				"	pt.id,\n" +
				"	pt.title, #话题标题 位置1\n" +
				"	ps.name, #板块名称 位置2\n" +
				"	pt.praiseCount,#点赞的数量 位置3\n" +
				"	pt.praiseId,\n" +
				"	cast(CONCAT(\n" +
				"		(\n" +
				"			SELECT\n" +
				"			(	group_concat(\n" +
				"					tl_e.id,\n" +
				"					'||',\n" +
				"					tl_e. NAME SEPARATOR '<splite key=label/>'\n" +
				"				) ) #帖子所属话题，多个话题用<splite key=label/>分开,话题的ID和name用--连接\n" +
				"			FROM\n" +
				"				topic_label tl_e\n" +
				"			LEFT JOIN topiclabel_controltopic tp_e ON tl_e.id = tp_e.topicLabelId\n" +
				"			WHERE\n" +
				"				tp_e.controlTopicId = pt.id\n" +
				"			AND tl_e.views = 1\n" +
				"		),\n" +
				"		''\n" +
				"	) as char) as q,#所属的话题 位置5\n" +
				"	op.id, #6\n" +
				"	op.name as a, #7\n" +
				"	op.photoPath, #8\n" +
				"	DATE_FORMAT(pt.fabiaoTime,'%Y年%m月%d日 %H:%i:%S'), #9\n" +
				"	pt.content,\n" +
				"	pt.doctorOrPatientReplyCount\n" +
				"FROM\n" +
				"	control_topic pt\n" +
				"LEFT JOIN (\n" +
				"	control_topicsection ps,\n" +
				"	os_control op\n" +
				") ON (\n" +
				"	op.id = pt.osControlId\n" +
				"	AND pt.controlSectionId = ps.id\n" +
				")\n" +
				"WHERE\n" +
				"	pt.views = 1 \n" +
				"ORDER BY\n" +
				"	pt.fabiaoTime DESC\n" +
				"LIMIT ?,\n" +
				" ?").setInteger(0, num*size).setInteger(1, size).list();
	}

	public List<Map<Object, Object>> findHotTopic(int num, int size) {
		return getSession().createSQLQuery("SELECT\n" +
				"	COUNT(pr.id),\n" +
				"	pt.id AS id01,\n" +
				"	pt.title AS title02,\n" +
				"	pt.content AS content03,\n" +
				"	pt.praiseId AS praiseId04,\n" +
				"	pt.praiseCount AS praiseCount05,\n" +
				"	pt.doctorOrPatientReplyCount AS patientReplyCount06,\n" +
				"	CAST(\n" +
				"		(\n" +
				"			SELECT\n" +
				"				GROUP_CONCAT(pto.photoPath)\n" +
				"			FROM\n" +
				"				control_topicphoto pto\n" +
				"			WHERE\n" +
				"				pto.controlTopicId = pt.id\n" +
				"		) AS CHAR\n" +
				"	) AS 图片07,\n" +
				"	\n" +
				"	cast(\n" +
				"		CONCAT(\n" +
				"			(\n" +
				"				SELECT\n" +
				"					(\n" +
				"						group_concat(\n" +
				"							tl_e.id,\n" +
				"							'||',\n" +
				"							tl_e. NAME SEPARATOR '<splite key=label>'\n" +
				"						)\n" +
				"					) #帖子所属话题，多个话题用<splite key=label/>分开,话题的ID和name用--连接\n" +
				"				FROM\n" +
				"					topic_label tl_e\n" +
				"				LEFT JOIN topiclabel_controltopic tp_e ON tl_e.id = tp_e.topicLabelId\n" +
				"				WHERE\n" +
				"					tp_e.controlTopicId = pt.id\n" +
				"				AND tl_e.views = 1\n" +
				"			),\n" +
				"			''\n" +
				"		) AS CHAR\n" +
				"	) AS 话题09,\n" +
				"	(\n" +
				"		SELECT\n" +
				"			ps. NAME\n" +
				"		FROM\n" +
				"			control_topicsection ps\n" +
				"		WHERE\n" +
				"			ps.id = pt.controlSectionId\n" +
				"	) AS 版块10,\n" +
				"	DATE_FORMAT(\n" +
				"		pt.fabiaoTime,\n" +
				"		'%Y年%m月%d日 %H:%i:%S'\n" +
				"	) AS fabiaoTime11,\n" +
				"	(\n" +
				"		SELECT\n" +
				"			op. NAME\n" +
				"		FROM\n" +
				"			os_control op\n" +
				"		WHERE\n" +
				"			op.id = pt.osControlId\n" +
				"	) AS name12\n" +
				"FROM\n" +
				"	control_topic pt\n" +
				"LEFT JOIN control_topicreply pr ON (pt.id = pr.controlTopicId)\n" +
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
				" ?").setInteger(0, num*size).setInteger(1, size).list();
	}

	public List<Map<Object, Object>> findTopicBySection(String sectionId,
			int num, int size) {
		return getSession().createSQLQuery("SELECT\n" +
				"	pt.id,\n" +
				"	pt.title, #话题标题 位置1\n" +
				"	ps.name, #板块名称 位置2\n" +
				"	pt.praiseCount,#点赞的数量 位置3\n" +
				"	pt.praiseId,\n" +
				"	cast(CONCAT(\n" +
				"		(\n" +
				"			SELECT\n" +
				"			(	group_concat(\n" +
				"					tl_e.id,\n" +
				"					'||',\n" +
				"					tl_e. NAME SEPARATOR '<splite key=label/>'\n" +
				"				) ) #帖子所属话题，多个话题用<splite key=label/>分开,话题的ID和name用--连接\n" +
				"			FROM\n" +
				"				topic_label tl_e\n" +
				"			LEFT JOIN topiclabel_controltopic tp_e ON tl_e.id = tp_e.topicLabelId\n" +
				"			WHERE\n" +
				"				tp_e.controlTopicId = pt.id\n" +
				"			AND tl_e.views = 1\n" +
				"		),\n" +
				"		''\n" +
				"	) as char) as q,#所属的话题 位置5\n" +
				"	op.id, #6\n" +
				"	op.name as a, #7\n" +
				"	op.photoPath, #8\n" +
				"	DATE_FORMAT(pt.fabiaoTime,'%Y年%m月%d日 %H:%i:%S'), #9\n" +
				"	pt.content,\n" +
				"	pt.doctorOrPatientReplyCount\n" +
				"FROM\n" +
				"	control_topic pt\n" +
				"LEFT JOIN (\n" +
				"	control_topicsection ps,\n" +
				"	os_control op\n" +
				") ON (\n" +
				"	op.id = pt.osControlId\n" +
				"	AND pt.controlSectionId = ps.id\n" +
				")\n" +
				"WHERE\n" +
				"	pt.views = 1 and pt.controlSectionId=?\n" +
				"ORDER BY\n" +
				"	pt.fabiaoTime DESC\n" +
				"LIMIT ?,\n" +
				" ?").setString(0, sectionId).setInteger(1, num*size).setInteger(2, size).list();
	}

}
