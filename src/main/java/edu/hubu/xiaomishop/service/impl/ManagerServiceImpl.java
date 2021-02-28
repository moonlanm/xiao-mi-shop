package edu.hubu.xiaomishop.service.impl;

import edu.hubu.xiaomishop.exception.LoginException;
import edu.hubu.xiaomishop.mapper.ManagerMapper;
import edu.hubu.xiaomishop.model.Manager;
import edu.hubu.xiaomishop.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author moonlan
 * date 2021/1/12 上午11:22
 */
@SuppressWarnings(value = "unused")
@Service
public class ManagerServiceImpl implements IService<Manager> {

    private final ManagerMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    public ManagerServiceImpl(ManagerMapper mapper) {
        this.mapper = mapper;
    }

    public Manager login(String account, String pwd, boolean isRememberMe, HttpServletRequest request, HttpServletResponse response) {
        try {
            Manager login = mapper.login(account, pwd);
            if (login != null) {
                request.getSession().setAttribute("user", login);
                if (isRememberMe) {
                    response.addCookie(new Cookie("account", login.getMgrAccount()));
                }
                return login;
            }
            throw new LoginException("用户名或密码不正确!");
        } catch (Exception e) {
            logger.error("用户名或密码不正确!");
            throw new LoginException(e);
        }
    }

    public void logout(String account, HttpServletRequest request) {
        try {
            request.getSession().removeAttribute("user");
        } catch (Exception e) {
            logger.error("无法登出!");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(String id) {
        try {
            int delete = mapper.deleteByPrimaryKey(id);
            return delete > 0;
        } catch (Exception e) {
            logger.error("删除id = {}的管理员失败，原因为{}", id, e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Manager manager) {
        try {
            int insertSelective = mapper.insertSelective(manager);
            return insertSelective > 0;
        } catch (Exception e) {
            logger.error("保存管理员失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Manager selectById(String id) {
        Manager manager;
        try {
            manager = mapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("查询id = {}的管理员失败，原因为{}", id, e.toString());
            throw new RuntimeException(e);
        }
        if (manager == null) {
            logger.error("id = " + id + "未找到");
            throw new RuntimeException("id = " + id + "未找到");
        }
        return manager;
    }

    @Override
    public Manager updateById(Manager manager) {
        try {
            mapper.updateByPrimaryKeySelective(manager);
            return selectById(manager.getMgrId());
        } catch (Exception e) {
            logger.error("更新id = {}的管理员失败，原因为{}", manager.getMgrId(), e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Manager> selectList(int currentPage, int pageSize) {
        try {
            return mapper.selectList((currentPage - 1) * pageSize, pageSize);
        } catch (Exception e) {
            logger.error("查询管理员失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Manager> selectListLike(int currentPage, int pageSize, Manager manager) {
        try {
            return mapper.selectList((currentPage - 1) * pageSize, pageSize);
        } catch (Exception e) {
            logger.error("查询管理员失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Manager> selectAll() {
        try {
            return mapper.selectAll();
        } catch (Exception e) {
            logger.error("查询管理员失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }
}
