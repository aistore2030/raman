/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author panel2
 */
public class test extends HttpServlet {

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
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Connection con = null;
        Statement st = null;
        PrintWriter out = response.getWriter();
        String c1 = request.getParameter("username");

        try {
            System.out.println(c1 + "c111111111");
            String c2 = request.getParameter("password");
            System.out.println(c2 + "c22222");
            String db = request.getParameter("dbname");
            System.out.println(db + "dbbbbbbbbbbbbbbb");
            // String id = request.getParameter("txid");
            ResultSet rs;
            con = Util.getConnection(db);
            st = con.createStatement();
            //////////////////////////////////
            String query2 = "SELECT  * FROM register where id=2";
            rs = st.executeQuery(query2);

            System.out.println(query2);
            boolean pass = true;

            String[] arrayss = new String[40];

            int index = 0;
            if (rs.next()) {
                System.out.println("checkArraycheckArray");
                for (index = 2; index < 36; index++) {

                    if (checkArray(rs.getString(index + 1))) {
                    } else {
                        pass = false;

                        break;

                    }

                }

            }
            System.out.println(arrayss);
            ///////////////////////////////////
            if(pass){
 System.out.println(pass+"pass");
             String query = "select *  from  register    where   c1='" + c1 + "' and  c2='" + c2 + "'    ";

                System.out.println(query);

                // PrintWriter out=response.getWriter(); 
                rs = st.executeQuery(query);

                if (rs.next()) {
                    System.out.println(61);
                    out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Roll\": \"" + rs.getString("c13") + "\"  ,\"Name\": \"" + rs.getString("c1") + "\",\"Email\": \"" + rs.getString("c1") + "\",\"Mobile\": \"" + rs.getString("c3") + "\",\"Avtar\": \"http://papafast.com:8080/MobiTop/ay/images/1.png\"}");

                } else {
                    out.println("{\"Error\": \"True\" ,\"Message\": \"Failed\"  }");
                    //  out.print("Username and Password are Invalid!!");
                }

            }
           else {
                    out.println("{\"Error\": \"True\" ,\"Message\": \"Database configuration error\"  }");
                    //  out.print("Username and Password are Invalid!!");
                }


        } catch (Exception e) {
            out.println(e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    protected boolean checkArray(String element) {
        System.out.println("checkArraycheckArray");
        String[] datatypes = {"varc", "numb", "deci", "date", "drop","hide"};
String e="varchar";
String f=e.substring(0,3);
String ee="varc";
String f2=ee.substring(0,4);
      System.out.println(f+"fffffffffff");
       System.out.println(f2+"ffff222222222fffffff");
        for (int i = 0; i <= 5; i++) {
            System.out.println("inside for");
            if (datatypes[i].equals(element.substring(0,4))) {
                return true;
            }
        }
        return false;
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
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
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
