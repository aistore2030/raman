

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
        try {

            PrintWriter out = response.getWriter();
            System.out.println("52");
            String query = "";
            query = "insert into system_log( `servelet`, `logmsg` ) values "
                    + "('uploaddocument','" + request.getRequestURL().toString() + request.getQueryString() + "' )";
            System.out.println(query);
            String dbname = request.getParameter("dbname");
            System.out.println(dbname + "dbnamedbname");
           String id = request.getParameter("id").trim();
         

           Path path = Paths.get("S:\\ramandotest\\" + dbname + "\\" + id);
           // Path path = Paths.get("/opt/apache-tomcat-9.0.12/webapps/newraman/ROOT/web/upload/"+dbname+"/"+id);
            System.out.println(path);
           
            if (!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    //fail to create directory
                    e.printStackTrace();
                }
            }

            //File dir = new File("C:\\Users\\Saksham\\Documents\\ramandocument\\" +dbname+"\\"+id);
          // File dir = new File("S:\\ramandotest\\" +dbname+"\\"+id);

   //System.out.println(dir+"dir");

   /*File dir = new File("/root/Dropbox/img" + id);
    // attempt to create the directory here
            boolean successful = dir.mkdir();
            // System.out.println(successful+"successful");
         final String path = "/root/Dropbox/img" + id;*/
           
            Connection con = null;
            Statement st = null;
            con = Util.getConnection(dbname);
            st = con.createStatement();
            String username = (request.getParameter("username"));
             System.out.println(username);
           System.out.println(request.getParameter("apicall"));
           System.out.println(request.getParameter("fileToUpload"));
           System.out.println(request.getParameter("name"));
          //String filePath = (request.getParameter("filePath"));
         //  System.out.println("filePath"+filePath);
         // System.out.println(request);
         String name=null;
       if(ServletFileUpload.isMultipartContent(request)){
           System.out.println(12);
		            try {
		                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                       name = new File(item.getName()).getName();
		                        item.write( new File("S:/ramandotest/upload" + File.separator + name));
		                    }
		                }
		               //File uploaded successfully
		               request.setAttribute("gurumessage", "File Uploaded Successfully");
		            } catch (Exception ex) {
		               request.setAttribute("gurumessage", "File Upload Failed due to " + ex);
		            }         		
		        }else{
		
		            request.setAttribute("gurumessage","No File found");
 }
		        request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		   

            query = "update register set document='" + name + "' where id='" + id + "' ";
            System.out.println(query);
            int i = st.executeUpdate(query);
            if (i > 0) {
                request.setAttribute("msg", "Your setings Change Successfully!!");
                out.println("{\"Error\": \"False\" ,\"Message\": \" Image uploaded Successfully!!\"  }");
                System.out.println("{\"Error\": \"False\" ,\"Message\": \"Your settings Change Successfully!!\"  }");
            } else {
                out.println("{\"Error\": \"True\" ,\"Message\": \"Your setting is Invalid!!\"  }");
                System.out.println("{\"Error\": \"True\" ,\"Message\": \"Your settings are Invalid!!\"  }");
                request.setAttribute("msg", "Your setings is Invalid!!");

                RequestDispatcher rq = request.getRequestDispatcher("message.jsp");
                rq.forward(request, response);
                out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\"  }");
            }
           MultipartRequest m = new MultipartRequest(request, "S:\\ramandotest\\" + dbname + "\\" + id);
           
         //  MultipartRequest m = new MultipartRequest(request, "/opt/apache-tomcat-8.5.33/webapps/newraman/ROOT/web/upload/"+dbname+"/"+id);
           
         
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
