package io.ayoue.common.tools.test.proxy;

import java.lang.reflect.Proxy;

public class MyDynamicProxy {
	public static void main(String[] args) {
		HelloImpl hello = new HelloImpl();
		MyInvocationHandler handler = new MyInvocationHandler(hello);
		Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);
		proxyHello.sayHello();
	}
}

