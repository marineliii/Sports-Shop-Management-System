/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recommendation;

import domain.Recommendation;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllRecommandationsSO extends AbstractSO {
    
    private List<Recommendation> recommedations; 

    @Override
    protected void preconditions(Object param) throws Exception {
        //no preconditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        recommedations=repository.getAll((Recommendation)param);
    }

    public List<Recommendation> getRecommedations() {
        return recommedations;
    }
    
    
    
}
