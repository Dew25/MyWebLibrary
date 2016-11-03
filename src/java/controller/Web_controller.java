/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Reader;
import java.io.IOException;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ReaderFacade;

/**
 *
 * @author jvm
 * Что-бы зарегистрировать сервлет на сервере используется аннотация вида @WebServlet. 
 * В данный момент в ней указана имя сервлета и адреса вызовов которые будет обрабатывать сервлет.
 */
@WebServlet(name = "WebController",loadOnStartup = 1, urlPatterns = {"/book","/reader"})
public class Web_controller extends HttpServlet {

    @EJB
    ReaderFacade readerFacade;

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("readers", readerFacade.findAll());
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request содержит информацию полученную от пользователя
     * @param response содержит информацию которая будет передана пользователю
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Метод getServletPath() - возвращает путь по которому
        // обратился пользователь.
        String userPath=request.getServletPath();
        if("/reader".equals(userPath)){
            //обработка запроса "/reader"
           
        } else if("/book".equals(userPath)){
            //обработка запроса "/book"
//             String reader_id = null;
//            Enumeration<String> params = request.getParameterNames();
//            while(params.hasMoreElements()){
//                String param = params.nextElement();
//                reader_id="reader_id".equals(param)?request.getParameter(param):reader_id;
//            }
//            try {
//                Reader reader = readerFacade.find(Integer.parseInt(reader_id));
//                request.setAttribute("books", reader.getBooks());
//            } catch (Exception e) {
//                
//            }
        }
        
        request.getRequestDispatcher("/WEB-INF/view"+userPath+".jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
