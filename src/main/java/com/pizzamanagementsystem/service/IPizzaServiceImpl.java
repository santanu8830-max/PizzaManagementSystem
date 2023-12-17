package com.pizzamanagementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagementsystem.dto.PizzaDTO;
import com.pizzamanagementsystem.dto.PizzaTypeDTO;
import com.pizzamanagementsystem.dto.ToppingsDTO;
import com.pizzamanagementsystem.entity.Pizza;
import com.pizzamanagementsystem.entity.PizzaType;
import com.pizzamanagementsystem.entity.Toppings;
import com.pizzamanagementsystem.exception.PizzaNotFoundException;
import com.pizzamanagementsystem.exception.ToppingsNotFoundException;
import com.pizzamanagementsystem.repository.PizzaRepository;
import com.pizzamanagementsystem.repository.PizzaTypeRepository;
import com.pizzamanagementsystem.repository.ToppingsRepository;
import com.pizzamanagementsystem.util.PizzaSize;

@Service
public class IPizzaServiceImpl implements IPizzaService {
	@Autowired
	PizzaRepository pizzaRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ToppingsRepository toppingsRepository;

	@Autowired
	PizzaTypeRepository pizzaTypeRepository;

	/*
	 * To Convert Entity to DTO
	 */
	private PizzaDTO convertEntityToDto(Pizza p) {
		/*
		 * With Model Mapper
		 */
		PizzaDTO pizzaDTO = modelMapper.map(p, PizzaDTO.class);
		return pizzaDTO;
	}

	/*
	 * To convert DTO to Entity//
	 */
	private Pizza convertDtoToEntity(PizzaDTO pDTO) {
		Pizza pizza = modelMapper.map(pDTO, Pizza.class);
		return pizza;
	}

	/*
	 * Convert for ToppingsEntity to Topping DTO
	 */
	private ToppingsDTO convertEntityToDto(Toppings tp) {
		/*
		 * with model Mapper
		 */
		ToppingsDTO tpDTO = modelMapper.map(tp, ToppingsDTO.class);
		return tpDTO;
	}

	/*
	 * Convert for ToppingDTO to Entiity//
	 */
	private Toppings convertDtoToEntity(ToppingsDTO tpDTO) {
		Toppings tp = modelMapper.map(tpDTO, Toppings.class);
		return tp;
	}

	/*
	 * to convert entity to DTO for pizzatype//
	 */
	private PizzaTypeDTO convertEntityToDto(PizzaType p) {
		/*
		 * with model Mapper
		 */
		PizzaTypeDTO pizzatypeDTO = modelMapper.map(p, PizzaTypeDTO.class);
		return pizzatypeDTO;
	}

	/*
	 * To Convert DTO to Entity PizzaType//
	 */
	private PizzaType convertDtoToEntity(PizzaTypeDTO pDTO) {
		PizzaType pizzaType = modelMapper.map(pDTO, PizzaType.class);
		return pizzaType;
	}

	/*
	 * For add Pizza
	 */
	@Override
	public PizzaDTO addPizza(PizzaDTO pizza) {
		Pizza newPizza = convertDtoToEntity(pizza);
		pizzaRepository.save(newPizza);
		return pizza;
	}

	/*
	 * View Pizza by Id
	 */
	@Override
	public PizzaDTO viewPizzaById(Integer pizzaId) throws PizzaNotFoundException {
		Optional<Pizza> newPizza = pizzaRepository.findById(pizzaId);
		if (!newPizza.isPresent()) {
			throw new PizzaNotFoundException("Pizza  Not Found For PizzaId :" + pizzaId);
		} else {
			Pizza pizza = newPizza.get();
			PizzaDTO newPizzadto = convertEntityToDto(pizza);
			return newPizzadto;
		}
	}

	/*
	 * View Pizza by Price
	 */
	@Override
	public List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice) {
		List<Pizza> pizza = pizzaRepository.findByPizzaCostBetween(minPrice, maxPrice);
		if (pizza.size() == 0 || pizza == null) {
			throw new PizzaNotFoundException("Pizza Not Found Price");
		}
		return pizza.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	/*
	 * View all Pizza
	 */
	@Override
	public List<PizzaDTO> viewAllPizza() {
		List<Pizza> pizza = pizzaRepository.findAll();
		if (pizza.size() == 0 || pizza == null) {
			throw new PizzaNotFoundException("Pizza Not Available");
		}
		return pizza.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	/*
	 * Add Toppings
	 */

	@Override
	public ToppingsDTO addToppings(ToppingsDTO tpdto) {
		Toppings tp = convertDtoToEntity(tpdto);
		toppingsRepository.save(tp);
		ToppingsDTO tpd = convertEntityToDto(tp);
		return tpd;
	}

	/*
	 * Add Pizza Type
	 */
	@Override
	public PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaType) {
		PizzaType pt = convertDtoToEntity(pizzaType);
		pizzaTypeRepository.save(pt);
		PizzaTypeDTO ptd = convertEntityToDto(pt);
		return ptd;
	}

	/*
	 * View All Topping
	 */
	@Override
	public List<ToppingsDTO> viewToppings() throws ToppingsNotFoundException {
		List<Toppings> toppings = toppingsRepository.findAll();
		if (toppings.size() == 0 || toppings == null) {
			throw new ToppingsNotFoundException("No Toppings Found");
		}
		return toppings.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	/*
	 * View All Topping Id/
	 */
	@Override
	public ToppingsDTO viewToppingByID(Integer toppingsID) throws ToppingsNotFoundException {
		Optional<Toppings> tp = toppingsRepository.findById(toppingsID);
		if (!tp.isPresent()) {
			throw new ToppingsNotFoundException("Topping Id Not Found");
		} else {
			Toppings tpnew = tp.get();
			ToppingsDTO tpdto = convertEntityToDto(tpnew);
			return tpdto;
		}
	}

	/*
	 * View Pizza Type by Id
	 */
	@Override
	public PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId) throws PizzaNotFoundException {
		Optional<PizzaType> pt = pizzaTypeRepository.findById(pizzaTypeId);
		if (!pt.isPresent()) {
			throw new PizzaNotFoundException("No Pizza found For PizzaTypeId:");
		} else {
			PizzaType pizzaType = pt.get();
			PizzaTypeDTO ptdto = convertEntityToDto(pizzaType);
			return ptdto;
		}
	}

	/*
	 * View All PizzaType
	 */
	@Override
	public List<PizzaTypeDTO> viewAllPizzaTypes() throws PizzaNotFoundException {
		List<PizzaType> pizzaType = pizzaTypeRepository.findAll();
		if (pizzaType.size() == 0 || pizzaType == null)
			throw new PizzaNotFoundException("Unable To Find This Type");
		return pizzaType.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	/*
	 * View Pizza by Type
	 */
	@Override
	public List<PizzaDTO> findByPizzaTypePizzaType(String pizzatype) {
		List<Pizza> pizza = pizzaRepository.findByPizzaTypePizzaType(pizzatype);
		if (pizza.size() == 0 || pizza == null)
			throw new PizzaNotFoundException("Not Found This Pizza Type");
		return pizzaRepository.findByPizzaTypePizzaType(pizzatype).stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	/*
	 * View Pizza by Size
	 */

	@Override
	public List<PizzaDTO> viewPizzaByPizzaSize(PizzaSize pizzaSize) {
		List<Pizza> pizza = pizzaRepository.findByPizzaSize(pizzaSize);
		if (pizza.isEmpty() || pizza == null)
			throw new PizzaNotFoundException("Unable To Find This PizzaSize");
		return pizza.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}
}
