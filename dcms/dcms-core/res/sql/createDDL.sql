CREATE TABLE dcms_child (
    id INTEGER(10) AUTO_INCREMENT NOT NULL,
    affliation INTEGER(2),
    dob DATE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    middle_name VARCHAR(50),
    note VARCHAR(255),
    phone VARCHAR(50),
    slibling_id INTEGER(10),
    active_enrollment INTEGER(1),
    PRIMARY KEY (id)
);
CREATE TABLE dcms_teacher (
    id INTEGER(10) AUTO_INCREMENT NOT NULL,
    name VARCHAR(100),
    fri_time VARCHAR(255),
    mon_time VARCHAR(255),
    thu_time VARCHAR(255),
    tue_time VARCHAR(255),
    wed_time VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE dcms_waitinglist (
    id INTEGER(10) AUTO_INCREMENT NOT NULL,
    application_date DATE,
    attending_mode VARCHAR(50),
    customized_sequence INTEGER(10),
    desire_date DATE,
    expect_grade INTEGER(1),
    note VARCHAR(255),
    offered_date DATE,
    status VARCHAR(20),
    display_status VARCHAR(20),
    child INTEGER(10),
    PRIMARY KEY (id)
);
CREATE TABLE dcms_enrollment (
    id INTEGER(10) AUTO_INCREMENT NOT NULL,
    accept_date DATE,
    attending_mode VARCHAR(50),
    contract_from_date DATE,
    contract_to_date DATE,
    contract_from DATE,
    status VARCHAR(20),
    fri_time VARCHAR(255),
    mon_time VARCHAR(255),
    thu_time VARCHAR(255),
    tue_time VARCHAR(255),
    wed_time VARCHAR(255),
    child_id INTEGER(10),
    classroom_id INTEGER(10),
    PRIMARY KEY (id)
);
CREATE TABLE dcms_classroom (
    id INTEGER(10) AUTO_INCREMENT NOT NULL,
    capacity INTEGER(5),
    grade INTEGER(2),
    name VARCHAR(100),
    term VARCHAR(50),
    student_num INTEGER(5),
    age_from INTEGER(5),
    age_to INTEGER(5),
    PRIMARY KEY (id)
);
CREATE TABLE dcms_event_log (
    id INTEGER(10) AUTO_INCREMENT NOT NULL,
    event VARCHAR(255),
    event_date DATETIME,
    note VARCHAR(255),
    child_id INTEGER,
    PRIMARY KEY (id)
);
CREATE TABLE dcms_child_contact (
    address VARCHAR(255),
    email VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    middle_name VARCHAR(255),
    note VARCHAR(255),
    phone1 VARCHAR(255),
    phone2 VARCHAR(255),
    role VARCHAR(30),
    status VARCHAR(30),
    child_id INTEGER(10),
    PRIMARY KEY (child_id, role)
);
CREATE TABLE dcms_classroom_teacher (
    teacher_id INTEGER(10) NOT NULL,
    classroom_id INTEGER(10) NOT NULL,
    PRIMARY KEY (teacher_id , classroom_id)
);
ALTER TABLE dcms_child ADD CONSTRAINT FK_dcms_child_active_enrollment FOREIGN KEY (active_enrollment) REFERENCES dcms_enrollment (id);
ALTER TABLE dcms_waitinglist ADD CONSTRAINT FK_dcms_waitinglist_child FOREIGN KEY (child) REFERENCES dcms_child (id);
ALTER TABLE dcms_enrollment ADD CONSTRAINT FK_dcms_enrollment_classroom_id FOREIGN KEY (classroom_id) REFERENCES dcms_classroom (id);
ALTER TABLE dcms_enrollment ADD CONSTRAINT FK_dcms_enrollment_child_id FOREIGN KEY (child_id) REFERENCES dcms_child (id);
ALTER TABLE dcms_event_log ADD CONSTRAINT FK_dcms_event_log_child_id FOREIGN KEY (child_id) REFERENCES dcms_child (id);
ALTER TABLE dcms_child_contact ADD CONSTRAINT FK_dcms_child_contact_child_id FOREIGN KEY (child_id) REFERENCES dcms_child (id);
ALTER TABLE dcms_classroom_teacher ADD CONSTRAINT FK_dcms_classroom_teacher_classroom_id FOREIGN KEY (classroom_id) REFERENCES dcms_classroom (id);
ALTER TABLE dcms_classroom_teacher ADD CONSTRAINT FK_dcms_classroom_teacher_teacher_id FOREIGN KEY (teacher_id) REFERENCES dcms_teacher (id);
