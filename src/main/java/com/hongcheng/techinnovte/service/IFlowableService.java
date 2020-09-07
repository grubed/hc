package com.hongcheng.techinnovte.service;

import com.hongcheng.techinnovte.common.exception.ProcessNotFoundException;
import org.flowable.task.api.Task;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IFlowableService {
    String startFlow(String processsKey, HashMap<String, Object> date);
    List<Task> getTasks(String userId);
    void completeTask(String taskId, HashMap<String, Object> date)  throws ProcessNotFoundException;
    List<Task> getTaskByParam(String var1, Object var2);
    List<Task> getTaskByMap(Map<String, Object> map);
}
