package com.hongcheng.techinnovte.service.impl;

import com.hongcheng.techinnovte.common.exception.ProcessNotFoundException;
import com.hongcheng.techinnovte.service.IFlowableService;
import org.flowable.engine.*;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FlowableServiceImpl implements IFlowableService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    @Autowired
    private ProcessEngine processEngine;

    @Override
    public String startFlow(String processsKey, HashMap<String, Object> date) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processsKey, date);
        String processId = processInstance.getId();
        String name = processInstance.getName();
        System.out.println(processId + ":" + name);
        return processId;
    }

    @Override
    public List<Task> getTasks(String userId) {
        return taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
    }

    public List<Task> getTaskByParam(String var1, Object var2) {
        return taskService.createTaskQuery().processVariableValueEquals(var1, var2).orderByTaskCreateTime().desc().list();
    }
    public List<Task> getTaskByMap(Map<String, Object> map) {
        TaskQuery taskQuery = taskService.createTaskQuery();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            taskQuery.processVariableValueEquals(entry.getKey(), entry.getValue());
        }
        return taskQuery.orderByTaskCreateTime().desc().list();
    }
    @Override
    public void completeTask(String taskId, HashMap<String, Object> date) throws ProcessNotFoundException {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new ProcessNotFoundException();
        }
        taskService.complete(taskId, date);
    }
}
