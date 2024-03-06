/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recommendation;

import controller.Controller;
import domain.Recommendation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class DeleteRecommendationSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Recommendation)){
            throw new Exception("Objekat nije preporuka");
        }
        Recommendation recommendation = (Recommendation) param;
        if(!doesExist(recommendation)){
            throw new Exception("Preporuka ne postoji u bazi");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Recommendation)param);
    }

    private boolean doesExist(Recommendation recommendation) {
        List<Recommendation> recommendations = new ArrayList<>();
        try {
            recommendations=Controller.getInstance().getAllRecommendations();
        } catch (Exception ex) {
            Logger.getLogger(DeleteRecommendationSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Recommendation recommendationHelp : recommendations) {
            if(recommendationHelp.getWorkerID()==recommendation.getWorkerID()
                    && recommendationHelp.getArticleID()==recommendation.getArticleID()){
                return true;
            }
        }
        return false;
    }
    
}
