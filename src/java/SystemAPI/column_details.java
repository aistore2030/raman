/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sakshamapp123
 */
public class column_details extends HttpServlet {

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
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Connection con = null;
        Statement st = null;

       
        try {
            PrintWriter out = response.getWriter();
            con = Util.getConnection();

            st = con.createStatement();
            String username = request.getParameter("username");
            System.out.print(username);
            ResultSet rs = st.executeQuery("SELECT * FROM register");
            System.out.print(rs);
            System.out.print(1);
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println(2);
int columnCount = rsmd.getColumnCount();

System.out.println(3);
  ArrayList<ArrayList<String>>  rData = new ArrayList<ArrayList<String>>();
 System.out.println(4);

int col = 0;
            
while(rs.next())
    {System.out.print(6);
     
      if(col != columnCount)
          {
              System.out.println(7);
            for(int x = 1;x <= columnCount;x++){
               
                 ArrayList<String> tFields = new ArrayList<>();
                
                 tFields.add(rsmd.getColumnName(x));
                 System.out.print(rsmd.getColumnName(x));
                 rData.add(tFields);
                
             }
           col = columnCount;
          }
     }  rs.close();
 
System.out.print("nmmmm");
 //return tableVector; 
             Gson gson = new Gson();
            String messages = gson.toJson(rData);
            out.println(messages);
System.out.print(messages);
        } catch (Exception e) {
            System.out.println(e);
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
public String c1;
public String c2;
public String c3;
public String c4;
public String c5;
public String c6;
 
}
