/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Sender;
import controller.Controller;
import domain.Article;
import domain.Customer;
import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import domain.Recommendation;
import domain.Worker;
import java.net.Socket;
import java.util.List;
import transfer.ClientRequest;
import transfer.ServerResponse;

/**
 *
 * @author Veljko
 */
public class HandleClientRequests extends Thread {
    
    private final Socket socket;
    private final Sender sender;
    private final Receiver receiver;
    private Worker currentWorker;

    public HandleClientRequests(Socket socket) {
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                ClientRequest request = (ClientRequest) receiver.receive();
                ServerResponse response = new ServerResponse();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Worker w = (Worker) request.getArgument();
                            Worker worker = Controller.getInstance().login(w.getUsername(), w.getPassword());
                            currentWorker=worker;
                            response.setResult(worker);
                            break;
                        case LOGOUT:
                            Worker activeWorker = (Worker) request.getArgument();
                            Controller.getInstance().logout(activeWorker);
                            response.setResult(activeWorker);
                            break;
                        case GET_ALL_ARTICLES:
                            List<Article> articles = Controller.getInstance().getAllArticles();
                            response.setResult(articles);
                            break;
                        case GET_ALL_CUSTOMERS:
                            List<Customer> customers = Controller.getInstance().getAllCustomers();
                            response.setResult(customers);
                            break;
                        case GET_ALL_PURCHASE_ORDERS:
                            List<PurchaseOrder> purchaseOrders = Controller.getInstance().getAllPurchaseOrders();
                            response.setResult(purchaseOrders);
                            break;
                        case GET_ALL_WORKERS:
                            List<Worker> workers = Controller.getInstance().getAllWorkers();
                            response.setResult(workers);
                            break;
                        case GET_ALL_RECOMMENDATIONS:
                            List<Recommendation> recommendations = Controller.getInstance().getAllRecommendations();
                            response.setResult(recommendations);
                            break;
                        case GET_ARTICLES_BY_FILTER:
                            List<Article> articlesFilter =
                                    Controller.getInstance().getAllArticlesByFilter((List<String>) request.getFilter());
                            response.setResult(articlesFilter);
                            break;
                        case GET_ALL_CUSTOMERS_BY_FILTER:
                            List<Customer> customersFilter =
                                    Controller.getInstance().getAllCustomersByFilter((String) request.getFilter());
                            response.setResult(customersFilter);
                            break;
                        case GET_PURCHASE_ORDERS_BY_CUSTOMER:
                            List<PurchaseOrder> purchaseOrdersFilter = 
                                    Controller.getInstance().getAllPurchaseOrdersByCustomer((Customer) request.getFilter());
                            response.setResult(purchaseOrdersFilter);
                            break;
                        case GET_RECOMMENDATIONS_BY_ARTICLE:
                            List<Recommendation> recommendationsFilter = 
                                    Controller.getInstance().getAllRecommendationsByArticle((Article) request.getFilter());
                            response.setResult(recommendationsFilter);
                            break;
                        case GET_PURCHASE_ORDER_ITEMS_BY_PURCHASE_ORDER:
                            List<PurchaseOrderItem> purchaseOrderItemsFilter = 
                                    Controller.getInstance().getAllItemsByPurchaseOrder((PurchaseOrder) request.getFilter());
                            response.setResult(purchaseOrderItemsFilter);
                            break;
                        case SAVE_ARTICLE:
                            Article articleSave = (Article) request.getArgument();
                            Controller.getInstance().saveArticle(articleSave);
                            response.setResult(articleSave);
                            break;
                        case SAVE_CUSTOMER:
                            Customer customerSave = (Customer) request.getArgument();
                            Controller.getInstance().saveCustomer(customerSave);
                            response.setResult(customerSave);
                            break;
                        case SAVE_WORKER:
                            Worker workerSave = (Worker) request.getArgument();
                            Controller.getInstance().saveWorker(workerSave);
                            response.setResult(workerSave);
                            break;
                        case SAVE_PURCHASE_ORDER:
                            PurchaseOrder purchaseOrderSave = (PurchaseOrder) request.getArgument();
                            Controller.getInstance().savePurchaseOrder(purchaseOrderSave);
                            response.setResult(purchaseOrderSave);
                            break;
                        case SAVE_RECOMMENDATION:
                            Recommendation recommendationSave = (Recommendation) request.getArgument();
                            Controller.getInstance().saveRecommendation(recommendationSave);
                            response.setResult(recommendationSave);
                            break;
                        case SAVE_PURCHASE_ORDER_ITEM:
                            PurchaseOrderItem purchaseOrderItemSave = (PurchaseOrderItem) request.getArgument();
                            Controller.getInstance().savePurchaseOrderItem(purchaseOrderItemSave);
                            response.setResult(purchaseOrderItemSave);
                            break;                    
                        case DELETE_WORKER:
                            Worker workerDelete = (Worker) request.getArgument();
                            Controller.getInstance().deleteWorker(workerDelete);
                            response.setResult(workerDelete);
                            break;
                        case DELETE_PURCHASE_ORDER:
                            PurchaseOrder purchaseOrderDelete = (PurchaseOrder) request.getArgument();
                            Controller.getInstance().deletePurchaseOrder(purchaseOrderDelete);
                            response.setResult(purchaseOrderDelete);
                            break;
                        case DELETE_RECOMMENDATION:
                            Recommendation recommendationDelete = (Recommendation) request.getArgument();
                            Controller.getInstance().deleteRecommendation(recommendationDelete);
                            response.setResult(recommendationDelete);
                            break;
                        case DELETE_PURCHASE_ORDER_ITEM:
                            PurchaseOrderItem purchaseOrderItemDelete = (PurchaseOrderItem) request.getArgument();
                            Controller.getInstance().deletePurchaseOrderItem(purchaseOrderItemDelete);
                            response.setResult(purchaseOrderItemDelete);
                            break;
                        case UPDATE_ARTICLE:
                            Article articleUpdate = (Article) request.getArgument();
                            Controller.getInstance().updateArticle(articleUpdate);
                            response.setResult(articleUpdate);
                            break;
                        case UPDATE_CUSTOMER:
                            Customer customerUpdate = (Customer) request.getArgument();
                            Controller.getInstance().updateCustomer(customerUpdate);
                            response.setResult(customerUpdate);
                            break;
                        case UPDATE_WORKER:
                            Worker workerUpdate = (Worker) request.getArgument();
                            Controller.getInstance().updateWorker(workerUpdate);
                            response.setResult(workerUpdate);
                            break;
                        case UPDATE_PURCHASE_ORDER:
                            PurchaseOrder purchaseOrderUpdate = (PurchaseOrder) request.getArgument();
                            Controller.getInstance().updatePurchaseOrder(purchaseOrderUpdate);
                            response.setResult(purchaseOrderUpdate);
                            break;
   
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    response.setException(ex);
                }
                sender.send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
    }

    public Worker getCurrentWorker() {
        return currentWorker;
    }

    public Socket getSocket() {
        return socket;
    }
    
    
    
    
}
