package com.hongcheng.techinnovte.service;

import com.hongcheng.techinnovte.pojo.dto.InputConditionDTO;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DrlTestService {
    @Resource
    private KieContainer kieContainer;

    @Resource
    DrlUseService drlUseService;


    public void fireRules() {
        KieSession kieSession = kieContainer.newKieSession();

        //uleNameEndsWithAgendaFilter 执行名称以xxx结尾的规则
        //RuleNameEqualsAgendaFilter 执行名称全匹配的规则
        //RuleNameMatchesAgendaFilter 可以写自己的正则
        //RuleNameStartsWithAgendaFilter 执行名称以xxx开头的规则
        //RuleNameSerializationAgendaFilter 规则名称序列化代理筛选器（其实好像就是可以执行以上4种中的一种）

        RuleNameStartsWithAgendaFilter rg = new RuleNameStartsWithAgendaFilter("test_");

        InputConditionDTO a = new InputConditionDTO();
        a.setKind("1");
        a.setRule("1");
        a.setTable("1");
        kieSession.insert(a);
        kieSession.insert(drlUseService);
        int ruleFiredCount = kieSession.fireAllRules(rg);
        log.info("a--" + a.getKind());
        kieSession.destroy();
    }


}
