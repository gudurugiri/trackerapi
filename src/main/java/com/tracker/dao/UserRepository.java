/**
 * 
 */
package com.tracker.dao;

import org.springframework.stereotype.Repository;

import com.tracker.model.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bujair
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
