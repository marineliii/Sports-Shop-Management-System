/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recommendation;

import domain.Article;
import domain.Recommendation;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllRecommendationsByArticleSO extends AbstractSO {
    
    private List<Recommendation> recommendations;
    private Article filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no preconditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        recommendations=repository.getAllByObject((Recommendation)param, (Article)filter);
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setFilter(Article filter) {
        this.filter = filter;
    }
    
    
    
}
