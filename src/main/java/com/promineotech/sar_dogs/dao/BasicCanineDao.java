package com.promineotech.sar_dogs.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	@Override
	public Canine createCanine(String name, String breed, int sex, Date birthdate, Long handlers_idHandlers) {
		
		SqlParams params = generateInsertSql(name, breed, sex, birthdate, handlers_idHandlers);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		Long caninePK = keyHolder.getKey().longValue();

		// @formatter:off
		return Canine.builder()
				.idCanines(caninePK)
				.Name(name)
				.Breed(breed)
				.Sex(sex)
				.Birthdate(birthdate)
				.Handlers_idHandlers(handlers_idHandlers)
				.build();
		// @formatter:on

	}
	private SqlParams generateInsertSql(String name, String breed, int sex, Date birthdate,
			Long handlers_idHandlers) {

		// @formatter:off
		String sql = ""
				+ "INSERT INTO Canines ("
				+ "Name, Breed, Sex, Birthdate, Handlers_idHandlers"
				+ ") VALUES ("
				+ ":Name, :Breed, :Sex, :Birthdate, :Handlers_idHandlers"
				+ ")";
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("Name", name);
		params.source.addValue("Breed", breed);
		params.source.addValue("Sex", sex);
		params.source.addValue("Birthdate", birthdate);
		params.source.addValue("Handlers_idHandlers", handlers_idHandlers);

		
		return params;
		
		
	}
	@Override
	public Canine deleteCanine(Long idCanines) {
		SqlParams params = generateInsertSql(idCanines);
		
		int test = jdbcTemplate.update(params.sql, params.source);
		// if we deleted 0 rows, throw a 404 exception.
		if (test == 0) {
			log.debug("Time to throw an exception");
			throw new NoSuchElementException();
		}
		
		// @formatter:off
		return Canine.builder()
				.idCanines(idCanines)
				.build();
		// @formatter:on

	}
	private SqlParams generateInsertSql(Long idCanines) {

		// @formatter:off
		String sql = ""
				+ "DELETE FROM Canines "
				+ "WHERE idCanines = :idCanines";

		log.debug("Delete SQL={}", sql);
		
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("idCanines", idCanines);
		
		return params;
	}
}
class SqlParams {
	  String sql;
	  MapSqlParameterSource source = new MapSqlParameterSource();
}
