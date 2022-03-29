package com.kpac.service.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kpac.service.entity.KnowledgePackage;

/**
 * className KpacRepo
 * @version 1.0
 * @author Supreeth
 *
 */

@Repository
public class KpacRepo {

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
	 * Get All Kpacs from DB 
	 * 
	 * @return List<KnowledgePackage> 
	 */
	public List<KnowledgePackage> getAllKpacs() {
		return template.query("select * from KnowledgePackage", new RowMapper<KnowledgePackage>() {
			public KnowledgePackage mapRow(ResultSet rs, int row) throws SQLException {
				KnowledgePackage knowledgePackage = new KnowledgePackage();
				knowledgePackage.setId(rs.getInt(1));
				knowledgePackage.setTitle(rs.getString(2));
				knowledgePackage.setDescription(rs.getString(3));
				knowledgePackage.setDate(rs.getString(4));
				return knowledgePackage;
			}
		});
	}

	/**
	 * Save Kpac to DB
	 * 
	 * @param knowledgePackage
	 * @return
	 */
	public int save(KnowledgePackage knowledgePackage) {
		String sql = "insert into KnowledgePackage(title, description, date) values('" + knowledgePackage.getTitle()
				+ "','" + knowledgePackage.getDescription() + "','" + knowledgePackage.getDate() + "')";
		return template.update(sql);
	}

	/**
	 * delete Kpac from DB
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from KnowledgePackage where id=" + id + "";
		return template.update(sql);
	}

	/**
	 * get kpacs by Ids
	 * 
	 * @param ids
	 * @return
	 */
	public List<KnowledgePackage> getKpacsByIds(String ids) {
		return template.query("select * from KnowledgePackage where id in " + ids + "",
				new RowMapper<KnowledgePackage>() {
					public KnowledgePackage mapRow(ResultSet rs, int row) throws SQLException {
						KnowledgePackage knowledgePackage = new KnowledgePackage();
						knowledgePackage.setId(rs.getInt(1));
						knowledgePackage.setTitle(rs.getString(2));
						knowledgePackage.setDescription(rs.getString(3));
						knowledgePackage.setDate(rs.getString(4));
						return knowledgePackage;
					}
				});
	}

}