package com.soat.happyref.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.soat.happyref.beans.Book;
import com.soat.happyref.exceptions.TechniqueException;

/**
 * @author formation
 * 
 */
public class BookDAOImp implements BookDAO {

	private static String SelectAllBooksQuery = "SELECT * FROM book ORDER BY title";
	private static String SelectBooksByCategory = "SELECT * FROM book b, category_book cb "
			+ "WHERE b.isbn=cb.isbn AND cb.id_category=? ORDER BY title";

	private static String SelectBookById = "SELECT * FROM book b WHERE b.isbn=?";
	private static String SearchBooks = "SELECT * FROM book b "
			+ "WHERE b.isbn LIKE ? OR b.author LIKE ? OR b.title LIKE ? OR b.long_description LIKE ?";

	@Override
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/happyreHibernatefDS");

			if (ds != null) {

				Connection conn = ds.getConnection();
				Statement st = conn.createStatement();
				// exécution de la requête
				ResultSet rs = st.executeQuery(SelectAllBooksQuery);
				// récupération des données
				while (rs.next()) {
					Book book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs
							.getString("image_name"), rs.getString("short_description"), rs
							.getString("long_description"));
					books.add(book);
				}

				rs.close();
				st.close();
				conn.close();
			}

		} catch (Exception e) {
			System.err.println("Erreur de connexion : " + e.getMessage());
		}
		return books;
	}

	@Override
	public ArrayList<Book> getBooksByCategory(String categoryId) {
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/happyreHibernatefDS");

			if (ds != null) {
				Connection conn = ds.getConnection();
				PreparedStatement st = conn.prepareStatement(SelectBooksByCategory);
				// exécution de la requête
				st.setInt(1, Integer.parseInt(categoryId));
				ResultSet rs = st.executeQuery();
				// récupération des données
				while (rs.next()) {
					Book book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs
							.getString("image_name"), rs.getString("short_description"), rs
							.getString("long_description"));
					books.add(book);
				}

				rs.close();
				st.close();
				conn.close();
			}
		} catch (Exception e) {
			System.err.println("Erreur de connexion : " + e.getMessage());
		}
		return books;
	}

	@Override
	public Book getBookById(String id) {
		Book book = null;
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/happyreHibernatefDS");

			if (ds != null) {
				Connection conn = ds.getConnection();
				PreparedStatement st = conn.prepareStatement(SelectBookById);
				// exécution de la requête
				st.setString(1, id);
				ResultSet rs = st.executeQuery();
				// récupération des données
				if (rs.next()) {
					book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs
							.getString("image_name"), rs.getString("short_description"), rs
							.getString("long_description"));
				}

				rs.close();
				st.close();
				conn.close();
			}
		} catch (Exception e) {
			System.err.println("Erreur de connexion : " + e.getMessage());
		}
		return book;
	}

	@Override
	public ArrayList<Book> getBooksByKeyWord(String word) throws TechniqueException {
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/happyreHibernatefDS");

			if (ds != null) {
				Connection conn = ds.getConnection();
				PreparedStatement st = conn.prepareStatement(SearchBooks);
				// exécution de la requête
				st.setString(1, "%" + word + "%");
				st.setString(2, "%" + word + "%");
				st.setString(3, "%" + word + "%");
				st.setString(4, "%" + word + "%");
				ResultSet rs = st.executeQuery();
				// récupération des données
				while (rs.next()) {
					Book book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs
							.getString("image_name"), rs.getString("short_description"), rs
							.getString("long_description"));
					books.add(book);
				}

				rs.close();
				st.close();
				conn.close();
			}
		} catch (Exception e) {
			System.err.println("Erreur de connexion : " + e.getMessage());
			throw new TechniqueException("Erreur de conexion dans BookDAO");
		}
		return books;
	}

}
