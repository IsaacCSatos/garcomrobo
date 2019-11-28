package servlets;

// https://www.javaguides.net/2019/03/jsp-servlet-jdbc-mysql-crud-example-tutorial.html

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Pedido;
import dao.PedidoDao;

@WebServlet(urlPatterns = { "/pedido", "/pedido/", "/pedido/nova", "/pedido/adiciona", "/pedido/remove", "/pedido/altera",
		"/pedido/edita" })
public class PedidoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PedidoDao pedidoDao;

	public void init() {
		pedidoDao = new PedidoDao();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getServletPath();

		try {
			if (acao.equals("/pedido/adiciona")) {
				adiciona(request, response);
			} else if (acao.equals("/pedido/altera")) {
				altera(request, response);
			} else if (acao.equals("/pedido/nova")) {
				nova(request, response);
			} else if (acao.equals("/pedido/edita")) {
				edita(request, response);
			} else if (acao.equals("/pedido/remove")) {
				remove(request, response);
			} else {
				lista(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Pedido pedido = new Pedido();
		pedido.setValorTotal(Double.parseDouble(request.getParameter("valorTotal")));
		pedido.setStatus(request.getParameter("status"));

		try {
			pedidoDao.adiciona(pedido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/pedido");
	}

	private void altera(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(Integer.parseInt(request.getParameter("id")));
		pedido.setValorTotal(Double.parseDouble(request.getParameter("valorTotal")));
		pedido.setStatus(request.getParameter("status"));

		pedidoDao.altera(pedido);
		response.sendRedirect("/pedido");
	}

	private void nova(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		request.setAttribute("pedido", pedido);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pedido/manter.jsp");	
		dispatcher.forward(request, response);	
	}
	
	private void edita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		int id = Integer.parseInt(request.getParameter("id"));

		pedido = pedidoDao.getById(id);
        request.setAttribute("pedido", pedido);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pedido/manter.jsp");	
		dispatcher.forward(request, response);
	}	

	private void remove(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(Integer.parseInt(request.getParameter("id")));

		pedidoDao.remove(pedido);
		response.sendRedirect("/pedido");
	}

	private void lista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List <Pedido> pedidos = pedidoDao.getLista();
        request.setAttribute("pedidos", pedidos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pedido/consulta.jsp");
        dispatcher.forward(request, response);		

	}

}
