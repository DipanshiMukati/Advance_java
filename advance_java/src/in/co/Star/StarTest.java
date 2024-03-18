package in.co.Star;

import java.util.Iterator;
import java.util.List;

public class StarTest {

	public static void main(String[] args) throws Exception {

//		testadd();
//       testupdate();
//		testdelete();
//		testsearch();
//		testAuth();
//		findbypk();
		testAdd();
		
		
	}

	private static void testAdd() throws Exception {
		StarBean bean = new StarBean();
		
		bean.setName("shivam");
		bean.setMaths(76);
		StarModal modal = new StarModal();
		modal.Add(bean);

		
	}

	private static void findbypk() throws Exception {
		
		StarModal modal = new StarModal();
		StarBean bean = modal.findBypk(1);
		if(bean!= null) {
			System.out.println(bean.getId());
			System.out.print(bean.getName());
			System.out.println(bean.getMaths());
		}
		else {
			System.out.println("id is not found");
		}
	}

	private static void testAuth() throws Exception {
		StarModal modal = new StarModal();
		StarBean bean = modal.Auth(1);
		if(bean!= null) {
			System.out.println(bean.getId());
			System.out.print(bean.getName());
			System.out.println(bean.getMaths());
		}
	else {
		System.out.println("loginid & password is invalid...!!");
	}
		
	}

	private static void testsearch() throws Exception {
		StarBean bean = new StarBean();
		StarModal modal = new StarModal();
		List list = modal.search();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (StarBean) it.next();
			System.out.println(bean.getId());
			System.out.print(bean.getName());
			System.out.println(bean.getMaths());
		}
		

	}

	private static void testdelete() throws Exception {

		StarBean bean = new StarBean();
		bean.setId(58);
		StarModal modal = new StarModal();
		modal.delete(bean);

	}

	private static void testupdate() throws Exception {
		StarBean bean = new StarBean();
		bean.setId(1);
		bean.setName("santosh");
		bean.setMaths(76);
		StarModal modal = new StarModal();
		modal.update(bean);
	}

	private static void testadd() throws Exception {
		StarBean bean = new StarBean();
		bean.setId(1);
		bean.setName("Sandesh");
		bean.setMaths(85);

		StarModal modal = new StarModal();
		modal.add(bean);

	}

}