/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.article;

import domain.Article;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllArticlesSO extends AbstractSO {
    
    private List<Article> articles;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no preconditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        articles=repository.getAll((Article)param);
    }

    public List<Article> getArticles() {
        return articles;
    }
    
    
    
}
