package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;


public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveNoteServlet() {
        super();
        
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//title, content fetch
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Note note = new Note(title,content,new Date());
//			note.setContent(content);
//			note.setTitle(title);
//			note.setAddedDate(new Date());
			
//			System.out.println(note.getId()+" : "+note.getTitle());
			
			//saving to the database
			
			Session session = FactoryProvider.getFactory().openSession();
			
			Transaction tx = session.beginTransaction();
			
			session.save(note);
			
			tx.commit();
			
			session.close();
			
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<h1 style='text-align:center'>Note is added successfully</h1>");
			writer.println("<h1 style='text-align:center'><a href='all_notes.jsp'>View All</a></h1>");

			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
