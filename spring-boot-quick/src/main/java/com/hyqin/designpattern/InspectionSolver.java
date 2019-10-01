/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: InspectionSolver
 * Author:   hyqin
 * Date:     2019-09-12 17:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.designpattern;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-12
 * @since 1.0.0
 */
public abstract class InspectionSolver {
    public abstract void solver(Long orderId,Long userId);

    public abstract String handle(Map<String,Object> param);

    public abstract String[] supports();
}
