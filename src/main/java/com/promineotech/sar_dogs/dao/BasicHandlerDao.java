package com.promineotech.sar_dogs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
			String homeCity, String homeState, int homeZip, String mailingStreet, String mailingStreet2,
			String mailingCity, String mailingState, int mailingZip, String mobilePhone, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
