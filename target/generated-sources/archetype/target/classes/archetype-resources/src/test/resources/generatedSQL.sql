create table Course (
	courseId integer generated by default as identity (start with 1), 
	courseName varchar(255) not null, 
	primary key (courseId))
	
create table Student (
	studentId integer generated by default as identity (start with 1), 
	studentDateOfBirth timestamp, 
	studentName varchar(255) not null, 
	primary key (studentId))
	

create table STUDENT_COURSE (
	C_ID integer not null, 
	STU_ID integer not null, 
	primary key (C_ID, STU_ID))

	
	
	
	
	
create table Car (
        carId integer generated by default as identity (start with 1),
        make varchar(255) not null,
        student_studentId integer,
        primary key (carId)
    )

    
    
    
 select
        student0_.studentId as studentId0_1_,
        student0_.studentDateOfBirth as studentD2_0_1_,
        student0_.studentName as studentN3_0_1_,
        student0_.studentlastname as studentl4_0_1_,
        courses1_.STU_ID as STU1_0_3_,
        course2_.courseId as C2_3_,
        course2_.courseId as courseId2_0_,
        course2_.courseName as courseName2_0_ 
    from
        Student student0_ 
    left outer join
        STUDENT_COURSE courses1_ 
            on student0_.studentId=courses1_.STU_ID 
    left outer join
        Course course2_ 
            on courses1_.C_ID=course2_.courseId 
    where
        student0_.studentId=?    