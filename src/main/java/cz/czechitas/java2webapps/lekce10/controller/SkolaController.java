package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.service.RodicService;
import cz.czechitas.java2webapps.lekce10.service.StudentService;
import cz.czechitas.java2webapps.lekce10.service.TridaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SkolaController {

    private final TridaService tridaService;
    private final StudentService studentService;
    private final RodicService rodicService;

    @Autowired
    public SkolaController(TridaService tridaService, StudentService studentService, RodicService rodicService) {
        this.tridaService = tridaService;
        this.studentService = studentService;
        this.rodicService = rodicService;
    }

    @GetMapping("/")
    public Object seznamTrid(@PageableDefault(sort = {"nazev"}) Pageable pageable) {
        return new ModelAndView("seznam")
                .addObject("tridy", tridaService.seznamTrid(pageable));
    }

    @GetMapping(path = "/trida", params = "id")
    public Object detailTridy(short id, Pageable pageable) {
        Optional<Trida> vybranaTrida = tridaService.tridaById(id);

        return new ModelAndView("trida")
                .addObject("trida", vybranaTrida.get())
                .addObject("studenti", studentService.seznamStudentuByTridaId(id, pageable));
    }

    @GetMapping(path = "/student", params = "id")
    public Object detailStudenta(short id, Pageable pageable) {
        Optional<Student> vybranyStudent = studentService.studentById(id);

        return new ModelAndView("student")
                .addObject("student", vybranyStudent.get())
                .addObject("rodice", rodicService.seznamRodicuByStudentId(id, pageable));
    }



}
