package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String title = request.getParameter("title");
			
			String content = request.getParameter("content");

			int id = Integer.parseInt(request.getParameter("noteId").trim());
			
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			
			Note note = session.get(Note.class, id);
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			
			tx.commit();
			session.close();
			
			response.sendRedirect("all_notes.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
