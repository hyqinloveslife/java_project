/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ChangeWarehouseSolver
 * Author:   hyqin
 * Date:     2019-09-12 17:32
 * Description: 定义不同的处理器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.designpattern;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈定义不同的处理器〉
 *
 * @author hyqin
 * @create 2019-09-12
 * @since 1.0.0
 */
@Component
public class ChangeShippingSolver extends InspectionSolver {

    @Override
    public void solver(Long orderId, Long userId) {
        System.out.println("处理====ChangeShippingSolver");
    }

    @Override
    public String handle(Map<String, Object> param) {
        return "处理成功   订单号： " + param.get("orderId")+"    用户id : "+param.get("userId");
    }

    @Override
    public String[] supports() {
        return new String[]{InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_SHIPPING};
    }
}
