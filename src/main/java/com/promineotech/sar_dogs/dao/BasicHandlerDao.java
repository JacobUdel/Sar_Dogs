package com.promineotech.sar_dogs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import com.promineotech.sar_dogs.entity.Handler;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j

public class BasicHandlerDao implements HandlerDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Handler> readHandlerByName(String lastName, String firstName) {
		log.debug("DAO: Lastname={} FirstName={}", lastName, firstName);
		// formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM Handlers "
				+ "WHERE LastName = :LastName AND FirstName = :FirstName";		
		// formatter:on
		Map<String, Object> params = new HashMap<>();

		params.put("LastName", lastName);
		params.put("FirstName", firstName);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			

			@Override
			public Handler mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return Handler.builder()
						.idHandlers(rs.getLong("idHandlers"))
						.LastName(rs.getString("LastName"))
						.FirstName(rs.getString("FirstName"))
						.HomeStreet(rs.getString("HomeStreet"))
						.HomeStreet2(rs.getString("HomeStreet2"))
						.HomeCity(rs.getString("HomeCity"))
						.HomeState(rs.getString("HomeState"))
						.HomeZip(rs.getLong("HomeZip"))
						.MailingStreet(rs.getString("MailingStreet"))
						.MailingStreet2(rs.getString("MailingStreet2"))
						.MailingCity(rs.getString("MailingCity"))
						.MailingState(rs.getString("MailingState"))
						.MailingZip(rs.getLong("MailingZip"))
						.MobilePhone(rs.getString("MobilePhone"))
						.Email(rs.getString("Email"))
						.build();
				// formatter:on
			}});
	}
	@Override
	public List<Handler> readHandlers() {
		// formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM Handlers";		
		// formatter:on
		Map<String, Object> params = new HashMap<>();

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			

			@Override
			public Handler mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return Handler.builder()
						.idHandlers(rs.getLong("idHandlers"))
						.LastName(rs.getString("LastName"))
						.FirstName(rs.getString("FirstName"))
						.HomeStreet(rs.getString("HomeStreet"))
						.HomeStreet2(rs.getString("HomeStreet2"))
						.HomeCity(rs.getString("HomeCity"))
						.HomeState(rs.getString("HomeState"))
						.HomeZip(rs.getLong("HomeZip"))
						.MailingStreet(rs.getString("MailingStreet"))
						.MailingStreet2(rs.getString("MailingStreet2"))
						.MailingCity(rs.getString("MailingCity"))
						.MailingState(rs.getString("MailingState"))
						.MailingZip(rs.getLong("MailingZip"))
						.MobilePhone(rs.getString("MobilePhone"))
						.Email(rs.getString("Email"))
						.build();
				// formatter:on
			}});

	}
	@Override
	public Handler createHandler(String lastName, String firstName, String homeStreet, String homeStreet2,
			String homeCity, String homeState, Long homeZip, String mailingStreet, String mailingStreet2,
			String mailingCity, String mailingState, Long mailingZip, String mobilePhone, String email) {
		
		SqlParams params = generateInsertSql(lastName, firstName, homeStreet, homeStreet2, homeCity, homeState, homeZip,
				mailingStreet, mailingStreet2, mailingCity, mailingState, mailingZip, mobilePhone, email);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		Long handlerPK = keyHolder.getKey().longValue();

		// @formatter:off
		return Handler.builder()
				.idHandlers(handlerPK)
				.LastName(lastName)
				.FirstName(firstName)
				.HomeStreet(homeStreet)
				.HomeStreet2(homeStreet2)
				.HomeCity(homeCity)
				.HomeState(homeState)
				.HomeZip(homeZip)
				.MailingStreet(mailingStreet2)
				.MailingStreet2(mailingStreet2)
				.MailingCity(mailingCity)
				.MailingState(mailingState)
				.MailingZip(mailingZip)
				.MobilePhone(mobilePhone)
				.Email(email)
				.build();
		// @formatter:on

	}
	private SqlParams generateInsertSql(String lastName, String firstName, String homeStreet, String homeStreet2,
			String homeCity, String homeState, Long homeZip, String mailingStreet, String mailingStreet2,
			String mailingCity, String mailingState, Long mailingZip, String mobilePhone, String email) {

		// @formatter:off
		String sql = ""
				+ "INSERT INTO Handlers ("
				+ "LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email"
				+ ") VALUES ("
				+ ":LastName, :FirstName, :HomeStreet, :HomeStreet2, :HomeCity, :HomeState, :HomeZip, :MailingStreet, :MailingStreet2, :MailingCity, :MailingState, :MailingZip, :MobilePhone, :Email"
				+ ")";
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("LastName", lastName);
		params.source.addValue("FirstName", firstName);
		params.source.addValue("HomeStreet", homeStreet);
		params.source.addValue("HomeStreet2", homeStreet2);
		params.source.addValue("HomeCity", homeCity);
		params.source.addValue("HomeState", homeState);
		params.source.addValue("HomeZip", homeZip);
		params.source.addValue("MailingStreet", mailingStreet);
		params.source.addValue("MailingStreet2", mailingStreet2);
		params.source.addValue("MailingCity", mailingCity);
		params.source.addValue("MailingState", mailingState);
		params.source.addValue("MailingZip", mailingZip);
		params.source.addValue("MobilePhone", mobilePhone);
		params.source.addValue("Email", email);
		
		return params;
		
		
	}
	@Override
	public Handler updateHandlerPhone(Long idHandlers, String mobilePhone) {
		SqlParams params = generateInsertSql(idHandlers, mobilePhone);
		
		// KeyHolder keyHolder = new GeneratedKeyHolder();
		
		// jdbcTemplate.update(params.sql, params.source, keyHolder);
		jdbcTemplate.update(params.sql, params.source);
		
		// Long handlerPK = keyHolder.getKey().longValue();

		// @formatter:off
		return Handler.builder()
				.idHandlers(idHandlers)
				.MobilePhone(mobilePhone)
				.build();
		// @formatter:on

	}
	private SqlParams generateInsertSql(Long idHandlers, String mobilePhone) {

		// @formatter:off
		String phone = "MobilePhone";
		String sql = ""
				+ "UPDATE Handlers "
				+ "SET " + phone + " = :MobilePhone "
				+ "WHERE idHandlers = :idHandlers";

		log.debug("Update SQL={}", sql);
		
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("idHandlers", idHandlers);
		params.source.addValue("MobilePhone", mobilePhone);
		
		return params;
		
		
	}
	@Override
	public Optional<Handler> deleteHandler(Long idHandlers) {
		

		
		
		SqlParams params = generateInsertSql(idHandlers);
		
		int test = jdbcTemplate.update(params.sql, params.source);
		// if we deleted 0 rows, throw a 404 exception.
		if (test == 0) {
			log.debug("Time to throw an exception");
			throw new NoSuchElementException();
		}
		// @formatter:off
		return Optional.ofNullable(Handler.builder()
				.idHandlers(idHandlers)
				.build());
		// @formatter:on

	}
	private SqlParams generateInsertSql(Long idHandlers) {

		// @formatter:off
		String sql = ""
				+ "DELETE FROM Handlers "
				+ "WHERE idHandlers = :idHandlers";

		log.debug("Delete SQL={}", sql);
		
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("idHandlers", idHandlers);

		// another place to check for idHandlers.isNull()

		
		return params;
	}
}
// class SqlParams {
// 	  String sql;
// 	  MapSqlParameterSource source = new MapSqlParameterSource();
// }