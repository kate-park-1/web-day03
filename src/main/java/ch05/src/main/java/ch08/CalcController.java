package ch08;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calcControl")
public class CalcController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int num1 = Integer.parseInt(req.getParameter("num1"));
    int num2 = Integer.parseInt(req.getParameter("num2"));
    String op = req.getParameter("op");
    String message = "";
    int result=0;
    switch(op) {
      case "+":
        result = num1 + num2; break;
      case "-":
        result = num1 - num2; break;
      case "*":
        result = num1 * num2; break;
      case "/":
        if(num2 == 0) {
          result = 0;
          message = "0으로 나눌 수 없습니다.";
        } else result = num1 / num2;
        break;
    }
    req.setAttribute("result", result);
    req.setAttribute("message", message);
    RequestDispatcher reqDispatcher = getServletContext().getRequestDispatcher("/ch08/calcResult.jsp");
    reqDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req,resp);
  }
}
