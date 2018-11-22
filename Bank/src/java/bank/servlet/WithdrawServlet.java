/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.servlet;

import bank.controller.AccountJpaController;
import bank.controller.HistoryJpaController;
import bank.model.Account;
import bank.model.History;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Student
 */
public class WithdrawServlet extends HttpServlet {
@PersistenceUnit (unitName = "BankPU")
EntityManagerFactory  emf;
@Resource
UserTransaction utx;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
       HttpSession session = request.getSession(false);
       String withdraw = request.getParameter("withdraw");
       
       if(withdraw != null && withdraw.trim().length()>0 ){
           AccountJpaController accountCtrl = new AccountJpaController(utx, emf);
           Account accountObj = accountCtrl.findAccount(((Account)session.getAttribute("accountObj")).getAccountid());
           int withdraws = Integer.parseInt(withdraw);
           int balance = accountObj.getBalance();
           if(withdraws > 0 && balance-withdraws >=0){
               int sum = balance - withdraws;
               accountObj.setBalance(sum);
               
               HistoryJpaController historyCtrl = new HistoryJpaController(utx, emf);
               History history = new History(historyCtrl.getHistoryCount()+1);
               history.setAccountid(accountObj);
               history.setAmount(withdraws);
               history.setBalance(sum);
               history.setMethod("withdraw");
               history.setTime(new Date());
               historyCtrl.create(history);
               
               List<History> historyList = historyCtrl.findHistoryEntities();
               List<History> history_add = new ArrayList<>();
               
               for (History htr : historyList) {
                   if(Objects.equals(history.getAccountid().getAccountid(), accountObj.getAccountid())){
                       history_add.add(htr);
                   }
                 
               }
               
               accountObj.setHistoryList(history_add);
               accountCtrl.edit(accountObj);
               session.setAttribute("accountObj", accountObj);
               request.setAttribute("status", "withdraw successful");
               getServletContext().getRequestDispatcher("/MyAccount.jsp").forward(request, response);
               return;
           }
           
           request.setAttribute("status", "withdraw error");
               getServletContext().getRequestDispatcher("/Withdraw.jsp").forward(request, response);
       }
       getServletContext().getRequestDispatcher("/Withdraw.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (Exception ex) {
        Logger.getLogger(WithdrawServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (Exception ex) {
        Logger.getLogger(WithdrawServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
