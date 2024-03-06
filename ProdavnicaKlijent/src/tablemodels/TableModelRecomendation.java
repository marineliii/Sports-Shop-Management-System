/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import controller.ControllerUI;
import domain.Article;
import domain.Recommendation;
import domain.Worker;
import forms.ViewAllRecommendationsForm;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Veljko
 */
public class TableModelRecomendation extends AbstractTableModel {
    
    private List<Recommendation> recommendations;
    private List<Article> articles;
    private List<Worker> workers;
    private String[] columns = {"Artikal", "Radnik", "Ocena", "Komentar"};
    
    public TableModelRecomendation(List<Recommendation> recomendations) {
        this.recommendations=recomendations;
        try {
            this.articles=ControllerUI.getInstance().getAllArticles();
            this.workers=ControllerUI.getInstance().getAllWorkers();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRecomendation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public int getRowCount() {
        if(recommendations==null){
            return 0;
        }
        return recommendations.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recommendation recommendation = recommendations.get(rowIndex);
        switch (columnIndex) {
            case 0:
                for(Article article:articles){
                    if(article.getArticleID()==recommendation.getArticleID()){
                        return article.getName();
                    }
                }
            case 1:
                for(Worker worker:workers){
                    if(worker.getWorkerID()==recommendation.getWorkerID()){
                        return worker.getFullName();
                    }
                }
            case 2:
                return recommendation.getRating();
            case 3:
                return recommendation.getComment();
            default:
                return "n/a";
        }
    }

    public void deleteRecommendation(int index) throws Exception {
        Recommendation returnreRecommendation = ControllerUI.getInstance().deleteRecommendation(recommendations.get(index));
        recommendations.remove(index);
        fireTableDataChanged();
    }

    public Recommendation getRecommendation(int row) {
        return recommendations.get(row);
    }
    
}
