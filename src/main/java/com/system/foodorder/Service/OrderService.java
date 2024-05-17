package com.system.foodorder.Service;

import com.system.foodorder.Entity.Order;
import com.system.foodorder.Exceptions.PiloteNumberException;
import com.system.foodorder.Repository.ConfigurationParamsRepository;
import com.system.foodorder.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private final ConfigurationParamsRepository configurationParamsRepository;

    public Order createOrder(Order order){
        validatePilatesNumber(order);
        return orderRepository.save(order);
    }

    private void validatePilatesNumber(Order order){
        if(!order.isRightPilotasNumber(configurationParamsRepository.findValues())){
            throw new PiloteNumberException();
        }
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id){
        orderRepository.existsById(id);
    }

    public Order updateOrder(Long id, Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setPilotesNumber(order.getPilotesNumber());
            existingOrder.setDeliveryAddress(order.getDeliveryAddress());
            existingOrder.setEmail(order.getEmail());
            return orderRepository.save(existingOrder);
        } else {
            throw new RuntimeException("Order not found with id: " + id);
        }
    }

}
