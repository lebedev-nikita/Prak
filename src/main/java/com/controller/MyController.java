package com.controller;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmpPosTableManager;
import com.db.DAO.EmployeeTableManager;
import com.db.DAO.PositionTableManager;
import com.db.entity.Division;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController
{
    DivisionTableManager dtm = new DivisionTableManager();
    EmployeeTableManager etm = new EmployeeTableManager();
    EmpPosTableManager eptm = new EmpPosTableManager();
    PositionTableManager ptm = new PositionTableManager();

    @GetMapping("/")
    public String sayHello(Model model)
    {
        return "redirect:/divisions/";
//        model.addAttribute("message", "hello");
//        return "hello.jsp";
    }

    @GetMapping("/divisions")
    public String divisions(Model model) {
        model.addAttribute("dtm", dtm);
        model.addAttribute("etm", etm);
        model.addAttribute("ptm", ptm);
        model.addAttribute("eptm", ptm);
        return "divisions.jsp";
    }

    @PostMapping("/divisions")
    public String addDivision(
            @ModelAttribute("postDivision") PostDivision postDivision,
            Model model
    ) {
//        System.out.println(postDivision.getName());
//        System.out.println(postDivision.getHeadDivId());
//        System.out.println(postDivision.getChiefId());
        Division div = new Division();
        div.setName(postDivision.getName());
        div.setChief(etm.getById(postDivision.getChiefId()));
        div.setHeadDiv(dtm.getById(postDivision.getHeadDivId()));
        dtm.save(div);

//        dtm.save(division);
        return "divisions.jsp";
    }

    @GetMapping("/divisions/{id}")
    public String divisionInfo(Model model, @PathVariable String id) {
        model.addAttribute("division", dtm.getById(Integer.parseInt(id)));
        model.addAttribute("dtm", dtm);
        model.addAttribute("etm", etm);
        model.addAttribute("ptm", ptm);
        model.addAttribute("eptm", eptm);
        return "divisionInfo.jsp";
    }

    @GetMapping("/positions")
    public String positions() {
        return "positions.jsp";
    }

    @GetMapping("/positions/{id}")
    public String positionInfo(Model model, @PathVariable String id) {
        model.addAttribute("position", ptm.getById(Integer.parseInt(id)));
        model.addAttribute("dtm", dtm);
        model.addAttribute("etm", etm);
        model.addAttribute("ptm", ptm);
        model.addAttribute("eptm", eptm);
        return "positionInfo.jsp";
    }

    @GetMapping("/employees")
    public String employees() {
        return "employees.jsp";
    }

    @GetMapping("/employees/{id}")
    public String employeeInfo(Model model, @PathVariable String id) {
        model.addAttribute("employee", etm.getById(Integer.parseInt(id)));
        model.addAttribute("dtm", dtm);
        model.addAttribute("etm", etm);
        model.addAttribute("ptm", ptm);
        model.addAttribute("eptm", eptm);
        return "employeeInfo.jsp";
    }

    @ModelAttribute
    public void addAtributes(Model model) {
        model.addAttribute("postDivision", new PostDivision());
    }
}
