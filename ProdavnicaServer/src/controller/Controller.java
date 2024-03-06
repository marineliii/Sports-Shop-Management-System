/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Article;
import domain.Customer;
import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import domain.Recommendation;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import repository.Repository;
import repository.db.broker.DatabaseBroker;
import so.AbstractSO;
import so.article.GetAllArticlesByFilterSO;
import so.article.GetAllArticlesSO;
import so.article.SaveArticleSO;
import so.article.UpdateArticleSO;
import so.customer.GetAllCustomersByFilterSO;
import so.customer.GetAllCustomersSO;
import so.customer.SaveCustomerSO;
import so.customer.UpdateCustomerSO;
import so.purchaseorder.DeletePurchaseOrderSO;
import so.purchaseorder.GetAllPurchaseOrdersByCustomerSO;
import so.purchaseorder.GetAllPurchaseOrdersSO;
import so.purchaseorder.SavePurchaseOrderSO;
import so.purchaseorder.UpdatePurchaseOrderSO;
import so.purchaseorderitem.DeletePurchaseOrderItemSO;
import so.purchaseorderitem.GetAllItemsByPurchaseOrderSO;
import so.purchaseorderitem.SavePurchaseOrderItemSO;
import so.recommendation.DeleteRecommendationSO;
import so.recommendation.GetAllRecommandationsSO;
import so.recommendation.GetAllRecommendationsByArticleSO;
import so.recommendation.SaveRecommendationSO;
import so.worker.DeleteWorkerSO;
import so.worker.GetAllWorkersSO;
import so.worker.LoginSO;
import so.worker.LogoutSO;
import so.worker.SaveWorkerSO;
import so.worker.UpdateWorkerSO;

/**
 *
 * @author Veljko
 */
public class Controller {
    
      private final Repository repositoryGeneric;
    
    private static Controller controller;
    private ArrayList<Worker> listOfLoginWorkers;

    private Controller() {
          this.repositoryGeneric=new DatabaseBroker();
          listOfLoginWorkers = new ArrayList<>();
    }
    
    public static Controller getInstance(){
        if(controller == null){
            controller = new Controller();
        }
        return controller;
    }
    
    
    public Worker login(String username, String password) throws Exception{
    List<Worker> workers = getAllWorkers();
    Worker currentWorker = new Worker();
    for (Worker worker : workers) {
    if (worker.getUsername().equals(username) && worker.getPassword().equals(password)) {
    currentWorker=worker;
    }
    }
    AbstractSO loginSO = new LoginSO();
    loginSO.excecute(currentWorker);
    return ((LoginSO)loginSO).getActiveWorker();
    }
    
    
    
    public void logout(Worker worker) throws Exception {
        AbstractSO logoutSO = new LogoutSO();
        logoutSO.excecute(worker);
    }
    
    public List<Worker> getAllWorkers() throws Exception{
        AbstractSO getAllWorkers = new GetAllWorkersSO();
        getAllWorkers.excecute(new Worker());
        return ((GetAllWorkersSO)getAllWorkers).getWorkers();
    }
    
    public void deleteWorker(Worker worker) throws Exception {
        AbstractSO deleteWorker = new DeleteWorkerSO();
        deleteWorker.excecute(worker);
    }

    public void updateWorker(Worker worker) throws Exception {
        AbstractSO updateWorker = new UpdateWorkerSO();
        updateWorker.excecute(worker);
    }

    public void saveWorker(Worker worker) throws Exception {
        AbstractSO saveWorker = new SaveWorkerSO();
        saveWorker.excecute(worker);
    }
    
    public List<Article> getAllArticles() throws Exception{
        AbstractSO getAllArticles = new GetAllArticlesSO();
        getAllArticles.excecute(new Article());
        return ((GetAllArticlesSO)getAllArticles).getArticles();
    }
    
    public List<Article> getAllArticlesByFilter(List<String> filter) throws Exception{
        AbstractSO getAllArticlesByFilter = new GetAllArticlesByFilterSO();
        ((GetAllArticlesByFilterSO)getAllArticlesByFilter).setFilter(filter);
        getAllArticlesByFilter.excecute(new Article());
        return ((GetAllArticlesByFilterSO)getAllArticlesByFilter).getArticles();
    }
    

    public void updateArticle(Article article) throws Exception {
        AbstractSO updateArticle = new UpdateArticleSO();
        updateArticle.excecute(article);
    }

    public void saveArticle(Article article) throws Exception {
        AbstractSO saveArticle = new SaveArticleSO();
        saveArticle.excecute(article);
    }
    
    public List<Customer> getAllCustomers() throws Exception{
        AbstractSO getAllCustomers = new GetAllCustomersSO();
        getAllCustomers.excecute(new Customer());
        return ((GetAllCustomersSO)getAllCustomers).getCustomers();
    }
    
    public List<Customer> getAllCustomersByFilter(String filter) throws Exception{
        AbstractSO getAllCustomersByFilter = new GetAllCustomersByFilterSO();
        ((GetAllCustomersByFilterSO)getAllCustomersByFilter).setFilter(filter);
        getAllCustomersByFilter.excecute(new Customer());
        return ((GetAllCustomersByFilterSO)getAllCustomersByFilter).getCustomers();
    }

    public void updateCustomer(Customer customer) throws Exception {
        AbstractSO updateCustomer = new UpdateCustomerSO();
        updateCustomer.excecute(customer);
    }

    public void saveCustomer(Customer customer) throws Exception {
        AbstractSO saveCustomer = new SaveCustomerSO();
        saveCustomer.excecute(customer);
    }
    
    public List<PurchaseOrder> getAllPurchaseOrders() throws Exception{
        AbstractSO getAllPurchaseOrders = new GetAllPurchaseOrdersSO();
        getAllPurchaseOrders.excecute(new PurchaseOrder());
        return ((GetAllPurchaseOrdersSO)getAllPurchaseOrders).getPurchaseOrders();
    }
    
    public List<PurchaseOrder> getAllPurchaseOrdersByCustomer(Customer customer) throws Exception{
        AbstractSO getAllPurchaseOrdersByCustomer = new GetAllPurchaseOrdersByCustomerSO();
        ((GetAllPurchaseOrdersByCustomerSO)getAllPurchaseOrdersByCustomer).setFilter(customer);
        getAllPurchaseOrdersByCustomer.excecute(new PurchaseOrder());
        return ((GetAllPurchaseOrdersByCustomerSO)getAllPurchaseOrdersByCustomer).getPurchaseOrders();
    }
    
    public void deletePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception {
        AbstractSO deletePurchaseOrder = new DeletePurchaseOrderSO();
        deletePurchaseOrder.excecute(purchaseOrder);
    }

    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception {
        AbstractSO updatePurchaseOrder = new UpdatePurchaseOrderSO();
        updatePurchaseOrder.excecute(purchaseOrder);
    }

    public void savePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception {
        AbstractSO savePurchaseOrder = new SavePurchaseOrderSO();
        savePurchaseOrder.excecute(purchaseOrder);
    }
    
    public List<Recommendation> getAllRecommendations() throws Exception{
        AbstractSO getAllRecommendations = new GetAllRecommandationsSO();
        getAllRecommendations.excecute(new Recommendation());
        return ((GetAllRecommandationsSO)getAllRecommendations).getRecommedations();
    }
    
    public List<Recommendation> getAllRecommendationsByArticle(Article article) throws Exception{
        AbstractSO getAllRecommendationsByArticle = new GetAllRecommendationsByArticleSO();
        ((GetAllRecommendationsByArticleSO)getAllRecommendationsByArticle).setFilter(article);
        getAllRecommendationsByArticle.excecute(new Recommendation());
        return ((GetAllRecommendationsByArticleSO)getAllRecommendationsByArticle).getRecommendations();
    }
    
    public void deleteRecommendation(Recommendation recommendation) throws Exception {
        AbstractSO deleteRecommendation = new DeleteRecommendationSO();
        deleteRecommendation.excecute(recommendation);
    }

    public void saveRecommendation(Recommendation recommendation) throws Exception {
        AbstractSO saveRecommendation = new SaveRecommendationSO();
        saveRecommendation.excecute(recommendation);
    }
    
    public List<PurchaseOrderItem> getAllItemsByPurchaseOrder(PurchaseOrder purchaseOrder) throws Exception{
        AbstractSO getAllItemsByPurchaseOrder = new GetAllItemsByPurchaseOrderSO();
        ((GetAllItemsByPurchaseOrderSO)getAllItemsByPurchaseOrder).setFilter(purchaseOrder);
        getAllItemsByPurchaseOrder.excecute(new PurchaseOrderItem());
        return ((GetAllItemsByPurchaseOrderSO)getAllItemsByPurchaseOrder).getPurchaseOrderItems();
    }
    
    public void deletePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) throws Exception {
        AbstractSO deletePurchaseOrderItem = new DeletePurchaseOrderItemSO();
        deletePurchaseOrderItem.excecute(purchaseOrderItem);
    }

    public void savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) throws Exception {
        AbstractSO savePurchaseOrderItem = new SavePurchaseOrderItemSO();
        savePurchaseOrderItem.excecute(purchaseOrderItem);
    }
    
}
