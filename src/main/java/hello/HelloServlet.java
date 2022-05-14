/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;
import java.io.IOException;
import java.io.PrintWriter;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import org.json.JSONObject;  

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        Calendar c = Calendar.getInstance();
        int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
        String timeOfDay;

        if(hourOfDay >= 0 && hourOfDay < 12)
            timeOfDay = "morning";
        else if(hourOfDay >= 12 && hourOfDay < 18)
            timeOfDay = "afternoon";
        else if(hourOfDay >= 18 && hourOfDay < 24)
            timeOfDay = "evening";
        
        
        String string_json = "{\"pt\":{\"greeting\":\"Olá\",\"morning\":\"bomdia\",\"afternoon\":\"boatarde\",\"evening\":\"boanoite\",\"sr\":\"Sr.\",\"sra\":\"Sra.\",\"none\":\"\"},\"en\":{\"greeting\":\"Hello\",\"morning\":\"goodmorning\",\"afternoon\":\"goodafternoon\",\"evening\":\"goodevening\",\"sr\":\"Mr.\",\"sra\":\"Mrs\",\"none\":\"\"},\"fr\":{\"greeting\":\"Bonjour\",\"morning\":\"bonmatin\",\"afternoon\":\"bonaprès-midi\",\"evening\":\"bonnenuit\",\"sr\":\"Monsieur\",\"sra\":\"Mme\",\"none\":\"\"},\"de\":{\"greeting\":\"Hallo\",\"morning\":\"gutenmorgen\",\"afternoon\":\"gutentag\",\"evening\":\"gutenacht\",\"sr\":\"Herr\",\"sra\":\"Frau\",\"none\":\"\"},\"esp\":{\"greeting\":\"Hola\",\"morning\":\"buendía\",\"afternoon\":\"buenastardes\",\"evening\":\"buenasnoches\",\"sr\":\"señor\",\"sra\":\"Sra.\",\"none\":\"\"},\"hav\":{\"greeting\":\"Aloha\",\"morning\":\"alohakakahiaka\",\"afternoon\":\"alohaawakea,alohaAuinalā\",\"evening\":\"alohaahiahi\",\"sr\":\"'OMr\",\"sra\":\"Uaha'iaku'oMrs\",\"none\":\"\"},}";
        JSONObject json = new JSONObject(string_json);
        String msg = "";
        
        String lang = request.getParameter("lang");
        String treatment = request.getParameter("treatment");
        if(lang==null)
            lang = "pt";
        if(treatment==null)
            treatment = "none";
      
        msg = json.get(lang).get("greeting")+", "+json.get(lang).get(timeOfDay)+" "+json.get(lang).get(treatment)+" ";

        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
                Calendar c = Calendar.getInstance();
                int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
                String timeOfDay;
        
                if(hourOfDay >= 0 && hourOfDay < 12)
                    timeOfDay = "morning";
                else if(hourOfDay >= 12 && hourOfDay < 18)
                    timeOfDay = "afternoon";
                else if(hourOfDay >= 18 && hourOfDay < 24)
                    timeOfDay = "evening";
                
                
                String string_json = "{\"pt\":{\"greeting\":\"Olá\",\"morning\":\"bomdia\",\"afternoon\":\"boatarde\",\"evening\":\"boanoite\",\"sr\":\"Sr.\",\"sra\":\"Sra.\",\"none\":\"\"},\"en\":{\"greeting\":\"Hello\",\"morning\":\"goodmorning\",\"afternoon\":\"goodafternoon\",\"evening\":\"goodevening\",\"sr\":\"Mr.\",\"sra\":\"Mrs\",\"none\":\"\"},\"fr\":{\"greeting\":\"Bonjour\",\"morning\":\"bonmatin\",\"afternoon\":\"bonaprès-midi\",\"evening\":\"bonnenuit\",\"sr\":\"Monsieur\",\"sra\":\"Mme\",\"none\":\"\"},\"de\":{\"greeting\":\"Hallo\",\"morning\":\"gutenmorgen\",\"afternoon\":\"gutentag\",\"evening\":\"gutenacht\",\"sr\":\"Herr\",\"sra\":\"Frau\",\"none\":\"\"},\"esp\":{\"greeting\":\"Hola\",\"morning\":\"buendía\",\"afternoon\":\"buenastardes\",\"evening\":\"buenasnoches\",\"sr\":\"señor\",\"sra\":\"Sra.\",\"none\":\"\"},\"hav\":{\"greeting\":\"Aloha\",\"morning\":\"alohakakahiaka\",\"afternoon\":\"alohaawakea,alohaAuinalā\",\"evening\":\"alohaahiahi\",\"sr\":\"'OMr\",\"sra\":\"Uaha'iaku'oMrs\",\"none\":\"\"},}";
                var json = new JSONObject(string_json);
                String msg = "";
                
                String lang = request.getParameter("lang");
                String treatment = request.getParameter("treatment");
                if(lang==null)
                    lang = "pt";
                if(treatment==null)
                    treatment = "none";
              
                msg = json.get(lang).get("greeting")+", "+json.get(lang).get(timeOfDay)+" "+json.get(lang).get(treatment)+" ";

        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
