/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.article;

import controller.Controller;
import domain.Article;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class UpdateArticleSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param==null || !(param instanceof Article)){
            throw new Exception("Objekat nije artikal");
        }
        Article article = (Article) param;
        if(!isInBase(article)){
            throw new Exception("Artikal ne postoji u bazi");
        }
        if(doesExist(article)){
            throw new Exception("Artikal sa unetim imenom vec postoji");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.update((Article)param);
    }
    
    private boolean isInBase(Article article){
        List<Article> articles = new ArrayList<>();
        try {
            articles = Controller.getInstance().getAllArticles();
        } catch (Exception ex) {
            Logger.getLogger(SaveArticleSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Article articleHelp : articles) {
            if(article.getArticleID()==articleHelp.getArticleID()){
                return true;
            }
        }
        return false;
    }

    private boolean doesExist(Article article) {
        List<Article> articles = new ArrayList<>();
        try {
            articles = Controller.getInstance().getAllArticles();
        } catch (Exception ex) {
            Logger.getLogger(SaveArticleSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Article articleHelp : articles) {
            if(article.getName().equals(articleHelp.getName()) && article.getArticleID()!=articleHelp.getArticleID()){
                return true;
            }
        }
        return false;
    }
    
}
