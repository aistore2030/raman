/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author newuser
 */
@MultipartConfig
public class uploadDocument extends HttpServlet {

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
        System.out.println("uploadDocument");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("52");
         String query="";
          query = "insert into system_log( `servelet`, `logmsg` ) values "
                    + "('uploaddocument','" + request.getRequestURL().toString() + request.getQueryString() + "' )";
            System.out.println(query);
              String dbname = request.getParameter("dbname");
           System.out.println(dbname+"dbnamedbname");
     // String id = request.getParameter("id").trim();
  String id="25";
        System.out.println(id+"id");
        
           
      //  System.out.println(id);
    
       
   //File dir = new File("/opt/apache-tomcat-8.5.33/webapps/raman/ROOT/"+dbname+"/" + id);
   
   File dir = new File("C://Users//Saksham//Documents//ramandocument/"+dbname+"/");
   
   //File dir = new File("/root/Dropbox/img" + id);
    // attempt to create the directory here
           // boolean successful = dir.mkdir();
            // System.out.println(successful+"successful");
         // final String path = "/root/Dropbox/img" + id;
         
         
       // final String path = "/opt/apache-tomcat-8.5.33/webapps/raman/ROOT/"+dbname+"/" + id;
        final String path = "C://Users//Saksham//Documents//ramandocument/"+dbname+"/";
        
       // Path p=new Path("C:\\NetBeans\\Raman\\image\\" + id);
       
        if (!dir.exists()) {
            System.out.println("inside if");
   //  boolean successful = dir.mkdir();
           //  System.out.println(successful+"successful");
           
           if (dir.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
}
       
        
        Connection con = null;
        Statement st = null;
       // String db=request.getParameter("dbname");
    try {

            con = Util.getConnection(dbname);
            st = con.createStatement();
         
            //System.out.println("apicalll");
            String username = (request.getParameter("username"));
         //   System.out.println(request.getParameter("apicall"));
            System.out.println(username);
            
            final Part pic = request.getPart("pic");
            System.out.println(43);
            System.out.println(pic);
         
            System.out.println(47);
         
            final String fileName = Paths.get(pic.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = pic.getInputStream();
         
            System.out.println(pic);
            System.out.println(fileName + "fileName");
            System.out.println(fileContent + "fileContent");
            System.out.println("<!DOCTYPE html>");

            OutputStream o = new FileOutputStream(new File(path + File.separator
                    + fileName));

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                o.write(bytes, 0, read);
            }
            System.out.println("New file " + fileName + " created at " + path);
            
       query = "update register set document='" + fileName + "' where id='" + id + "' ";
            System.out.println(query);
            int i = st.executeUpdate(query);
            if (i > 0) {
                request.setAttribute("msg", "Your setings Change Successfully!!");
                out.println("{\"Error\": \"False\" ,\"Message\": \" Image uploaded Successfully!!\"  }");
                System.out.println("{\"Error\": \"False\" ,\"Message\": \"Your setings Change Successfully!!\"  }");
            } else {
                out.println("{\"Error\": \"True\" ,\"Message\": \"Your setings is Invalid!!\"  }");
                System.out.println("{\"Error\": \"True\" ,\"Message\": \"Your setings is Invalid!!\"  }");
                request.setAttribute("msg", "Your setings is Invalid!!");

                RequestDispatcher rq = request.getRequestDispatcher("message.jsp");
                rq.forward(request, response);
                out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\"  }");
            }
        } catch (SQLException ex) {
            Logger.getLogger(uploadDocument.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(uploadDocument.class.getName()).log(Level.SEVERE, null, ex);
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

}
