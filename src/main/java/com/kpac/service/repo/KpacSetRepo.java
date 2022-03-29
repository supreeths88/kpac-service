package com.kpac.service.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kpac.service.entity.KnowledgePackageSet;

/**
 * className KpacSetRepo
 * @version 1.0
 * @author Supreeth
 *
 */

@Repository
public class KpacSetRepo {

	/** the template*/
	JdbcTemplate template;

	/**
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Get all Kpac set
	 * 
	 * @return
	 */
	public List<KnowledgePackageSet> getAllKpacSets() {
		return template.query("select * from KnowledgePackageSet", new RowMapper<KnowledgePackageSet>() {
			public KnowledgePackageSet mapRow(ResultSet rs, int row) throws SQLException {
				KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
				knowledgePackageSet.setId(rs.getInt(1));
				knowledgePackageSet.setTitle(rs.getString(2));
				knowledgePackageSet.setKpacId(rs.getInt(3));
				return knowledgePackageSet;
			}
		});
	}

	/**
	 * Get Kpac set by id
	 * 
	 * @param id
	 * @return
	 */
	public List<KnowledgePackageSet> getKpacSetById(int id) {
		return template.query("select * from KnowledgePackageSet where id=" + id + "", new RowMapper<KnowledgePackageSet>() {
			public KnowledgePackageSet mapRow(ResultSet rs, int row) throws SQLException {
				KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
				knowledgePackageSet.setId(rs.getInt(1));
				knowledgePackageSet.setTitle(rs.getString(2));
				knowledgePackageSet.setKpacId(rs.getInt(3));
				return knowledgePackageSet;
			}
		});
	}

	/** 
	 * Save Kpac set to DB
	 * 
	 * @param knowledgePackageSet
	 * @return
	 */
	public int save(KnowledgePackageSet knowledgePackageSet) {
		String sql = "insert into KnowledgePackageSet(id, title, kpacId) values('" + knowledgePackageSet.getId() + "','" + knowledgePackageSet.getTitle() + "'," + knowledgePackageSet.getKpacId() + ")";
		return template.update(sql);
	}

	
	/**
	 * delete kpac set from DB
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from KnowledgePackageSet where id=" + id + "";
		return template.update(sql);
	}
}