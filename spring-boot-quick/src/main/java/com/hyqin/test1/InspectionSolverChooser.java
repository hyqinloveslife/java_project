/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: InspectionSolverChooser
 * Author:   hyqin
 * Date:     2019-09-12 17:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.test1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
@Component
public class InspectionSolverChooser implements ApplicationContextAware {
    private ApplicationContext context;

    private Map<String,InspectionSolver> chooseMap = new HashMap<>();

    public InspectionSolver choose(String type){
        return chooseMap.get(type);
    }

    @PostConstruct
    public void register(){
        Map<String,InspectionSolver> solverMap = context.getBeansOfType(InspectionSolver.class);
        for (InspectionSolver solver:solverMap.values()) {
            for (String support : solver.supports()){
                chooseMap.put(support,solver);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
