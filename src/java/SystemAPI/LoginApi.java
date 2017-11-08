/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory; 
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author sakshamapp123
 */
public class LoginApi extends HttpServlet {
     HttpTransport transport = new NetHttpTransport();

    JsonFactory jsonFactory = new JacksonFactory();
    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setAudience(Collections.singletonList("638288972243-ir0bdga56vst8aqqe3ueeurnk8vlq3r9.apps.googleusercontent.com"))
            // Or, if multiple clients access the backend:
            //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .setIssuer("https://accounts.google.com")
            .build();
    
    GoogleIdTokenVerifier verifier2 = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setAudience(Collections.singletonList("638288972243-ir0bdga56vst8aqqe3ueeurnk8vlq3r9.apps.googleusercontent.com"))
            // Or, if multiple clients access the backend:
            //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .setIssuer("accounts.google.com")
            .build();

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
        PrintWriter out = response.getWriter();
       
        try{
            
        GoogleIdToken idToken = verifier.verify(request.getParameter("token"));
        
        if (idToken == null) {
            idToken = verifier2.verify(request.getParameter("token"));
            System.out.println("LOGIN - Verifier 2");
        }
        if (idToken != null) {
            // Success. Return success respone here.
            Payload payload = idToken.getPayload();
            
            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");
            System.out.println("LOGIN - Success");
            
            // For Checking email exists or not in Database
            try {
                Connection con = Util.getConnection();
                Statement st = con.createStatement();
                String query = "select password from register where username='" + email + "'";
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {
                    // If user found in database
                    System.out.println("LOGIN - User Found");
                    String password = rs.getString(1);
                    out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Name\": \""+name+"\",\"Email\": \""+email+"\",\"Avtar\": \"http://papafast.com:8080/MobiTop/ay/images/1.png\",\"Password\":\""+password+"\"}");
                }else{
                    // If user not found in database. WE have to add new entry.
                    String password = getSaltString();
                    String insertQuery = "INSERT INTO register (name,username,password,email) VALUES ('"+name+"','"+email+"','"+password+"','"+email+"')";
                    st.executeUpdate(insertQuery);
                    System.out.println("LOGIN - New User Registered");
                    out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Name\": \""+name+"\",\"Email\": \""+email+"\",\"Avtar\": \"http://papafast.com:8080/MobiTop/ay/images/1.png\",\"Password\":\""+password+"\"}");
                }
            } catch (Exception ex) {
                out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\"  }");
                Logger.getLogger(LoginApi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            // Error. Return Error message here.
            System.out.println("LOGIN - Failure");
            out.println("{\"Error\": \"True\" ,\"Message\": \"Failed\"  }");
        }
        }catch(GeneralSecurityException e){
            // Exception. Return exception message here.
            System.out.println("LOGIN - Exception");
            out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\"  }");
        }catch(Exception e){
            // Exception. Return exception message here.
            System.out.println("LOGIN - Exception. Invalid Token");
            out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed. Invalid Token\"  }");
        }
               
   
    }
    
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
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
