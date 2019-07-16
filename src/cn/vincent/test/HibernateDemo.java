package cn.vincent.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import cn.vincent.pojo.User;

public class HibernateDemo {

	public static void main(String[] args){
		//1、读取hibernate配置文件
				Configuration cfg = new Configuration().configure();
				//2、创建服务注册对象
				ServiceRegistry registry = new StandardServiceRegistryBuilder()
											.applySettings(cfg.getProperties())
											.build();
				//3、生成SessionFactory对象
				SessionFactory factory = cfg.buildSessionFactory(registry);
				//4、生成Session对象
				Session session = factory.openSession();
				//5、查询
				User user = (User)session.get(User.class, 2);
				System.out.println(user.getId()+"----"+user.getName()+"----"+user.getAge());
				//6、关闭session
				session.close();
				//在应用程序中sessionFactory不用关闭
				factory.close();
	}
}
