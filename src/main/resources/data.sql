INSERT INTO EVENT(name,type,release_date,description,duration,is_active) VALUES('Avatar','MOVIE','05-12-2022','Fantasy','2:40', true);
INSERT INTO EVENT(name,type,release_date,description,duration,is_active) VALUES('Top Gun','MOVIE','12-10-2022','Action','2:00', true);

INSERT INTO EVENT_PLACE(address, city, country, state, description, is_active, map_location, name, phone_number, type, zip)
VALUES('Gachibowli', 'Hyderabad', 'India', 'Telangana', 'Multiplex', true, 'maplocation', 'PVR: Gachibowli', 9876543210, 'THEATRE', 500010);

INSERT INTO EVENT_PLACE(address, city, country, state, description, is_active, map_location, name, phone_number, type, zip)
VALUES('Ameerpet', 'Hyderabad', 'India', 'Telangana', 'Multiplex', true, 'maplocation', 'PVR: Ameerpet', 9876543210, 'THEATRE', 500040);

INSERT INTO EVENT_PLACE(address, city, country, state, description, is_active, map_location, name, phone_number, type, zip)
VALUES('Saket', 'Delhi', 'India', 'Delhi', 'Multiplex', true, 'maplocation', 'Cineplex: Saket', 9876543210, 'THEATRE', 110001);

INSERT INTO EVENT_PLACE(address, city, country, state, description, is_active, map_location, name, phone_number, type, zip)
VALUES('CP', 'Delhi', 'India', 'Delhi', 'Multiplex', true, 'maplocation', 'Cineplex: cp', 9876543210, 'THEATRE', 110001);

INSERT INTO USER_INFO(name, email, dob, is_active) VALUES('Madhur', 'madhur@gmail.com','12-11-1981',true);
INSERT INTO USER_INFO(name, email, dob, is_active) VALUES('Manu', 'manu@gmail.com','07-08-1982',true);