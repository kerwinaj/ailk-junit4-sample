package com.ailk.test.hamcrest.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a>
 * @description <pre>
 * 	ExternalResource Rule:
 * 
 * </pre>
 * @date 2013-1-14
 */
public class ExternalResourceRuleSample {
	Server myServer = new Server();
	@Rule
	public ExternalResource resource = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			myServer.connect();
		};

		@Override
		protected void after() {
			myServer.disconnect();
		};
	};

	@Test
	public void testFoo() {
		new Client("client_1").run(myServer);
	}

	@Test
	public void testFoo2() {
		new Client("client_2").run(myServer);
	}
}

class Server {
	public void connect() {
		System.out.println(this+"server connected");
	}

	public void disconnect() {
		System.out.println(this+"server disconnected");
	}
}

class Client {
	String name;
	
	public Client(String name) {
		this.name = name;
	}

	/**
	 * by_yuk:两次server的实例不一样,难道是一个@Test就会新建个Server(也即运行一次)
	 * @param server
	 */
	public void run(Server server) {
		System.out.println("client("+name+") running,server:"+server);
	}
}
