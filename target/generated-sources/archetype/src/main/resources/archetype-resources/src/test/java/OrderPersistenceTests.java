#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ${package}.mtm.Car;
import ${package}.mtm.Course;
import ${package}.mtm.Student;
import ${package}.repositories.CustomerRepository;
import ${package}.repositories.OrderRepository;
import ${package}.repositories.ProductRepository;
import ${package}.repositories.mtm.CarRepository;
import ${package}.repositories.mtm.CourseRepository;
import ${package}.repositories.mtm.StudentRepository;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OrderPersistenceTests {

	/*@PersistenceContext
	private EntityManager entityManager;
*/
	//@Autowired
	ProductRepository productRepository;
	
//	@Autowired
	CustomerRepository customerRepository;
	
	//@Autowired 
	OrderRepository orderRepository;
	
	@Autowired LocalContainerEntityManagerFactoryBean fb;
	
	
	@Autowired 
	StudentRepository studentRepository;
	
	@Autowired 
	CarRepository carRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Before
	public void setUp()
	{
		Student s1 = new Student("student1", new Date());
		s1.setStudentlastname("lastname1");
		
		Car car1 = new Car("bmw");
		Car car2 = new Car("fiat");
		Car car3 = new Car("golf");
		//exportSchema();
		
		car1.setStudent(s1);
		car2.setStudent(s1);
		car3.setStudent(s1);
		
		/*carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);*/
		
		s1.getCars().add(car1);
		s1.getCars().add(car2);
		s1.getCars().add(car3);
		studentRepository.save(s1);
		//car1.setStudent(s1);
		//s1.getCars().add(car1);
		//carRepository.save(car1);
		/*car2.setStudent(s1);
		car3.setStudent(s1);*/
		
		
		/*carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);
		*/
		
		
	//	Course c1 = new Course("course1");
		
		//s1.getCourses().add(c1);
		
		//System.out.println("STUDENT ID =  "+studentRepository.findAll().iterator().next().getStudentId());
		/*Student s2 = new Student("student2", new Date());
		s2.setStudentlastname("lastname2");
		Student s3 = new Student("student3", new Date());
		s3.setStudentlastname("lastname22");*/
		

		/*System.out.println("UPDATING STUDENT");
		s1.getCars().add(car1);
		s1.getCars().add(car2);
		s1.getCars().add(car3);*/
		
		//System.out.println("BEFORE ---- student: "+s1.getStudentName()+" has :"+s1.getCars().size()+" cars");
		
		//studentRepository.save(s1);
		//System.out.println("saving cars");
		
		
		
		
	//	studentRepository.save(s2);
		//studentRepository.save(s3);
		
	
		
		//Student s1 = new Student("student1", new Date());
		/*Course c1 = new Course("course1");//generateCourse("course1");
		courseRepository.save(c1);
		System.out.println("SAVED COURSE");
		
		Student s1 = new Student("student1", new Date());	
		System.out.println("CREATED STUDENT");
		Set<Student> students = new HashSet<Student>();
		students.add(s1);
		System.out.println("ADDED STUDENT TO COURSE");
		c1.setStudents(students);
		System.out.println("UPDATED COURSE");
		courseRepository.save(c1);*/
		
		/*Set<Course> courses = new HashSet<Course>();
		courses.add(c1);
		
		
		s1.setCourses(courses);
		assertNotNull(s1.getCourses());
		
		
		
		studentRepository.save(s1);*/
		
		
		
		/*Customer c1 = generateCustomer("cust1@ok.com", "john", "lastname1");
		Customer c2 = generateCustomer("cust2@ok.com", "jim", "lastname2");
		Customer c3 = generateCustomer("cust3@ok.com", "john", "lastname3");
		
		Product p1 = generateProduct("product1","desc1",new Long(5));
		Product p2 = generateProduct("product2","desc2",new Long(10));
		Product p3 = generateProduct("product3","desc3",new Long(15));
		Product p4 = generateProduct("product4","desc4",new Long(20));
		
		Set<Product> customer1_products = new HashSet<Product>();
		customer1_products.add(p1);
		customer1_products.add(p2);
		
		Order customer1_order = new Order();
		customer1_order.setCustomer(c1);
		customer1_order.setProducts(customer1_products);
		customer1_order.setTotal(new Long(15));
		
		Set<Order> customer1_orders = new HashSet<Order>(); 
		customer1_orders.add(customer1_order);		
		p1.setOrders(customer1_orders);
		p2.setOrders(customer1_orders);
		c1.setOrders(customer1_orders);
		
		customerRepository.save(c1);
		*/
		//orderRepository.save(customer1_order);
		
		/*Set<Product> customer2_products = new HashSet<Product>();
		customer2_products.add(p3);
		customer2_products.add(p4);
		
		Order customer2_order = generateOrder(new Long(15), c2, customer2_products);
		Set<Order> customer2_orders = new HashSet<Order>(); 
		customer2_orders.add(customer2_order);
		c2.setOrders(customer2_orders);
		customerRepository.save(c2);
		*/
				
	}
	
	
	@Test
	public void testFindByStudentLastName()
	{
		Student s1 = studentRepository.findOne(1);
		assertTrue(s1.getCars().size()==3);
		System.out.println("s1 CARS IN DB "+s1.getCars().size());
		for (Car c : s1.getCars())
		{
			System.out.println("s1 CAR: "+c.getCarId()+" "+c.getMake()+" "+c.getStudent().getStudentlastname());
		}
		
		List<Car> carsByStudentLastName = carRepository.findByStudent_Studentlastname("lastname1");
		for (Car c : carsByStudentLastName)
		{
			System.out.println("lastname1 CAR: "+c.getCarId()+" "+c.getMake());
		}
		//System.out.println("EQWEQWEQWEWQEQE "+carsByStudentLastName==null);
		//assertTrue(carsByStudentLastName.isEmpty());
	}
	
	
	
	
	//@Test
	public void testQueryByMethodName()
	{
		System.out.println("TOTAL "+studentRepository.count() + " with id = "+studentRepository.findAll().iterator().next().getStudentId());
		
		Student s1 = studentRepository.findOne(1);
		System.out.println("student: "+s1.getStudentName()+" has :"+s1.getCars().size()+" cars");
	//	System.out.println(carRepository.count()+" cars");
		
		/*System.out.println(carRepository.count()+" cars and "+studentRepository.count()+" students ");
		
		
		//System.out.println(studentRepository.findOne(1).getStudentName()+"  ----  "+carRepository);
		Student s1 = studentRepository.findOne(1);
		Iterable<Car> c = carRepository.findAll();
		List<Car> cars = new ArrayList<Car>();
		for (Car car : c)
		{
			System.out.println(car.getStudent().getStudentName());
		}
		System.out.println("student: "+s1.getStudentName()+" has :"+s1.getCars().size()+" cars");
		System.out.println(cars.size());*/
		//List<Student> students = studentRepository.findByStudentlastnameLikeAndStudentNameNotLike("lastname2","1");
		//System.out.println("students by surname retrieved: "+students.size());
	}
	
	//@Test
	public void testDeleteStudent()
	{
		Student s1 = studentRepository.findAll().iterator().next();
		
		System.out.println("student.getCourse BEFORE: "+s1.getCourses().iterator().next().getCourseName());
		
		Course c1 = courseRepository.findOne(1);
		assertNotNull(c1);
		System.out.println("Course.getCourse BEFORE: "+c1.getCourseName());
		
		//courseRepository.delete(c1);
		studentRepository.delete(s1);
		System.out.println("deleting student");
		System.out.println("AFTER: student.getStudent = "+studentRepository.findOne(1));
		System.out.println("AFTER: course.getCourse = "+courseRepository.findOne(1).getCourseName());
		System.out.println("AFTER: course.getStudent = "+courseRepository.findOne(1).getStudents().size());
	}
	
	//@Test
	public void testDeleteCourse()
	{
		Student s1 = studentRepository.findAll().iterator().next();
		
		System.out.println();
		
		System.out.println("student.getCourse BEFORE: "+s1.getCourses().iterator().next().getCourseName());
		
		Course c1 = courseRepository.findOne(1);
		assertNotNull(c1);
		System.out.println("Course.getCourse BEFORE: "+c1.getCourseName());
		
		s1.getCourses().clear();
		courseRepository.delete(c1);
		//studentRepository.delete(s1);
		System.out.println("deleting course");
		System.out.println("AFTER: student.getStudent = "+studentRepository.findOne(1).getStudentName());
		System.out.println("AFTER: student.getCourse = "+studentRepository.findOne(1).getCourses().size());
		System.out.println("AFTER: course.getCourse = "+courseRepository.exists(1));
		//System.out.println("AFTER: course.getStudent = "+courseRepository.findOne(1).getStudents().size());
	}
	
	//@Test
	public void testFindProductsByName()
	{
		
//		System.out.println("STUDENTS"+studentRepository.count() + " with id = "+studentRepository.findAll().iterator().next().getStudentId());
		Student s1 = studentRepository.findOne(2);
		Iterable<Car> c = carRepository.findAll();
		List<Car> cars = new ArrayList<Car>();
		for (Car car : c)
		{
			s1.getCars().add(car);
		}
		studentRepository.save(s1);
		//studentRepository.count();
		Student s2 = studentRepository.findOne(2);
		Set<Car> carss = s2.getCars();
		System.out.println("STUDENT CARS = "+carss.size());
		//System.out.println(s2.getCars().size());
		/*Set<Car> cars = s2.getCars();
		System.out.println("CARS = "+cars.size());
		*//*for (Car c : cars)
		{
			System.out.println("CAR: "+c.getCarId()+" "+c.getMake());
		}*/
		/*Iterable<Car> c = carRepository.findAll();
		List<Car> cars = new ArrayList<Car>();
		for (Car car : c)
		{
			System.out.println("CAR: "+car.getCarId()+" "+car.getMake());
		}*/
		//exportSchema();
		
		//assertEquals(1,customerRepository.findOne(new Long(1)).getOrders().size());
		//assertEquals(2,customerRepository.findOne(new Long(1)).getOrders().iterator().next().getProducts().size());
		
		//Pageable pageable = new PageRequest(0, 1, Direction.DESC, "productName");
		//select count(product0_.productId) as col_0_0_ from Product product0_ where product0_.productName=?
	//	Page<Product> page = productRepository.findByProductName("product1", null);
		//assertEquals(page.getContent().size(), 1);
		//assertTrue("product1".equals(page.getContent().get(0).getProductName()));
		
		//productRepository.findByProductName("product1", null);
	}
	
	
	private Student generateStudent(String studentName)
	{
		Student student = new Student(studentName, new Date());
		return studentRepository.save(student);
		
	}
	
	private Course generateCourse(String courseName)
	{
		Course course = new Course(courseName);
		return courseRepository.save(course);
		
	}
	
	private void exportSchema()
	{
		org.hibernate.ejb.Ejb3Configuration cfg = new org.hibernate.ejb.Ejb3Configuration();
		org.hibernate.ejb.Ejb3Configuration configured =     
		                 cfg.configure(fb.getPersistenceUnitInfo(), fb.getJpaPropertyMap()); org.hibernate.tool.hbm2ddl.SchemaExport schemaExport = 
		new org.hibernate.tool.hbm2ddl.SchemaExport(configured.getHibernateConfiguration());
		                 schemaExport.create(true, false);
	}
	
	private Product generateProduct(String name, String desc, Long price)
	{
		Product p = new Product();
		p.setPrice(price);
		p.setProductDescription(desc);
		p.setProductName(name);
		
		return productRepository.save(p);
	}

	private Customer generateCustomer(String emailAddress, String firstname, String lastname)
	{
		Customer c = new Customer();
		c.setEmailAddress(emailAddress);
		c.setFirstname(firstname);
		c.setLastname(lastname);

		return customerRepository.save(c);
	}
	
	
	private Order generateOrder(Long total,Customer customer,Set<Product> products)
	{
		Order order = new Order();
		order.setTotal(total);
		order.setCustomer(customer);
		order.setProducts(products);
		
		return orderRepository.save(order);
	
	}
	

}
