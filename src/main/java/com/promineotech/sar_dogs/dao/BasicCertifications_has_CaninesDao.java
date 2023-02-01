package com.promineotech.sar_dogs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.sar_dogs.entity.Certification;
import com.promineotech.sar_dogs.entity.Certifications_has_Canines;
import com.promineotech.sar_dogs.entity.Handler;

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
	@Override
	public Certifications_has_Canines createCanineCertification(Long certifications_idCertifications,
			Long canines_idCanines) {

		SqlParams params = generateInsertSql(certifications_idCertifications, canines_idCanines);
		
		// KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(params.sql, params.source);
//		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		// Long handlerPK = keyHolder.getKey().longValue();

		// @formatter:off
		return Certifications_has_Canines.builder()
				.Certifications_idCertifications(certifications_idCertifications)
				.Canines_idCanines(canines_idCanines)
				.build();
		// @formatter:on

	}
	private SqlParams generateInsertSql(Long certifications_idCertifications, Long canines_idCanines) {

		// @formatter:off
		String sql = ""
				+ "INSERT INTO Certifications_has_Canines ("
				+ "Certifications_idCertifications, Canines_idCanines) VALUES ("
				+ ":Certifications_idCertifications, :Canines_idCanines"
				+ ")";
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("Certifications_idCertifications", certifications_idCertifications);
		params.source.addValue("Canines_idCanines", canines_idCanines);

		
		return params;
		
		
	}
	@Override
	public Certifications_has_Canines deleteCanineCertification(Long certifications_idCertifications,
			Long canines_idCanines) {
		SqlParams params = generateDeleteSql(certifications_idCertifications, canines_idCanines);
		
		jdbcTemplate.update(params.sql, params.source);
		
		// @formatter:off
		return Certifications_has_Canines.builder()
				.Certifications_idCertifications(certifications_idCertifications)
				.Canines_idCanines(canines_idCanines)
				.build();
		// @formatter:on

	}
	private SqlParams generateDeleteSql(Long certifications_idCertifications, Long canines_idCanines) {

		// @formatter:off
		String sql = ""
				+ "DELETE FROM Certifications_has_Canines "
				+ "WHERE certifications_idCertifications = :certifications_idCertifications "
				+ "AND canines_idCanines = :canines_idCanines";

		log.debug("Delete SQL={}", sql);
		
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("certifications_idCertifications", certifications_idCertifications);
		params.source.addValue("canines_idCanines", canines_idCanines);


		
		return params;
	}
}
