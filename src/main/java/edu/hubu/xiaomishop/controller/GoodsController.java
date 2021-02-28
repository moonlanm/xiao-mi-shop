package edu.hubu.xiaomishop.controller;

import edu.hubu.xiaomishop.model.Goods;
import edu.hubu.xiaomishop.model.Type;
import edu.hubu.xiaomishop.service.impl.GoodsServiceImpl;
import edu.hubu.xiaomishop.service.impl.TypeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * @author moonlan
 * date 2021/1/13 上午10:19
 */
@SuppressWarnings(value = "unused")
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsServiceImpl service;
    private final TypeServiceImpl typeService;

    public GoodsController(GoodsServiceImpl service, TypeServiceImpl typeService) {
        this.service = service;
        this.typeService = typeService;
    }

    @GetMapping("/api/select-list")
    public String selectList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize, Model model, @RequestParam(defaultValue = "0") String typeId) {
        String param = "?currentPage=" + currentPage + "&pageSize=" + pageSize + "&typeId=" + typeId;
        return "redirect:/goods/select-list" + param;
    }

    @PostMapping("/api/edit")
    public String edit(String id, int num, String typeId, double price, String desc, String detail, String name, MultipartFile img) {
        if (Integer.parseInt(typeId) < 0) {
            throw new RuntimeException(typeId + "< 0");
        }
        Goods goods = new Goods();
        goods.setGoodsName(name);
        goods.setGoodsNum(num);
        goods.setGoodsTypeId(typeId);
        goods.setGoodsPrice(price);
        goods.setGoodsDesc(desc);
        goods.setGoodsDetail(detail);
        goods.setGoodsId(id);
        if (img != null && !img.getOriginalFilename().isEmpty()) {
            try {
                // 文件存放服务端的位置
                String property = System.getProperty("user.dir");
                // 文件存放服务端的位置
                File dir = new File(property + "/images/");
                if (!dir.exists()) {
                    boolean mkdirs = dir.mkdirs();
                }
                // 写文件到服务器
                File serverFile = new File(dir.getAbsolutePath() + File.separator + img.getOriginalFilename());
                img.transferTo(serverFile);
                goods.setGoodsImg("/img/" + img.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.updateById(goods);
        return "redirect:/goods/select-list";
    }

    @PostMapping("/api/add")
    public String add(String id, int num, String typeId, double price, String desc, String detail, String name, MultipartFile img) {
        if (Integer.parseInt(typeId) < 0) {
            throw new RuntimeException(typeId + "< 0");
        }
        Goods goods = new Goods();
        goods.setGoodsName(name);
        goods.setGoodsNum(num);
        goods.setGoodsTypeId(typeId);
        goods.setGoodsPrice(price);
        goods.setGoodsDesc(desc);
        goods.setGoodsDetail(detail);
        goods.setGoodsId(id);
        if (img != null && !img.getOriginalFilename().isEmpty()) {
            try {
                // 文件存放服务端的位置
                String property = System.getProperty("user.dir");
                // 文件存放服务端的位置
                File dir = new File(property + "/images/");
                if (!dir.exists()) {
                    boolean mkdirs = dir.mkdirs();
                }
                // 写文件到服务器
                File serverFile = new File(dir.getAbsolutePath() + File.separator + img.getOriginalFilename());
                img.transferTo(serverFile);
                goods.setGoodsImg("/img/" + img.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.save(goods);
        return "redirect:/goods/select-list";
    }

    @PostMapping("/api/del")
    public String del(String id) {
        service.deleteById(id);
        return "redirect:/goods/select-list";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/select-list")
    public String selectList(HttpServletRequest request, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize, Model model, @RequestParam(defaultValue = "0") String typeId) {
        List<Type> types = typeService.selectAll();
        model.addAttribute("types", types);
        model.addAttribute("selectedType", typeId);
        if (Integer.parseInt(typeId) != 0) {
            List<Goods> goods = service.selectListByType(currentPage, pageSize, typeId);
            int pages = (service.selectAllByType(typeId).size() % pageSize) == 0 ? (service.selectAllByType(typeId).size() / pageSize) : (service.selectAllByType(typeId).size() / pageSize) + 1;
            if (currentPage < 1)
                currentPage = 1;
            if (currentPage > pages)
                currentPage = pages;
            model.addAttribute("current", currentPage);
            model.addAttribute("total", pages);
            goods.forEach(System.out::println);
            model.addAttribute("list", goods);
        } else {
            List<Goods> goods = service.selectList(currentPage, pageSize);
            int pages = (service.selectAll().size() / pageSize) + 1;
            if (currentPage < 1)
                currentPage = 1;
            if (currentPage > pages)
                currentPage = pages;
            model.addAttribute("current", currentPage);
            model.addAttribute("total", pages);
            goods.forEach(System.out::println);
            model.addAttribute("list", goods);
            goods.forEach(System.out::println);
            model.addAttribute("list", goods);
        }
        return "goods/index";
    }

    @GetMapping("/edit")
    public String edit(Model model, String id) {
        Goods goods = service.selectById(id);
        model.addAttribute("goods", goods);
        List<Type> types = typeService.selectAll();
        model.addAttribute("types", types);
        return "goods/edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<Type> types = typeService.selectAll();
        model.addAttribute("types", types);
        return "goods/add";
    }

    @GetMapping("/detail")
    public String detail(Model model, String id) {
        Goods byId = service.selectById(id);
        model.addAttribute("goods", byId);
        return "goods/detail";
    }

}
