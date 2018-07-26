package io.ayoue.admin.site.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.ayoue.admin.site.bo.Order;
import io.ayoue.admin.site.bo.OrderItem;
import io.ayoue.admin.site.repository.OrderItemRepository;
import io.ayoue.admin.site.repository.OrderRepository;

@Service
public class DemoService {
	@Resource
	private OrderRepository orderRepository;

	@Resource
	private OrderItemRepository orderItemRepository;

	public void demo() {
		List<Long> orderIds = new ArrayList<>(10);
		List<Long> orderItemIds = new ArrayList<>(10);
		System.out.println("1.Insert--------------");
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setUserId(51);
			order.setStatus("INSERT_TEST");
			long orderId = orderRepository.save(order).getOrderId();
			orderIds.add(orderId);
			OrderItem item = new OrderItem();
			item.setOrderId(orderId);
			item.setUserId(51);
			orderItemIds.add(orderItemRepository.save(item).getOrderItemId());
		}
		List<OrderItem> orderItems = orderItemRepository.findAll();
		System.err.println(orderItemRepository.findAll());
		System.out.println("2.Delete--------------");
		if (orderItems.size() > 0) {
			for (Long each : orderItemIds) {
				orderItemRepository.delete(each);
			}
			for (Long each : orderIds) {
				orderRepository.delete(each);
			}
		}
		System.err.println(orderItemRepository.findAll());
	}
}
