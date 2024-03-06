/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.article;

import domain.Article;
import java.util.List;
import java.util.logging.Filter;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllArticlesByFilterSO extends AbstractSO{
    
    private List<Article> articles; 
    private List<String> filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no preconditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        articles=repository.getAllByFilter((Article)param, (List<String>) filter);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setFilter(List<String> filter) {
        this.filter = filter;
    }
    
    
    
    
}
