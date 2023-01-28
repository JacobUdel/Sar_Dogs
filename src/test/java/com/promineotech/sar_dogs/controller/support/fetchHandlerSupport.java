package com.promineotech.sar_dogs.controller.support;

import java.util.LinkedList;
import java.util.List;

import com.promineotech.sar_dogs.entity.Handler;

public class fetchHandlerSupport extends baseTest {
	protected List<Handler> buildExpected() {
		List<Handler> list = new LinkedList<> ();
		// @formatter:off
		list.add(Handler.builder()
				.idHandlers((long) 1)
				.LastName("Ableton")
				.FirstName("Abe")
				.HomeStreet("123 Main Street")
				.HomeStreet2("Apt 23")
				.HomeCity("Longmont")
				.HomeState("Colorado")
				.HomeZip((long) 80555)
				.MailingStreet("123 Main Street")
				.MailingStreet2("Apt 23")
				.MailingCity("Longmont")
				.MailingState("Colorado")
				.MailingZip((long) 80555)
				.MobilePhone("970.123.4567")
				.Email("abe@gmail.com")
				.build());
		// @formatter:on
		//INSERT INTO Handlers (LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email) VALUES ('Ableton', 'Abe', '123 Main Street', 'Apt 23', 'Longmont', 'Colorado', 80555, '123 Main Street', 'Apt 23', 'Longmont', 'Colorado', 80555, '970.123.4567', 'abe@gmail.com');
		
		return list;
	}
}
