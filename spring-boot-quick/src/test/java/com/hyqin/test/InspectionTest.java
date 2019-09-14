/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: InspectionTest
 * Author:   hyqin
 * Date:     2019-09-12 17:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.test;

import com.SpringBootQuickApplication;
import com.hyqin.test1.InspectionConstant;
import com.hyqin.test1.InspectionSolver;
import com.hyqin.test1.InspectionSolverChooser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-12
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootQuickApplication.class)
public class InspectionTest {

    @Autowired
    private InspectionSolverChooser chooser;

    @Test
    public void test(){
        //数据测试
        String taskType = InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_WAREHOUSE;

        Long orderId = 123456L;

        Long userId = 11L;

        InspectionSolver solver = chooser.choose(taskType);
        if(solver==null){
            System.out.println("抛出异常");
        }
        solver.solver(orderId,userId);

        taskType = InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_SHIPPING;
        solver = chooser.choose(taskType);

        Map<String,Object> param = new HashMap();
        param.put("orderId",orderId);
        param.put("userId",userId);
        solver.handle(param);

    }

}
