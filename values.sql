INSERT INTO Handlers (LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email) VALUES ('Ableton', 'Abe', '123 Main Street', 'Apt 23', 'Longmont', 'Colorado', 80555, '123 Main Street', 'Apt 23', 'Longmont', 'Colorado', 80555, '970.123.4567', 'abe@gmail.com');

INSERT INTO Handlers (LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email) VALUES ('Bolton', 'Betsy', '66 Maple Lane', null, 'Fort Collins', 'Colorado', 80525, '66 Maple Lane', null, 'Fort Collins', 'Colorado', 80525, '970.234.5678', 'betsy@gmail.com');

INSERT INTO Handlers (LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email) VALUES ('Conners', 'Carl', '21 Jump Street', 'Apt 5', 'Fort Collins', 'Colorado', 80526, '21 Jump Street', 'Apt 5', 'Fort Collins', 'Colorado', 80526, '970.345.6789', 'carl@gmail.com');

INSERT INTO Handlers (LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email) VALUES ('Dalton', 'Debbie', '423 Yellowbrick Road', null, 'Longmont', 'Colorado', 80555, '100 Hover Street', 'Suite 3-213', 'Longmont', 'Colorado', 80555, '970.987.6543', 'debbie@gmail.com');

INSERT INTO Handlers (LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email) VALUES ('Edwards', 'Earl', '13 Mockingbird Lane', 'Apt 13', 'Loveland', 'Colorado', 80558, '13 Mockingbird Lane', 'Apt 13', 'Loveland', 'Colorado', 80558, '970.876.5432', 'earl@gmail.com');





INSERT INTO Canines (Name, Breed, Sex, Birthdate, Handlers_idHandlers) VALUES ('Doc' ,'Lab' , 'Female', '2011-01-11', 1);

INSERT INTO Canines (Name, Breed, Sex, Birthdate, Handlers_idHandlers) VALUES ('Grumpy' ,'GSD' , 'Male', '2012-02-12', 2);

INSERT INTO Canines (Name, Breed, Sex, Birthdate, Handlers_idHandlers) VALUES ('Happy' ,'Aussie' , 'Female', '2013-03-13', 3);

INSERT INTO Canines (Name, Breed, Sex, Birthdate, Handlers_idHandlers) VALUES ('Sleepy' ,'Bourder Collie' , 'Male', '2014-04-14', 4);

INSERT INTO Canines (Name, Breed, Sex, Birthdate, Handlers_idHandlers) VALUES ('Bashful' ,'Lab' , 'Female', '2015-05-15', 4);

INSERT INTO Canines (Name, Breed, Sex, Birthdate, Handlers_idHandlers) VALUES ('Sneezy' ,'GSD' , 'Male', '2016-06-16', 5);

INSERT INTO Canines (Name, Breed, Sex, Birthdate, Handlers_idHandlers) VALUES ('Dopey' ,'Aussie' , 'Female', '2017-07-17', 5);


insert into certifications (Agency, Certification) values ('NASAR', 'Trailing Type I');
insert into certifications (Agency, Certification) values ('NASAR', 'Air Scent Type I');
insert into certifications (Agency, Certification) values ('NASAR', 'HRD Type I');
insert into certifications (Agency, Certification) values ('SARDOC', 'Trailing Type I');
insert into certifications (Agency, Certification) values ('SARDOC', 'Air Scent Type I');
insert into certifications (Agency, Certification) values ('SARDOC', 'HRD Type I');
insert into certifications (Agency, Certification) values ('SARDUS', 'Trailing Type I');
insert into certifications (Agency, Certification) values ('SARDUS', 'Air Scent Type I');
insert into certifications (Agency, Certification) values ('SARDUS', 'HRD Type I');

insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (1,1);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (3,1);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (5,2);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (6,2);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (4,3);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (7,4);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (8,5);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (9,5);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (7,6);
insert into certifications_has_canines (Certifications_idCertifications, Canines_idCanines) values (9,7);
