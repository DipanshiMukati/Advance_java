package in.co.Sun;

public class SunTest {
	public static void main(String[] args) throws Exception {
//		testAdd();
		testupdate();
	}

	private static void testupdate() throws Exception {
		  SunBean bean = new SunBean();
		     bean.setId(50);
		     bean.setName("ansh");
		     bean.setMaths(86);
		     
		     SunModal modal = new SunModal(); 
		     modal.update(bean);
			
		}
		
	

	private static void testAdd() throws Exception {
	     SunBean bean = new SunBean();
	     bean.setId(10);
	     bean.setName("ansh");
	     bean.setMaths(80);
	     
	     SunModal modal = new SunModal(); 
	     modal.add(bean);
		
	}
}
