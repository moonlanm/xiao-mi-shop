package edu.hubu.xiaomishop.controller;

import edu.hubu.xiaomishop.model.Goods;
import edu.hubu.xiaomishop.model.Manager;
import edu.hubu.xiaomishop.model.Type;
import edu.hubu.xiaomishop.service.impl.GoodsServiceImpl;
import edu.hubu.xiaomishop.service.impl.TypeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author moonlan
 * date 2021/1/13 上午10:51
 */
@SuppressWarnings(value = "unused")
@Controller
@RequestMapping("/type")
public class TypeController {
    private final TypeServiceImpl service;

    public TypeController(TypeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/api/select-list")
    public String selectList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        List<Type> types = service.selectList(currentPage, pageSize);
        types.forEach(System.out::println);
        model.addAttribute("list", types);
        String param = "?currentPage=" + currentPage + "&pageSize=" + pageSize;
        return "redirect:/type/select-list" + param;
    }

    @PostMapping("/api/edit")
    public String edit(String id, String desc, String name) {
        Type type = new Type();
        type.setTypeId(id);
        type.setTypeName(name);
        type.setTypeDesc(desc);
        service.updateById(type);
        return "redirect:/type/select-list";
    }

    @PostMapping("/api/add")
    public String add(String id, String desc, String name) {
        Type type = new Type();
        type.setTypeId(id);
        type.setTypeName(name);
        type.setTypeDesc(desc);
        service.save(type);
        return "redirect:/type/select-list";
    }

    @PostMapping("/api/del")
    public String del(String id) {
        service.deleteById(id);
        return "redirect:/type/select-list";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/select-list")
    public String selectList(HttpServletRequest request, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        int pages = (service.selectAll().size() % pageSize) == 0 ? (service.selectAll().size() / pageSize) : (service.selectAll().size() / pageSize) + 1;
        if (currentPage < 1)
            currentPage = 1;
        if (currentPage > pages)
            currentPage = pages;
        model.addAttribute("current", currentPage);
        model.addAttribute("total", pages);
        List<Type> types = service.selectList(currentPage, pageSize);
        model.addAttribute("list", types);
        return "type/index";
    }

    @GetMapping("/edit")
    public String edit(Model model, String id) {
        Type type = service.selectById(id);
        model.addAttribute("type", type);
        return "type/edit";
    }

    @GetMapping("/add")
    public String add() {
        return "type/add";
    }

    @GetMapping("/detail")
    public String detail(Model model, String id) {
        Type byId = service.selectById(id);
        model.addAttribute("type", byId);
        return "type/detail";
    }
}
