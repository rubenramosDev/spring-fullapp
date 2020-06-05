package com.mealordev.projectmanagement.mealordev.model.interfaces;

import com.mealordev.projectmanagement.mealordev.model.entity.Associate;
import org.springframework.data.repository.CrudRepository;

/*This is all the dao, there is not any implementation of this interface, we only
 * injecte the interface*/
public interface IAssociateDao extends CrudRepository<Associate, Long> {


}
