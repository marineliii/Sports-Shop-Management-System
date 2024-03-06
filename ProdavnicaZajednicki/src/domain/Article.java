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
public class Article implements GenericEntity {
    private int articleID;
    private String name;
    private double price;
    private String type;

    public Article() {
    }

    public Article(int articleID, String name, double price, String type) {
        this.articleID = articleID;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTableName() {
        return "artikal";
    }

    @Override
    public String getInsertColumns() {
        return "naziv, cenaArtikla, tip";
    }

    @Override
    public String getInsertValues() {
        return "'"+name+"',"+price+",'"+type+"'";
    }

    @Override
    public void setId(int id) {
        this.articleID=id;
    }

    @Override
    public String getUpdateQuery() {
        return "naziv='"+name+"',cenaArtikla="+price+",tip='"+type+"'";
    }

    @Override
    public String getWhereQuery() {
        return "artikalID="+articleID;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> articles = new ArrayList<>();
        try {
            while(rs.next()){
                int articleID = rs.getInt("artikalID");
                String name = rs.getString("naziv");
                double price = rs.getDouble("cenaArtikla");
                String type = rs.getString("tip");
                Article article = new Article(articleID, name, price, type);
                articles.add(article);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articles;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        String search = ((List<String>)filter).get(0);
        String chosenType = ((List<String>)filter).get(1);
        
        return "(naziv LIKE '%"+search+"%' OR cenaArtikla LIKE '%"+search+"%' OR tip LIKE '%"+search+"%')"
                    + " AND tip LIKE '%"+chosenType+"%'";
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    
    
}
