/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import communication.Receiver;
import communication.Sender;
import domain.Article;
import domain.Customer;
import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import domain.Recommendation;
import domain.Worker;
import java.util.List;
import operation.Operation;
import transfer.ClientRequest;
import transfer.ServerResponse;

/**
 *
 * @author Veljko
 */
public class ControllerUI {
    
    private static ControllerUI instance;
    
    private Sender sender;
    private Receiver receiver;
    
    private ControllerUI(){
        sender=Communication.getInstance().getSender();
        receiver=Communication.getInstance().getReceiver();
    }

    public static ControllerUI getInstance() {
        if(instance==null){
            instance=new ControllerUI();
        }
        return instance;
    }
    
    public Worker login(String username, String password) throws Exception{
        Worker worker = new Worker();
        worker.setUsername(username);
        worker.setPassword(password);
        ClientRequest request = new ClientRequest(worker, Operation.LOGIN, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Worker) response.getResult();
        }
        throw response.getException();
    }
    
    public Worker logout(Worker worker) throws Exception {
        ClientRequest request = new ClientRequest(worker, Operation.LOGOUT, null);
        sender.send(request);
        ServerResponse response = (ServerResponse)receiver.receive();
        if(response.getException()==null){
            return (Worker) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Worker> getAllWorkers() throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_ALL_WORKERS, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<Worker>) response.getResult();
        }
        throw response.getException();
    }
    
    public Worker deleteWorker(Worker worker) throws Exception {
        ClientRequest request = new ClientRequest(worker, Operation.DELETE_WORKER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Worker) response.getResult();
        }
        throw response.getException();
    }

    public Worker updateWorker(Worker worker) throws Exception {
        ClientRequest request = new ClientRequest(worker, Operation.UPDATE_WORKER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Worker) response.getResult();
        }
        throw response.getException();
    }

    public Worker saveWorker(Worker worker) throws Exception {
        ClientRequest request = new ClientRequest(worker, Operation.SAVE_WORKER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Worker) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Article> getAllArticles() throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_ALL_ARTICLES, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<Article>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Article> getAllArticlesByFilter(List<String> filter) throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_ARTICLES_BY_FILTER, filter);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<Article>) response.getResult();
        }
        throw response.getException();
    }
    

    public Article updateArticle(Article article) throws Exception {
        ClientRequest request = new ClientRequest(article, Operation.UPDATE_ARTICLE, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Article) response.getResult();
        }
        throw response.getException();
    }

    public Article saveArticle(Article article) throws Exception {
        ClientRequest request = new ClientRequest(article, Operation.SAVE_ARTICLE, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Article) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Customer> getAllCustomers() throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_ALL_CUSTOMERS, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<Customer>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Customer> getAllCustomersByFilter(String filter) throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_ALL_CUSTOMERS_BY_FILTER, filter);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<Customer>) response.getResult();
        }
        throw response.getException();
    }

    public Customer updateCustomer(Customer customer) throws Exception {
        ClientRequest request = new ClientRequest(customer, Operation.UPDATE_CUSTOMER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Customer) response.getResult();
        }
        throw response.getException();
    }

    public Customer saveCustomer(Customer customer) throws Exception {
        ClientRequest request = new ClientRequest(customer, Operation.SAVE_CUSTOMER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Customer) response.getResult();
        }
        throw response.getException();
    }
    
    public List<PurchaseOrder> getAllPurchaseOrders() throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_ALL_PURCHASE_ORDERS, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<PurchaseOrder>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<PurchaseOrder> getAllPurchaseOrdersByCustomer(Customer customer) throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_PURCHASE_ORDERS_BY_CUSTOMER, customer);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<PurchaseOrder>) response.getResult();
        }
        throw response.getException();
    }
    
    public PurchaseOrder deletePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception {
        ClientRequest request = new ClientRequest(purchaseOrder, Operation.DELETE_PURCHASE_ORDER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (PurchaseOrder) response.getResult();
        }
        throw response.getException();
    }

    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception {
        ClientRequest request = new ClientRequest(purchaseOrder, Operation.UPDATE_PURCHASE_ORDER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (PurchaseOrder) response.getResult();
        }
        throw response.getException();
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception {
        ClientRequest request = new ClientRequest(purchaseOrder, Operation.SAVE_PURCHASE_ORDER, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (PurchaseOrder) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Recommendation> getAllRecommendations() throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_ALL_RECOMMENDATIONS, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<Recommendation>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Recommendation> getAllRecommendationsByArticle(Article article) throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_RECOMMENDATIONS_BY_ARTICLE, article);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<Recommendation>) response.getResult();
        }
        throw response.getException();
    }
    
    public Recommendation deleteRecommendation(Recommendation recommendation) throws Exception {
        ClientRequest request = new ClientRequest(recommendation, Operation.DELETE_RECOMMENDATION, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Recommendation) response.getResult();
        }
        throw response.getException();
    }

    public Recommendation saveRecommendation(Recommendation recommendation) throws Exception {
        ClientRequest request = new ClientRequest(recommendation, Operation.SAVE_RECOMMENDATION, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (Recommendation) response.getResult();
        }
        throw response.getException();
    }
    
    public List<PurchaseOrderItem> getAllItemsByPurchaseOrder(PurchaseOrder purchaseOrder) throws Exception{
        ClientRequest request = new ClientRequest(null, Operation.GET_PURCHASE_ORDER_ITEMS_BY_PURCHASE_ORDER, purchaseOrder);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (List<PurchaseOrderItem>) response.getResult();
        }
        throw response.getException();
    }
    
    public PurchaseOrderItem deletePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) throws Exception {
        ClientRequest request = new ClientRequest(purchaseOrderItem, Operation.DELETE_PURCHASE_ORDER_ITEM, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (PurchaseOrderItem) response.getResult();
        }
        throw response.getException();
    }

    public PurchaseOrderItem savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) throws Exception {
        ClientRequest request = new ClientRequest(purchaseOrderItem, Operation.SAVE_PURCHASE_ORDER_ITEM, null);
        sender.send(request);
        ServerResponse response = (ServerResponse) receiver.receive();
        if(response.getException()==null){
            return (PurchaseOrderItem) response.getResult();
        }
        throw response.getException();
    }
    
    
    
}
