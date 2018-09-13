import com.zl.Application;
import com.zl.base.Page;
import com.zl.bean.User;
import com.zl.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insert() {
        User roncooUser = new User();
        roncooUser.setName("测试");
        roncooUser.setCreateTime(new Date());
        int result = userDao.insert(roncooUser);
        System.out.println(result);
    }

    @Test
    public void delete() {
        int result = userDao.deleteById(1L);
        System.out.println(result);
    }

    @Test
    public void update() {
        User roncooUser = new User();
        roncooUser.setId(2L);
        roncooUser.setName("测试2");
        roncooUser.setCreateTime(new Date());
        int result = userDao.updateById(roncooUser);
        System.out.println(result);
    }

    @Test
    public void select() {
        User result = userDao.selectById(2L);
        System.out.println(result);
    }

    // 分页测试
    @Test
    public void queryForPage() {
        Page<User> result = userDao.queryForPage(1, 20);
        System.out.println(result.getList());
    }

}
