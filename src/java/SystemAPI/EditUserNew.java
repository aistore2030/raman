/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saksham
 */
public class EditUserNew extends HttpServlet {

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
        System.out.println("EditUserNew");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
  
        try {
        String db=request.getParameter("dbname");
            Connection con = Util.getConnection(db);
            Statement st = con.createStatement();

            String b[] = new String[50];
        
            String id = request.getParameter("id").trim();
            System.out.println(id + "id");
         String st1="";
             st1 = request.getParameter("st");
            System.out.println(st1 + "st1");
            System.out.println(st1 + "st1st1st1st1st1st1st1st1");
            int j = 0;
            int count = Integer.parseInt(request.getParameter("count").trim());

            System.out.println(id + st1 + count + "4355555555555555555555553");
            ////////////////////////////////
            String query = "select top 1 * from register  ";

            System.out.println(query);
            ResultSet rs3 = st.executeQuery(query);
            String[] carray = new String[60];
            int column_count = 0;
            while (rs3.next()) {
                column_count = Integer.parseInt(rs3.getString("column_count").trim());
                System.out.println(column_count);
                System.out.println("ccccccccccccccc");
                for (int i = 0; i < column_count + 4; i++) {
                    System.out.println("forrrrrrr");
                    if (i == 0) {
                        carray[i] = "id";
                        System.out.println("iffffffffff");
                    } else {
                        System.out.println("elseeeeeee");
                        carray[i] = rs3.getString(i + 5);

                    }
                    //System.out.println(carray[i]);
                    carray[50] = rs3.getString("column_count");
                    carray[51] = rs3.getString("document");
                    System.out.println("2222222222222");
                }
            }

            String message = "Hello,"
                    + "You have upload following data in the system"
                    + "<table>";
            System.out.println("33333333333333");
            //////////////////////////////////////////
            // System.out.println(count);
            String c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30;

            for (int i = 0; i < 50; i++) {
                System.out.println(count+"count");
                if (i < count) {
                    j = i + 3;
                    System.out.println(j + "5555555555555");
                    b[i] = new String(request.getParameter("c" + j).getBytes("UTF-8"), "UTF-8");
                    System.out.println(j+"jjjj");
System.out.println(request.getParameter("c" + j)+"c[value]");
                   
                      System.out.println(i+"i"+b[i]+"=c"+j+"tttttttttttttttt");
                    int ccount = Integer.parseInt(carray[50]);
           
                    if ((i >= 2) && (i <= (ccount + 2))) {
                    
                        message = message + "<tr><td>" + carray[i] + "</td><td>" + b[i] + "</td></tr>";
                    }

                } else {
                    System.out.println("9999999999999");
                    b[i] = null;
                }
                //  System.out.println(b[i]);
            }
            //    log.info(new String(data.toString().getBytes("UTF-8"), "UTF-8"));

            message = message + "</table>";

          /*  query = "update register set c3='" + b[0] + "'  , c4='" + b[1] + "', c5='" + b[2] + "', c6='" + b[3] + "'"
                    + ", c7='" + b[4] + "', c8='" + b[5] + "', c9='" + b[6] + "', c10='" + b[7] + "', c11='" + b[8] + "',"
                    + " c12='" + b[9] + "', c13='" + b[10] + "', c14='" + b[11] + "', c15='" + b[12] + "', c16='" + b[13] + "', c"
                    + "17='" + b[14] + "', c18='" + b[15] + "', c19='" + b[16] + "', c20='" + b[17] + "', c21='" + b[18] + "', c22='" + b[19] + "', c"
                    + "23='" + b[20] + "', c24='" + b[21] + "', c25='" + b[22] + "', c26='" + b[23] + "', c27='" + b[24] + "', c28='" + b[25] + "', c29"
                    + "='" + b[26] + "', c30='" + b[27] + "', c31='" + b[28] + "', c32='" + b[29] + "', c33='" + b[30] + "', updated_on=GETDATE() , status='" + st1 + "'"
                    + " where id=" + id + "  ";*/
             query = "update register set c3='" + b[0] + "'  , c4='" + b[1] + "', c5='" + b[2] + "', c6='" + b[3] + "'"
                    + ", c7='" + b[4] + "', c8='" + b[5] + "', c9='" + b[6] + "', c10='" + b[7] + "', c11='" + b[8] + "',"
                    + " c12='" + b[9] + "', c13='" + b[10] + "', c14='" + b[11] + "', c15='" + b[12] + "', c16='" + b[13] + "', c"
                    + "17='" + b[14] + "', c18='" + b[15] + "', c19='" + b[16] + "', c20='" + b[17] + "', c21='" + b[18] + "', c22='" + b[19] + "', c"
                    + "23='" + b[20] + "', c24='" + b[21] + "', c25='" + b[22] + "', c26='" + b[23] + "', c27='" + b[24] + "', c28='" + b[25] + "', c29"
                    + "='" + b[26] + "', c30='" + b[27] + "', c31='" + b[28] + "', c32='" + b[29] + "', c33='" + b[30] + "', c34='" + b[31] + "', c35='" + b[32] + "', c36='" + b[33] + "', updated_on=GETDATE() , status='" + st1 + "'"
                    + " where id=" + id + "  ";
          
            message = message;
            System.out.println(query);
            int i = st.executeUpdate(query);

            if (i > 0) {
                request.setAttribute("msg", "Your Details updated Successfully!!");
                System.out.println(b[1]);
                 if(st1.equals("Updated")){  
                     
                email(message, b[1]);
                 }
                // send email 
                out.println("{\"Error\": \"False\" ,\"Message\": \"success\",\"status\": \"success\"  }");

            } else {
                request.setAttribute("msg", "Your Details  are Invalid!!");
                out.println("{\"Error\": \"False\" ,\"Message\": \"Failed\",\"status\": \"Failed\" }");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\" ,\"status\": \"Failed\"  }");
            e.printStackTrace();
        }

    }

    public String email(String message, String email)
            throws ServletException, IOException {
  System.out.println("email function");
        try {
            System.out.println(email);
            String encoding = "UTF-8";
        //email = "sakshamapp123@gmail.com";
           
            String content = "";
            System.out.println(content);

            System.out.println(message);
            String data = "apikey=" + URLEncoder.encode("8717476d-a1c6-4c8b-9ba5-8ef790535970", encoding);

            data += "&from=" + URLEncoder.encode("info.oconnector@gmail.com", encoding);
            System.out.println(111);
            data += "&fromName=" + URLEncoder.encode("info.oconnector@gmail.com", encoding);
            System.out.println(222);
            data += "&subject=Data updating copy";

            data += "&bodyHtml=" + URLEncoder.encode(message, encoding);
            System.out.println(email);
            data += "&to=" + URLEncoder.encode(email, encoding);
            data += "&isTransactional=" + URLEncoder.encode("true", encoding);
            System.out.println(111);
            URL url = null;
            try {
                System.out.println(123);
                url = new URL("https://api.elasticemail.com/v2/email/send");
            } catch (MalformedURLException ex) {
                //  Logger.getLogger(SystemFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            BufferedReader rd;
            String result;
            try (OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
                wr.write(data);
                wr.flush();
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                result = rd.readLine();

                System.out.println(result);
                return result;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SystemFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
