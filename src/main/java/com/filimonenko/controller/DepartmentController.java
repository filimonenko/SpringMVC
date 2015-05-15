package com.filimonenko.controller;

import com.filimonenko.entity.Department;
import com.filimonenko.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "showDepartments")
    public String viewDepartments(ModelMap model) {

        List<Department> listOfDepartments = departmentService.getDepartmentslist();

        model.addAttribute("listDepartments", listOfDepartments);

        return "showDepartments";
    }

    @RequestMapping(value = "renderDepartment")
    public String renderDepartment(ModelMap model, @RequestParam Long id) {

        if (id == 0) {

            model.addAttribute("department", new Department());

        } else {

            Department department = (Department) departmentService.getDepartmentById(id);
            model.addAttribute("department", department);
        }

        return "addOrEditDepartment";

    }

    @RequestMapping(value = "deleteDepartment")
    public String deleteDepartment(@RequestParam Long id) {

        departmentService.deleteDepartment(id);

        return "redirect:showDepartments";
    }

    @RequestMapping(value = "saveDepartment", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute Department department) {

        if (department.getDepartmentId() == null) {

            departmentService.createDepartment(department);

        } else {

            departmentService.updateDepartment(department);
        }

        return "redirect:showDepartments";
    }
}

