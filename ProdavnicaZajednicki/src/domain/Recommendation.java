/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Veljko
 */
public class Recommendation implements GenericEntity {
    private int articleID;
    private int workerID;
    private int rating;
    private String comment;

    public Recommendation() {
    }

    public Recommendation(int articleID, int workerID, int rating, String comment) {
        this.articleID = articleID;
        this.workerID = workerID;
        this.rating = rating;
        this.comment = comment;
    }

    

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    @Override
    public String toString() {
        return "Recomendation{" + "articleID=" + articleID + ", workerID=" + workerID + ", rating=" + rating + ", comment=" + comment + '}';
    }

    @Override
    public String getTableName() {
        return "preporuka";
    }

    @Override
    public String getInsertColumns() {
        return "artikalID, radnikID, ocena, komentar";
    }

    @Override
    public String getInsertValues() {
        return articleID+","+workerID+","+rating+","+"'"+comment+"'";
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQuery() {
        return "artikalID="+articleID+" AND radnikID="+workerID;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> recommendations = new ArrayList<>();
        try {           
            while(rs.next()){
                int articleID = rs.getInt("artikalID");
                int workerID = rs.getInt("radnikID");
                int rating = rs.getInt("ocena");
                String comment = rs.getString("komentar");
                Recommendation recommendation = new Recommendation(articleID, workerID, rating, comment);
                recommendations.add(recommendation);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Recommendation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recommendations;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        return "artikalID="+((Article)object).getArticleID();
    }

    

    

    
    
    
}
