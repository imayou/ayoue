package io.ayoue.common.tools.test.proxy;

public class HelloImpl implements Hello{
	@Override
	public void sayHello() {
		System.err.println("Hello Proxy");
	}
}
