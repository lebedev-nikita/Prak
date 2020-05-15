package com.controller;

import com.controller.requests.*;
import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmpPosTableManager;
import com.db.DAO.EmployeeTableManager;
import com.db.DAO.PositionTableManager;
import com.db.entity.Division;
import com.db.entity.EmpPos;
import com.db.entity.Employee;
import com.db.entity.Position;
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
        List<Division> divisionList = dtm.listLike(dr.getGetName(), dr.getHeadDivName(), dr.getChiefName(), dr.getChiefSurname(), dr.getChiefPatronymic());
        model.addAttribute("divisionList", divisionList);

        return "divisions.jsp";
    }

    @GetMapping("/divisions/delete")
    public String deleteDivision(
        @ModelAttribute("divisionRequest") DivisionRequest dr,
        Model model
    ) {
        dtm.delete(dtm.getById(dr.getId()));

        return "redirect:/divisions";
    }

    @PostMapping("/divisions")
    public String addDivision(
        @ModelAttribute("divisionRequest") DivisionRequest dr,
        Model model
    ) {
        Division div = new Division();
        div.setName(dr.getPostName());
        div.setChief(etm.getById(dr.getChiefId()));
        div.setHeadDiv(dtm.getById(dr.getHeadDivId()));
        dtm.save(div);

        return "redirect:/divisions";
    }

    // /divisionInfo

    @GetMapping("/divisions/{id}")
    public String divisionInfo(Model model, @PathVariable String id) {
        model.addAttribute("division", dtm.getById(Integer.parseInt(id)));
        model.addAttribute("divisionInfoRequest", new DivisionInfoRequest());

        return "divisionInfo.jsp";
    }

    @PostMapping("/divisions/{id}/update")
    public String divisionInfoUpdate(
        @ModelAttribute("divisionInfoRequest") DivisionInfoRequest divir,
        @PathVariable String id,
        Model model
    ) {
        Division div = dtm.getById(Integer.parseInt(id));
        if (divir.getNewChiefId() != 0) { div.setChief(etm.getById(divir.getNewChiefId())); }
        if (divir.getNewHeadDivisionId() != 0) { div.setHeadDiv(dtm.getById(divir.getNewHeadDivisionId())); }
        if (divir.getNewName() != null) { div.setName(divir.getNewName()); }

        dtm.update(div);

        return "redirect:/divisions/" + id;
    }

    // /positions

    @GetMapping("/positions")
    public String positions(Model model) {
        List<Position> positionList = ptm.listAllPositions();
        model.addAttribute("positionList", positionList);
        model.addAttribute("positionRequest", new PositionRequest());

        return "positions.jsp";
    }

    @GetMapping("/positions/delete")
    public String positionsDelete(
        @ModelAttribute("positionRequest") PositionRequest pr,
        Model model
    ) {
        ptm.delete(ptm.getById(pr.getId()));

        return "redirect:/positions";
    }

    @GetMapping("/positions/filter")
    public String positionsFilter(
        @ModelAttribute("positionRequest") PositionRequest pr,
        Model model
    ) {
        List<Position> positionList = ptm.listLike(pr.getGetName(), pr.getGetResponsibilities(), pr.getGetDivisionId(), pr.getGetDivisionName());
        model.addAttribute("positionList", positionList);

        return "positions.jsp";
    }

    @PostMapping("/positions")
    public String addPosition(
            @ModelAttribute("positionRequest") PositionRequest pr,
            Model model
    ) {
        Position pos = new Position();
        pos.setName(pr.getPostName());
        pos.setResponsibilities(pr.getPostResponsibilities());
        pos.setDivision(dtm.getById(pr.getPostDivisionId()));
        ptm.save(pos);

        return "redirect:/positions";
    }

    @GetMapping("/positions/{id}")
    public String positionInfo(Model model, @PathVariable String id) {
        model.addAttribute("position", ptm.getById(Integer.parseInt(id)));
        model.addAttribute("positionInfoRequest", new PositionInfoRequest());

        return "positionInfo.jsp";
    }

    @PostMapping("/positions/{id}/update")
    public String positionInfo(
        @ModelAttribute("positionInfoRequest") PositionInfoRequest posir,
        @PathVariable String id,
        Model model
    ) {
        Position pos = ptm.getById(Integer.parseInt(id));
        if (posir.getNewEmployeeId() != 0) {
            Employee emp = etm.getById(posir.getNewEmployeeId());
            EmpPos ep = new EmpPos(emp, pos, posir.getNewEmployeeSalary());
            eptm.save(ep);
        } else if (posir.getDeleteEmployeeId() != 0) {
            for (EmpPos ep: eptm.getByIdPair(posir.getDeleteEmployeeId(), Integer.parseInt(id))) {
                eptm.delete(ep);
            }
        } else {
            if (posir.getNewName() != null) { pos.setName(posir.getNewName()); }
            if (posir.getNewResponsibilities() != null) { pos.setResponsibilities(posir.getNewResponsibilities()); }
            if (posir.getNewDivisionId() != 0) { pos.setDivision(dtm.getById(posir.getNewDivisionId())); }

            ptm.update(pos);
        }


        return "redirect:/positions/" + id;
    }

    // /employees

    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employee> employeeList = etm.listAllEmployees();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeRequest", new EmployeeRequest());

        return "employees.jsp";
    }

    @GetMapping("/employees/filter")
    public String employeesFilter(
        @ModelAttribute("employeeRequest") EmployeeRequest er,
        Model model
    ) {
        List<Employee> employeeList = etm.listLike(er.getGetName(), er.getGetSurname(), er.getGetPatronymic(), er.getGetEducation());
        model.addAttribute("employeeList", employeeList);

        return "employees.jsp";
    }

    @GetMapping("/employees/delete")
    public String employeesDelete(
        @ModelAttribute("employeeRequest") EmployeeRequest er,
        Model model
    ) {
        etm.delete(etm.getById(er.getId()));

        return "redirect:/employees";
    }

    @PostMapping("/employees")
    public String addEmployee(
        @ModelAttribute("employeeRequest") EmployeeRequest er,
        Model model
    ) {
        Employee emp = new Employee();
        emp.setName(er.getPostName());
        emp.setSurname(er.getPostSurname());
        emp.setPatronymic(er.getPostPatronymic());
        emp.setEducation(er.getPostEducation());
        etm.save(emp);

        return "redirect:/employees";
    }

    // /employeeInfo

    @GetMapping("/employees/{id}")
    public String employeeInfo(Model model, @PathVariable String id) {
        model.addAttribute("employee", etm.getById(Integer.parseInt(id)));
        model.addAttribute("employeeInfoRequest", new EmployeeInfoRequest());

        return "employeeInfo.jsp";
    }

    @PostMapping("/employees/{id}/update")
    public String employeeInfoUpdate(
        @ModelAttribute("employeeInfoRequest") EmployeeInfoRequest empir,
        @PathVariable String id,
        Model model
    ) {
        if (empir.getNewPositionId() != 0) {
            EmpPos ep = new EmpPos(etm.getById(Integer.parseInt(id)), ptm.getById(empir.getNewPositionId()), empir.getNewPositionSalary());
            eptm.save(ep);
        } else if(empir.getDeletePositionId() != 0) {
            for (EmpPos ep: eptm.getByIdPair(Integer.parseInt(id), empir.getDeletePositionId())) {
                eptm.delete(ep);
            }
        } else {
            Employee emp = etm.getById(Integer.parseInt(id));
            if (empir.getNewEducation() != null) { emp.setEducation(empir.getNewEducation()); }
            if (empir.getNewName() != null) { emp.setName(empir.getNewName()); }
            if (empir.getNewSurname() != null) { emp.setSurname(empir.getNewSurname()); }
            if (empir.getNewPatronymic() != null) { emp.setPatronymic(empir.getNewPatronymic()); }

            etm.update(emp);
        }

        return "redirect:/employees/" + id;
    }



    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("dtm", dtm);
        model.addAttribute("etm", etm);
        model.addAttribute("ptm", ptm);
        model.addAttribute("eptm", ptm);
    }
}
