package com.promineotech.sar_dogs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.sar_dogs.entity.Certification;
import com.promineotech.sar_dogs.entity.Certifications_has_Canines;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class BasicCertifications_has_CaninesDao implements Certifications_has_CaninesDao {

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Certifications_has_Canines> readCertifications_has_Canines() {
		log.debug("DAO");
		// formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM Certifications_has_Canines ";
		// formatter:on
		Map<String, Object> params = new HashMap<>();


		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			

			@Override
			public Certifications_has_Canines mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return Certifications_has_Canines.builder()
						.Certifications_idCertifications(rs.getLong("Certifications_idCertifications"))
						.Canines_idCanines(rs.getLong("Canines_idCanines"))
						.build();
				// formatter:on
			}});
	}

}
