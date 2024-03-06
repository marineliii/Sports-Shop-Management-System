/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import controller.ControllerUI;
import domain.Article;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Veljko
 */
public class TableModelArticle extends AbstractTableModel {
    
    private List<Article> articles;
    private String[] columns = {"ID","Naziv","Cena artikla","Tip"};

    public TableModelArticle(List<Article> articles) {
        this.articles=articles;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    @Override
    public int getRowCount() {
        if(articles==null){
            return 0;
        }
        return articles.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Article article = articles.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return article.getArticleID();
            case 1:
                return article.getName();
            case 2:
                return article.getPrice();
            case 3:
                return article.getType();
            default:
                return "n/a";
        }
    }

    public List<Article> getArticles() {
        return articles;
    }
    
    public Article getArticle(int index){
        return articles.get(index);
    }
    
    public void remove(int index){
        articles.remove(index);
        fireTableDataChanged();
    }
    
    
    
}
