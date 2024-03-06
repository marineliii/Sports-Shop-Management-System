/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.article;

import controller.Controller;
import domain.Article;
import forms.validator.Validator;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class SaveArticleSO extends AbstractSO {
    
    

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Article)){
            throw new Exception("Objekat nije artikal");
        }
        Article article = (Article) param;
        if(doesExist(article)){
            throw new Exception("Artikal vec postoji");
        }
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.save((Article)param);
    }
    
    private boolean doesExist(Article article){
        List<Article> articles = new ArrayList<>();
        try {
            articles = Controller.getInstance().getAllArticles();
        } catch (Exception ex) {
            Logger.getLogger(SaveArticleSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Article articleHelp : articles) {
            if(article.getName().equals(articleHelp.getName())){
                return true;
            }
        }
        return false;
    }
    
}
