
package com.pizzamanagementsystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagementsystem.dto.PizzaOrderDTO;
import com.pizzamanagementsystem.entity.PizzaOrder;
import com.pizzamanagementsystem.exception.CustomerNotFoundException;
import com.pizzamanagementsystem.exception.PizzaNotFoundException;
import com.pizzamanagementsystem.exception.PizzaOrderNotFoundException;
import com.pizzamanagementsystem.repository.PizzaOrderRepository;
import com.pizzamanagementsystem.util.PizzaStatus;

@Service
public class IPizzaOrderServiceImpl implements IPizzaOrderService {
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	PizzaOrderRepository pizzaOrderRepository;

	/*
	 * To Convert Entity To DTO
	 */
	private PizzaOrderDTO convertEntityToDto(PizzaOrder po) {

		// with model Mapper
		PizzaOrderDTO newPizzaOrderDTO = modelMapper.map(po, PizzaOrderDTO.class);
		return newPizzaOrderDTO;
	}

	/*
	 * To Convert DTO to Entity
	 */
	private PizzaOrder convertDtoToEntity(PizzaOrderDTO piDTO) {
		PizzaOrder newPizzaOrder = modelMapper.map(piDTO, PizzaOrder.class);
		return newPizzaOrder;
	}

	/*
	 * Create a Pizza Order
	 */
	@Override
	public PizzaOrderDTO bookPizzaOrder(PizzaOrderDTO order) {
		PizzaOrder newPizzaOrder = convertDtoToEntity(order);
		pizzaOrderRepository.save(newPizzaOrder);
		// log.info("PizzaOrder:bookPizzaOrder called");
		return order;
	}

	/*
	 * Update the Pizza Order
	 */
	@Override
	public PizzaOrderDTO updatepizzaOrder(PizzaOrderDTO pizzaOrder, Integer userId) {

		Optional<PizzaOrder> pizzanew = pizzaOrderRepository.findById(userId);

		if (!pizzanew.isPresent()) {
			throw new PizzaOrderNotFoundException("Unable to Update PizzaOrder For:" + userId);
		} else {
			PizzaOrder obj = pizzanew.get();
			obj.setBookingOrderId(pizzaOrder.getBookingOrderId());
			obj.setDateOfOrder(pizzaOrder.getDateOfOrder());
			obj.setQuantity(pizzaOrder.getQuantity());
			obj.setTotalCost(pizzaOrder.getTotalCost());

			pizzaOrderRepository.save(obj);

			return pizzaOrder;

		}
	}

	/*
	 * Cancel Pizza Order
	 */
	@Override
	public PizzaOrderDTO cancelPizzaOrder(Integer pizzaId) {
		PizzaOrder deletedpizza = pizzaOrderRepository.findById(pizzaId).get();
		PizzaOrderDTO delOrderDTO = convertEntityToDto(deletedpizza);
		pizzaOrderRepository.delete(deletedpizza);

		return delOrderDTO;
	}

	/*
	 * View Order by Id
	 */
	@Override
	public PizzaOrderDTO viewPizzaOrderById(Integer pizzaOrderId) throws PizzaNotFoundException {
		Optional<PizzaOrder> newPizzaOrder = pizzaOrderRepository.findById(pizzaOrderId);

		if (!newPizzaOrder.isPresent()) {
			throw new PizzaNotFoundException("No pizza Order on orderId" + pizzaOrderId);
		}
		PizzaOrder newpizza = newPizzaOrder.get();
		PizzaOrderDTO newPizzaOrderdto = convertEntityToDto(newpizza);
		return newPizzaOrderdto;
	}

	/*
	 * View all Order
	 */
	@Override
	public List<PizzaOrderDTO> viewAllPizzaOrders() throws PizzaOrderNotFoundException {
		List<PizzaOrder> pizzaOrder = pizzaOrderRepository.findAll();
		if (pizzaOrder.size() == 0 || pizzaOrder == null) {

			throw new PizzaOrderNotFoundException("Pizza Orders Not Found ");
		} else {

			return pizzaOrder.stream().map(this::convertEntityToDto).collect(Collectors.toList());
		}
	}

	/*
	 * Customize methods
	 */

	/*
	 * View Pizza Order by Date//
	 */
	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date) throws PizzaNotFoundException {
		List<PizzaOrder> pizzaOrder = pizzaOrderRepository.findBydateOfOrder(date);
		if (pizzaOrder.size() == 0 || pizzaOrder == null) {
			throw new PizzaNotFoundException("No Orders on this Date");

		} else {
			return pizzaOrder.stream().map(this::convertEntityToDto).collect(Collectors.toList());

		}
	}

	/*
	 * View pizza Order by CustomerId
	 */
	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByCustomerId(Integer userId) throws PizzaOrderNotFoundException {
		List<PizzaOrder> pizzaOrder = (List<PizzaOrder>) pizzaOrderRepository.findByCustomerUserId(userId);
		if (pizzaOrder.size() == 0 || pizzaOrder == null) {
			throw new PizzaOrderNotFoundException("No pizzaOrder Available For :" + userId);
		}
		return pizzaOrder.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	/*
	 * View Pizza Order by Status
	 */
	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByStatus(PizzaStatus status) throws PizzaOrderNotFoundException {
		List<PizzaOrder> pizzaOrder = (List<PizzaOrder>) pizzaOrderRepository.findByStatus(status);
		if (pizzaOrder.size() == 0 || pizzaOrder == null) {
			throw new PizzaOrderNotFoundException("No Pizza For Status :" + status);
		}
		return pizzaOrder.stream().map(this::convertEntityToDto).collect(Collectors.toList());

	}

	/*
	 * View Pizza Order by Id and Status
	 */
	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByCustomerIdAndStatus(Integer userId, PizzaStatus status)
			throws CustomerNotFoundException {
		List<PizzaOrder> pizzaOrder = (List<PizzaOrder>) pizzaOrderRepository.findByCustomerUserIdAndStatus(userId,
				status);
		if (pizzaOrder.size() == 0 || pizzaOrder == null) {
			throw new CustomerNotFoundException("No Customer Found For : " + userId + status);
		}
		return pizzaOrder.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

}
