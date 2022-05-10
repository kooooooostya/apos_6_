package com.example.demo

import UserDB
import javax.servlet.http.*
import javax.servlet.annotation.*

@WebServlet(name = "get_users", value = ["/get-user"])
class GetUsersServlet : HttpServlet() {
    private lateinit var message: String

    override fun init() {
        message = "Empty"
    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"

        val db = UserDB()
        val users = db.selectAllUsers()

        // Hello
        val out = response.writer
        out.println("<html><body>")

        out.println("<h1>Users:</h1>")

        users.forEach{
            out.println("<h2>$it</h2>")
        }
        out.println("</body></html>")
    }

    override fun destroy() {
    }
}