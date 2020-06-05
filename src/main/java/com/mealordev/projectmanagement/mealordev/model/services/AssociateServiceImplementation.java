package com.mealordev.projectmanagement.mealordev.model.services;

import com.mealordev.projectmanagement.mealordev.model.entity.Associate;
import com.mealordev.projectmanagement.mealordev.model.interfaces.IAssociateDao;
import com.mealordev.projectmanagement.mealordev.model.interfaces.IAssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*We implement the AssociateService as a facade, we can use several daos instances here
 * -Controller                      (controller)
 *  -AssociateServiceImplementation (facade)
 *   -AssociateDaoImplementation    (dao)
 * */
@Service
public class AssociateServiceImplementation implements IAssociateService {

    @Autowired
    private IAssociateDao iAssociate;

    @Override
    @Transactional(readOnly = true)
    public List<Associate> getAllAssociates() {
        return (List<Associate>) iAssociate.findAll();
    }

    @Override
    @Transactional
    public void addAssociate(Associate associate) {
        iAssociate.save(associate);
    }

    @Override
    @Transactional(readOnly = true)
    public Associate findOneAssocite(Long idAssociate) {
        return iAssociate.findById(idAssociate).orElse(null);
    }

    @Override
    @Transactional
    public void deleteAssociate(Long idAssociate) {
        iAssociate.deleteById(idAssociate);
    }
}
