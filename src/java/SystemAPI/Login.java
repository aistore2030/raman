/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
import org.json.JSONObject;

/**
 *
 * @author panel2
 */
public class Login extends HttpServlet {

    private String name="BRCMuskra";
    
    private String email="brc@g.c";
    private String support="9238483234";
    private String address="BRCMuskra";
    private String purchase_date="07-07-19";
    private String expiry_date="30-07-19";

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
        Statement st1 = null;
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
            ResultSet rs1;
            con = Util.getConnection(db);
            st = con.createStatement();
            st1 = con.createStatement();
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
            if (pass) {
                System.out.println(pass + "pass");
                String query = "select *  from  register    where   c1='" + c1 + "' and  c2='" + c2 + "'    ";

                System.out.println(query);

                rs = st.executeQuery(query);

                if (rs.next()) {
                    String query1 = "select documentname from register where id=2";
                    System.out.println(query1);

                    rs1 = st1.executeQuery(query1);

                    System.out.println(61);
                    Login output= Customer(db) ;
                    
                    
                    out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Roll\": \"" + rs.getString("roll") + "\"  ,\"Name\": \"" + rs.getString("c1") + "\",\"Email\": \"" + rs.getString("c4") + "\",\"Mobile\": \"" + rs.getString("c3") + "\",\"DocumentName\": \"" + rs.getString("documentname") + "\",\"Mastername\": \"" +output.name + "\","
                            + "\"masterEmail\": \"" +output.email + "\",\"Mastersupport\": \"" + output.support + "\",\"MasterAddress\": \"" + output.address+ "\",\"purches_date\": \"" + output.purchase_date + "\",\"expiry_date\": \"" + output.expiry_date + "\",\"Avtar\": \"http://papafast.com:8080/MobiTop/ay/images/1.png\"}");

                } else {
                    out.println("{\"Error\": \"True\" ,\"Message\": \"Failed\"  }");

                }

            } else {
                out.println("{\"Error\": \"True\" ,\"Message\": \"Database configuration error\"  }");

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
        String[] datatypes = {"varc", "numb", "deci", "date", "drop", "hide", "disa"};
        String e = "varchar";
        String f = e.substring(0, 3);
        System.out.println(f + "fffffffffff");
        for (int i = 0; i <= 6; i++) {
            System.out.println("inside for");
            if (datatypes[i].equals(element.substring(0, 4))) {
                return true;
            }
        }
        return false;
    }

    protected Login Customer(String db) throws Exception {
        Connection con = null;
        Statement st1 = null;
        Statement st = null;

        System.out.println(db + "dbbbbbbbbbbbbbbb");

        ResultSet rs;
        ResultSet rs1;
        con = Util.getConnectionS();
        st = con.createStatement();
    

        String query2 = "SELECT  * FROM brcmaster  where dbpin='" + db + "'";
        rs = st.executeQuery(query2);
System.out.println(query2);
        System.out.println(66);
        Login a1 = new Login();
        if (rs.next()) {

            a1.name = rs.getString("name");
            a1.email = rs.getString("email");
            a1.support = rs.getString("contact1");
            a1.address = rs.getString("address");
            a1.purchase_date = rs.getString("purchase_date");
            a1.expiry_date = rs.getString("expiry_date");
            //a.add(a1);
            //out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"name\": \"" + rs.getString("name") + "\",\"email\": \"" + rs.getString("email") + "\",\"support\": \"" + rs.getString("support") + "\",\"address\": \"" + rs.getString("address")+ "\",\"purches_date\": \"" + rs.getString("purches_date") + "\",\"expiry_date\": \"" + rs.getString("expiry_date") + "\"}");
        }
         
        return a1;
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
            Logger.getLogger(test.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (Exception ex) {
            Logger.getLogger(test.class
.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(test.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (Exception ex) {
            Logger.getLogger(test.class
.getName()).log(Level.SEVERE, null, ex);
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
