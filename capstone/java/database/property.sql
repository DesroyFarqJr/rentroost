BEGIN TRANSACTION;

DROP TABLE IF EXISTS property CASCADE;
DROP TABLE IF EXISTS landlord CASCADE;
DROP TABLE IF EXISTS property_landlord CASCADE;
DROP TABLE IF EXISTS tenant_unit CASCADE;
DROP TABLE IF EXISTS maintenance CASCADE;
DROP TABLE IF EXISTS tenant CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

DROP SEQUENCE IF EXISTS seq_landlord_id;
DROP SEQUENCE IF EXISTS seq_tenant_id;
DROP SEQUENCE IF EXISTS seq_property_id;
DROP SEQUENCE IF EXISTS seq_employee_id;

CREATE SEQUENCE seq_landlord_id
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;

CREATE SEQUENCE seq_tenant_id
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;

CREATE SEQUENCE seq_property_id
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;

CREATE SEQUENCE seq_employee_id
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;

CREATE TABLE property (
property_id serial NOT NULL,
prop_address varchar(200) NOT NULL,
rented BOOLEAN,
CONSTRAINT PK_property_id PRIMARY KEY (property_id)
);

CREATE TABLE landlord (
landlord_id serial NOT NULL,
landlord_name VARCHAR(200) NOT NULL,
landlord_email VARCHAR(200),
property_id INT NOT NULL,
CONSTRAINT PK_landlord_id PRIMARY KEY (landlord_id),
CONSTRAINT FK_properties FOREIGN KEY (property_id) REFERENCES property (property_id)
);

CREATE TABLE property_landlord (
property_id INT NOT NULL,
landlord_id INT NOT NULL,
PRIMARY KEY (property_id, landlord_id),
FOREIGN KEY (property_id) REFERENCES property (property_id),
FOREIGN KEY (landlord_id) REFERENCES landlord(landlord_id)
);

CREATE TABLE tenant_unit (
tenant_id serial NOT NULL,
property_id INT,
PRIMARY KEY (tenant_id, property_id),
FOREIGN KEY (tenant_id) REFERENCES tenant(tenant_id),
FOREIGN KEY (property_id) REFERENCES property(property_id)
);

CREATE TABLE maintenance (
maintenance_id serial NOT NULL,
property_id INT,
request varchar(300) NOT NULL,
assigned_to INT,
repair_status VARCHAR(255) NOT NULL,
PRIMARY KEY (maintenance_id),
FOREIGN KEY (property_id) REFERENCES property (property_id),
FOREIGN KEY (assigned_to) REFERENCES employee(employee_id)
);

CREATE TABLE employee (
  employee_id serial NOT NULL,
  employee_name varchar(200) ,
  CONSTRAINT PK_employee_id PRIMARY KEY (employee_id),
);

CREATE TABLE tenant (
  tenant_id serial NOT NULL,
  tenant_name VARCHAR(200) NOT NULL,
  phone VARCHAR(12) NOT NULL,
  email VARCHAR(200) NOT NULL,
  rent_amount INT NOT NULL,
  paid BOOLEAN,
  move_in_date DATE,
  	CONSTRAINT PK_tenant_id PRIMARY KEY (tenant_id),
);

-- INSERT INTO shelter (shelter_name, shelter_address, shelter_city, shelter_state, shelter_zip) VALUES ('Snoopy"s Home For Dogs', '123 Brown St.', 'Pinetree Corners', 'Minnesota', '55101');

-- INSERT INTO puppy (puppy_name, puppy_breed, puppy_age, puppy_gender, shelter_id) VALUES ('Snoopy', 'Beagle', 7, 'Male', 1);

COMMIT TRANSACTION;