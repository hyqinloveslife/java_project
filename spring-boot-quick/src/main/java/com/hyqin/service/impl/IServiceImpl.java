/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IServiceImpl
 * Author:   hyqin
 * Date:     2019-09-15 12:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.service.impl;

import com.hyqin.service.IService;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-15
 * @since 1.0.0
 */

public class IServiceImpl implements IService {
    @Override
    public String getStr() {
        return "IServiceImpl";
    }
}
