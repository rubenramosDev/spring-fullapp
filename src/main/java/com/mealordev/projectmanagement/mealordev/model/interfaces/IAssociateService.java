package com.mealordev.projectmanagement.mealordev.model.interfaces;

import com.mealordev.projectmanagement.mealordev.model.entity.Associate;

import java.util.List;

public interface IAssociateService {

    public List<Associate> getAllAssociates();

    public void addAssociate(Associate associate);

    public Associate findOneAssocite(Long idAssociate);

    public void deleteAssociate(Long idAssociate);
}
