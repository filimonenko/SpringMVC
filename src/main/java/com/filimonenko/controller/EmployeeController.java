package com.filimonenko.controller;

import com.filimonenko.entity.Employee;
import com.filimonenko.service.EmployerService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployerService employerService;

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    private List<Employee> listOfEmployee = null;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Это чтобы пустые строки превращались в null
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

        // Это чтобы строки, содержащие дату, превращались в java.util.Date
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        // Это чтобы MultipartFileEditor, содержащие данные, превращались в byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }


    @RequestMapping(value = "showEmployee")
    public String viewEmployee(@RequestParam Long departmentId, ModelMap model) {

        listOfEmployee = employerService.getEmployersList(departmentId);

        model.addAttribute("listOfEmployee", listOfEmployee);
        model.addAttribute("departmentId", departmentId);
        return "showStaff";
    }

    @RequestMapping(value = "renderEmployee")
    public String renderEmployee(@RequestParam Long departmentId, @RequestParam Long employeeId, ModelMap model) {


        if (employeeId == 0) {

            model.addAttribute("employee", new Employee(departmentId, null, null, false, null, null));

        } else {

            Employee employee = (Employee) employerService.getEmployeeById(employeeId);
            model.addAttribute("employee", employee);
        }
        return "addOrEditEmployee";
    }

    @RequestMapping(value = "saveEmployee", method = RequestMethod.POST, headers = {"content-type=multipart/form-data"})
    public String saveEmployee(@ModelAttribute Employee employee, @RequestParam(value = "file", required = false) byte[] file) {

        if (employee.getId() == (null)) {

            if (employee.getImage().length == 0) {
                employee.setImage(null);
                employerService.createEmployee(employee);
            }

            if (!(file.length == 0)){
                try {
                    File fileSave = new File("D:/Java/Project/SpringMVC/src/main/resources/" + employee.getId() + ".doc");
                    FileUtils.writeByteArrayToFile(fileSave, file);
                } catch (IOException e) {e.printStackTrace();}

                employee.setResume(true);
            }

            employerService.createEmployee(employee);

        } else {
            if (employee.getImage().length == 0 && !(getPhoto(employee.getId()) == null)) {
                employee.setImage(getPhoto(employee.getId()));
            }

            if (!(file.length == 0)){
                try {
                    File fileSave = new File("D:/Java/Project/SpringMVC/src/main/resources/" + employee.getId() + ".doc");
                    FileUtils.writeByteArrayToFile(fileSave, file);
                } catch (IOException e) {e.printStackTrace();}

            }

                employee.setResume(true);

                employerService.updateEmployee(employee);



            employerService.updateEmployee(employee);
        }

        return "redirect:showEmployee?departmentId=" + employee.getDepartmentId();
    }

    @RequestMapping(value = "deleteEmployee")
    public String deleteEmployee(@RequestParam Long departmentId, @RequestParam Long employeeId) {

        employerService.deleteEmployee(employeeId);

        return "redirect:showEmployee?departmentId=" + departmentId;
    }


    @RequestMapping("/getPhoto/{id}")
    public @ResponseBody  byte[] getPhoto(@PathVariable("id") final Long id) {

        if (employerService.getImage(id).length == 0) {
            return null;
        }else return employerService.getImage(id);


    }

    @RequestMapping(value = "/getResume/{id}")
    public @ResponseBody void getResume(@PathVariable("id") final Long id, HttpServletRequest request, HttpServletResponse response) {


        ServletContext context = request.getServletContext();

        FileInputStream inputStream = null;
        OutputStream outStream = null;

        try {
            inputStream = new FileInputStream("D:/Java/Project/SpringMVC/src/main/resources/" + id + ".doc");

            response.setContentType(context.getMimeType("D:/Java/Project/SpringMVC/src/main/resources/" + id + ".doc"));

            outStream = response.getOutputStream();
            IOUtils.copy(inputStream, outStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
