import static org.junit.Assert.fail;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongo.api.Blog;
import com.mongo.api.User;
import com.mongo.data.MongoUserDAO;
import com.mongo.rest.AppController;
import com.mongodb.MongoClient;

public class TestAddUser {

	public TestAddUser() {
		// TODO Auto-generated constructor stub
	}
	
	MongoClient mongoClient = null;
	Morphia morphia  = null;
	Datastore datastore = null;
	
	@Before
	public void setup()
	{
		
		 this.mongoClient = new MongoClient("127.0.0.1:27017");
		 this.morphia = new Morphia();
		 String databaseName = "Users";
		 this.datastore = morphia.createDatastore(mongoClient, databaseName);	
	}
	
	@After
	public void teardown()
	{
		
	}
	
	@Test
	public void TestAddUser_valid()
	{
		AppController a = new AppController();
		User u = new User();
		u.setUsername("sankar");
		u.setPassword("password");
		try {
		a.registerUser(u);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void TestloginUser_valid(){
		AppController a = new AppController();
		User u = new User();
		u.setUsername("sankars");
		u.setPassword("password");
		try {
		Response r = a.loginUser(u);
		assert(r.getStatus() == 200);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail();
		}
	
	}
	
	@Test
	public void testAddBlog()
	{
		MongoUserDAO udao = new MongoUserDAO(User.class, datastore);
		Blog b = new Blog();
		b.setTitle("Hello world1");
		b.setBlog("This is something big");
		try {
			udao.addBlog(b);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			fail();
			
		}
		
	}

}
