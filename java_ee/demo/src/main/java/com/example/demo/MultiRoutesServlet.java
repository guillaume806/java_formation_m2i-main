package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// On peut définir plusieurs URL pour un même servlet en lui passant sous forme de tableau
// En utilisant une astérisque, l'URL peut se terminer par n'importe quoi
@WebServlet(name = "multiRoutesServlet", value = {"/multi-routes", "/multi", "/multi/*"})
public class MultiRoutesServlet extends HttpServlet {
    private List<String> prenoms;

    @Override
    public void init() throws ServletException {
        prenoms = new ArrayList<>();
        prenoms.add("John");
        prenoms.add("Maria");
        prenoms.add("Tao");
        prenoms.add("Mike");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // .getPathInfo() retourne le "reste" de l'URL (= partie correspondant à *)
        String pathInfo = (req.getPathInfo() != null && !req.getPathInfo().isEmpty()) ? req.getPathInfo() : "";
        String found = "";

        if(pathInfo != null && !pathInfo.isEmpty()) {
            // On retire le premier caractère du pathInfo (slash)
            found = prenoms.get(Integer.parseInt(pathInfo.substring(1)));
        }

        req.setAttribute("prenom", found);
        req.setAttribute("pathInfoB", pathInfo);

        getServletContext().getRequestDispatcher("/WEB-INF/multi.jsp").forward(req, resp);

    }
}
