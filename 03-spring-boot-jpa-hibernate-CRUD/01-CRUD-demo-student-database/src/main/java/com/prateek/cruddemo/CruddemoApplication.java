package com.prateek.cruddemo;

import com.prateek.cruddemo.dao.StudentDAO;
import com.prateek.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//Entity class is a Java class that is mapped to a database table via Object to Relational Mapping (ORM)
//An entity class must be annotated with @Entity, Must have one public or protected no-argument constructor, class can also have other constructors

//In Java if you don't declare any constructors Java will provide a no-argument constructor for free. But if you declare constructors with arguments then you do not get a no-argument constructor for free. In the latter case you have to explicitly declare a no-argument constructor.
//With Java annotations, we have 2 steps for ORM mapping- 1. Map class to database table with @Table(name="student"), 2. Map fields to database columns using @Column(name="id") for private int id field
//Actually, the use of @Column is optional. If not specified, the column name is the same name as Java field. But this is not recommended since if you refractor the field name in Java code then it will not match existing database columns. This is a breaking change and you will need to update the database column
//If @Table name is not specified, the table name is same as the class. This is also not recommended

//A primary key uniuely identifies each row in a table. It must be a unique value and cannot contain NULL values.
//We make use of AUTO_INCREMENT in MySQL for primary key. For example in SQL,
/*
CREATE TABLE student(
	id int NOT NULL AUTO_INCREMENT,
	first_name varchar(45) DEFAULT NULL,
	last_name varchar(45) DEFAULT NULL,
	email varchar(45) DEFAULT NULL,
	PRIMARY KEY (id)
)
primary key is specified at the end saying that this is the primary key for the given table
*/

/*
	In JPA we make use of @Id and @GeneratedValue(strategy=GenerationType.IDENTITY). This says the value id will be generated by the database and managed by the database. For example,
	@Entity
	@Table(name="student")
	public class Student{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;

		...
	}
 */


/*
	ID Generation Strategies:
	GenerationType.AUTO - Pick an appropriate strategy for the particular database
	GenerationType.IDENTITY - Assign primary keys using database identity column. This is recommended and covers most cases
	GenerationType.SEQUENCE - Assign primary keys using a database sequence
	GenerationType.TABLE - Assign primary keys using an underlying database table to ensure uniqueness


 	If any of these that JPA provides donot match your requirements, you can create a CUSTOM generation strategy
 	For that create an implementation of org.hibernate.id.IdentifierGenerator interface
 	Override the method: public Serializable generate(..) and write your logic inside

 */

/*
	Spring provides @Transactional annotation. When a method is marked @Transactional spring does the work behind the scenes for transaction management.
	Spring provides @Repository annotation which is a sub annotation of @Component for DAOs and repositories. This provides support for component scanning and translates JDBC exceptions.
 */

/*To display the entries in database run-
	sudo mysql
	SELECT * FROM student_tracker.student;

	To start AUTO_INCREMENT from a specific value run the query-
	ALTER TABLE student_tracker.student AUTO_INCREMENT=3000;

	To remove all entries from the database(Also resets AUTO_INCREMENT to 1), use-
	TRUNCATE student_tracker.student;

 */


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		//Retrieve Student based on id: primary key
		int target_id = 1;
		System.out.println("Fetching student with id: " + target_id);
		Student theStudent = studentDAO.findById(target_id);

		//Change firstName to "Paulson" (It was Paul previously)
		theStudent.setFirstname("Paulson");

		//Update the student
		studentDAO.update(theStudent);

		//Display the updated student
		System.out.println("Student updated to " + theStudent.toString());
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> finalResults = studentDAO.findByLastName("Doe");

		for (Student theStudent : finalResults){
			System.out.println(theStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		
		//display that list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Maria", "Deebee", "mariadb@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		//retrieve student based on id: primary key
		System.out.println("Retrieving student with id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		//display student
		System.out.println("Found the student : " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Jon", "Doe", "doe@gmail.com");
		Student tempStudent2 = new Student("Steve", "jobs", "jobs@gmail.com");
		Student tempStudent3 = new Student("Phil", "Knight", "knight@gmail.com");

		//save the student objects
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student1. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student2. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student3. Generated id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Maria", "Deebee", "mariadb@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	//To retrieve/read from database using the primary key, (if 1 is the primary key we want to search)
	//Student myStudent = entityManager.find(Student.class, 1);
}
