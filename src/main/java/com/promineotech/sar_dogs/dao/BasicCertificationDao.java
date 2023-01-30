package com.promineotech.sar_dogs.dao;

import java.sql.Date;
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

import com.promineotech.sar_dogs.entity.Canine;
import com.promineotech.sar_dogs.entity.Certification;
import com.promineotech.sar_dogs.entity.Handler;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j

public class BasicCertificationDao implements CertificationDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Certification> readCertifications() {
		log.debug("DAO");
		// formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM Certifications ";
		// formatter:on
		Map<String, Object> params = new HashMap<>();


		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			

			@Override
			public Certification mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return Certification.builder()
						.idCertifications(rs.getLong("idCertifications"))
						.Agency(rs.getString("Agency"))
						.Certification(rs.getString("Certification"))
						.build();
				// formatter:on
			}});
	}
	@Override
	public Certification createCertification(String agency, String certification) {

		SqlParams params = generateInsertSql(agency, certification);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		Long certificationPK = keyHolder.getKey().longValue();

		// @formatter:off
		return Certification.builder()
				.idCertifications(certificationPK)
				.Agency(agency)
				.Certification(certification)
				.build();
		// @formatter:on

	}
	private SqlParams generateInsertSql(String agency, String certification) {

		// @formatter:off
		String sql = ""
				+ "INSERT INTO Certifications ("
				+ "Agency, Certification"
				+ ") VALUES ("
				+ ":Agency, :Certification"
				+ ")";
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("Agency", agency);
		params.source.addValue("Certification", certification);
		
		return params;

	}


}
