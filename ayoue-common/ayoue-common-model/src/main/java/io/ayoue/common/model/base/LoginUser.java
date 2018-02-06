package io.ayoue.common.model.base;

import java.util.Optional;

/**
 * 用户登录信息
 * 目前有redis
 * 后期有CAS或者OAuth...
 */
public interface LoginUser {
	/**
	 * 取当前登录用户信息
	 * @return Optional<Object>
	 */
	public Optional<Object> get();

	/**
	 * 将当前登录用户信息放到session，session经过redis同步分发到各系统，所以每个系统都可以获取到
	 * @return boolean
	 */
	public boolean set(byte[] user);
	
	/**
	 * 移除当前登录信息，注销功能
	 * @return boolean
	 */
	public boolean destroy();
	
	/**
	 * 返回一个当前请求信息
	 */
	public Object getRequest();
}
