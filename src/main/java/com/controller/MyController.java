package com.controller;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmpPosTableManager;
import com.db.DAO.EmployeeTableManager;
import com.db.DAO.PositionTableManager;
import com.db.entity.Division;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController
{
    DivisionTableManager dtm = new DivisionTableManager();
    EmployeeTableManager etm = new EmployeeTableManager();
    EmpPosTableManager eptm = new EmpPosTableManager();
    PositionTableManager ptm = new PositionTableManager();

    @GetMapping("/")
    public String sayHello(Model model) {

        return "redirect:/divisions";
    }

    // /divisions

    @GetMapping("/divisions")
    public String divisions(Model model) {
        System.out.println("=========== " + "divisions" + " ===========");
        List<Division> divisionList = dtm.listAllDivisions();
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("divisionRequest", new DivisionRequest());

        return "divisions.jsp";
    }

    @GetMapping("/divisions/filter")
    public String divisionsFilter(
        @ModelAttribute("divisionRequest") DivisionRequest dr,
        Model model
    ) {
        System.out.println("=========== " + "divisionsFilter" + " ===========");
        List<Division> divisionList = dtm.listLike(dr.getGetName(), dr.getHeadDivName(), dr.getChiefName(), dr.getChiefSurname(), dr.getChiefPatronymic());
        model.addAttribute("divisionList", divisionList);

        return "divisions.jsp";
    }

    @GetMapping("/divisions/delete")
    public String deleteDivision(
        @ModelAttribute("divisionRequest") DivisionRequest dr,
        Model model
    ) {
        System.out.println("=========== " + "deleteDivision" + " ===========");
        dtm.delete(dtm.getById(dr.getId()));

        return "redirect:/divisions";
    }

    @GetMapping("/divisions/{id}")
    public String divisionInfo(Model model, @PathVariable String id) {
        System.out.println("=========== " + "divisionInfo" + " ===========");
        model.addAttribute("division", dtm.getById(Integer.parseInt(id)));

        return "divisionInfo.jsp";
    }

    @PostMapping("/divisions")
    public String addDivision(
    @ModelAttribute("divisionRequest") DivisionRequest dr,
    Model model
    ) {
        System.out.println("=========== " + "addDivision" + " ===========");
        Division div = new Division();
        div.setName(dr.getPostName());
        div.setChief(etm.getById(dr.getChiefId()));
        div.setHeadDiv(dtm.getById(dr.getHeadDivId()));
        dtm.save(div);

        return "redirect:/divisions";
    }

    // /positions

    @GetMapping("/positions")
    public String positions() {

        return "positions.jsp";
    }

    @GetMapping("/positions/{id}")
    public String positionInfo(Model model, @PathVariable String id) {
        model.addAttribute("position", ptm.getById(Integer.parseInt(id)));

        return "positionInfo.jsp";
    }

    // /employees

    @GetMapping("/employees")
    public String employees() {
        return "employees.jsp";
    }

    @GetMapping("/employees/{id}")
    public String employeeInfo(Model model, @PathVariable String id) {
        model.addAttribute("employee", etm.getById(Integer.parseInt(id)));

        return "employeeInfo.jsp";
    }

    @ModelAttribute
    public void addAtributes(Model model) {
        model.addAttribute("dtm", dtm);
        model.addAttribute("etm", etm);
        model.addAttribute("ptm", ptm);
        model.addAttribute("eptm", ptm);
    }
}
