/**
 * 
 */
package com.tracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dao.ItemRepository;
import com.tracker.model.ItemInfo;

/**
 * @author Bujair
 *
 */
@RestController
@RequestMapping("/tracker/1.0/api")
public class ItemController extends BaseController{


	Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired(required = false)
	ItemRepository itemRepository;

	@GetMapping("/item")
	/**
	 * Getting all the Items
	 * 
	 * @return
	 */
	public List<ItemInfo> getItem() {
		logger.debug("GET ITEM");
		return itemRepository.findAll();
	}

	/**
	 * Getting Item data based on ID
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/item/{id}")
	public ItemInfo getItem(@PathVariable("id") String id) {
		return itemRepository.findById(getLongFromString(id)).orElse(null);
	}

	

	/**
	 * Deleting item
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/item/{id}")
	public String deleteItem(@PathVariable("id") String id) {
		itemRepository.deleteById(getLongFromString(id));
		return SUCCESS;
	}

	/**
	 * Creating or Updating the Item
	 * 
	 * @param item
	 * @return
	 */
	@PostMapping("/item")
	public ItemInfo createNote(@Valid @RequestBody ItemInfo item) {
		return itemRepository.save(item);
	}

}
