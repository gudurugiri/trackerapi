/**
 * 
 */
package com.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.ItemInfo;

/**
 * @author Bujair
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemInfo, Long> {

}
