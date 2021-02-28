package edu.hubu.xiaomishop.controller;

import edu.hubu.xiaomishop.model.Goods;
import edu.hubu.xiaomishop.model.Manager;
import edu.hubu.xiaomishop.model.Type;
import edu.hubu.xiaomishop.service.impl.ManagerServiceImpl;
import edu.hubu.xiaomishop.service.impl.TypeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * @author moonlan
 * date 2021/1/12 上午11:38
 */
@SuppressWarnings(value = "unused")
@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerServiceImpl service;


    public ManagerController(ManagerServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/api/login")
    public String login(HttpServletRequest request, HttpServletResponse response, String account, String pwd, boolean isRememberMe, Model model) {
        Manager manager = service.login(account, pwd, isRememberMe, request, response);
        return "redirect:/manager/select-list";
    }

    @GetMapping("/api/select-list")
    public String selectList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        List<Manager> managers = service.selectList(currentPage, pageSize);
        managers.forEach(System.out::println);
        model.addAttribute("list", managers);
        String param = "?currentPage=" + currentPage + "&pageSize=" + pageSize;
        return "redirect:/manager/select-list" + param;
    }

    @PostMapping("/api/logout")
    public String logout(HttpServletRequest request, String account) {
        service.logout(account, request);
        return "redirect:/manager/login";
    }

    @PostMapping("/api/edit")
    public String edit(String id, String account, String password, String tel, String name, MultipartFile img) {
        Manager manager = new Manager();
        manager.setMgrName(name);
        manager.setMgrPwd(password);
        manager.setMgrTel(tel);
        manager.setMgrAccount(account);
        manager.setMgrId(id);
        if (img != null && !img.getOriginalFilename().isEmpty()) {
            try {
                String property = System.getProperty("user.dir");
                // 文件存放服务端的位置
                File dir = new File( property + "/images/");
                if (!dir.exists()) {
                    boolean mkdirs = dir.mkdirs();
                }
                // 写文件到服务器
                File serverFile = new File(dir.getAbsolutePath() + File.separator + img.getOriginalFilename());
                img.transferTo(serverFile);
                manager.setMgrImg("/img/" + img.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.updateById(manager);
        return "redirect:/manager/select-list";
    }

    @PostMapping("/api/add")
    public String add(String id, String account, String password, String tel, String name, MultipartFile img) {
        Manager manager = new Manager();
        manager.setMgrName(name);
        manager.setMgrPwd(password);
        manager.setMgrTel(tel);
        manager.setMgrAccount(account);
        manager.setMgrId(id);
        if (img != null && !img.getOriginalFilename().isEmpty()) {
            try {
                // 文件存放服务端的位置
                String property = System.getProperty("user.dir");
                // 文件存放服务端的位置
                File dir = new File( property + "/images/");
                if (!dir.exists()) {
                    boolean mkdirs = dir.mkdirs();
                }
                // 写文件到服务器
                File serverFile = new File(dir.getAbsolutePath() + File.separator + img.getOriginalFilename());
                img.transferTo(serverFile);
                manager.setMgrImg("/img/" + img.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.save(manager);
        return "redirect:/manager/select-list";
    }

    @PostMapping("/api/del")
    public String del(String id) {
        service.deleteById(id);
        return "redirect:/manager/select-list";
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
        List<Manager> managers = service.selectList(currentPage, pageSize);
        model.addAttribute("list", managers);
        return "manager/index";
    }

    @GetMapping("/edit")
    public String edit(Model model, String id) {
        Manager manager = service.selectById(id);
        model.addAttribute("user", manager);
        return "manager/edit";
    }

    @GetMapping("/add")
    public String add() {
        return "manager/add";
    }

    @GetMapping("/detail")
    public String detail(Model model, String id) {
        Manager byId = service.selectById(id);
        model.addAttribute("manager", byId);
        return "manager/detail";
    }
}