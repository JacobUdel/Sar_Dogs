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

import com.promineotech.sar_dogs.entity.Canine;
import com.promineotech.sar_dogs.entity.Handler;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class BasicCanineDao implements CanineDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public List<Canine> readCanineByHandler(int handlerId) {
		log.debug("DAO: Handler ID={}", handlerId);
		// formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM Canines "
				+ "WHERE Handlers_idHandlers = :Handlers_idHandlers";		
		// formatter:on
		Map<String, Object> params = new HashMap<>();

		params.put("Handlers_idHandlers", handlerId);


		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			

			@Override
			public Canine mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return Canine.builder()
						.idCanines(rs.getLong("idCanines"))
						.Name(rs.getString("Name"))
						.Breed(rs.getString("Breed"))
						.Sex(rs.getInt("Sex"))
						.Birthdate(rs.getDate("Birthdate"))
						.Handlers_idHandlers(rs.getLong("Handlers_idHandlers"))
						.build();
				// formatter:on
			}});
	}
	@Override
	public List<Canine> readCanines() {
		log.debug("DAO");
		// formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM Canines ";		
		// formatter:on
		Map<String, Object> params = new HashMap<>();


		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			

			@Override
			public Canine mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return Canine.builder()
						.idCanines(rs.getLong("idCanines"))
						.Name(rs.getString("Name"))
						.Breed(rs.getString("Breed"))
						.Sex(rs.getInt("Sex"))
						.Birthdate(rs.getDate("Birthdate"))
						.Handlers_idHandlers(rs.getLong("Handlers_idHandlers"))
						.build();
				// formatter:on
			}});
	}
}
