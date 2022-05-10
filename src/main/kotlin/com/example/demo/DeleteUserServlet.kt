package com.example.demo

import UserDB
import model.User
import javax.servlet.http.*
import javax.servlet.annotation.*

@WebServlet("/delete-user")
class DeleteUserServlet : HttpServlet() {

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        servletContext.getRequestDispatcher("/deleteUser.html").forward(request, response)
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        try {
            val id = req.getParameter("user_id").toInt()

            val db = UserDB()
            db.deleteUser(id)
            resp.sendRedirect(req.contextPath + "/get-user")
        } catch (ex: Exception) {
            ex.printStackTrace()
            servletContext.getRequestDispatcher("/get-user").forward(req, resp)
        }
    }

    override fun destroy() {
    }
}