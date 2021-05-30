package me.loyio.studentgpaviewer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.loyio.studentgpaviewer.model.Grades;
import me.loyio.studentgpaviewer.service.GradesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: student-gpa-viewer
 * Package: me.loyio.studentgpaviewer.controller
 * User: loyio
 * Date: 5/30/21
 */
@Controller
public class GradesViewerController {
    @Resource
    private GradesService gradesService;

    @RequestMapping("/showGrade")
    @ResponseBody
    public String showGrade(@RequestParam(value = "pageNum") Integer pageIndex,
                            @RequestParam(value = "pageSize") Integer pageSize) {
        pageIndex = pageIndex == 0 ? 1 : pageIndex;
        pageSize = pageSize == 0 ? 5 : pageSize;
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        Integer totalCount = gradesService.getTotalCount();
        List<Grades> gradeList = gradesService.getGradePage(map);
        Map<String,Object> data = new HashMap<>();
        data.put("total",totalCount);
        data.put("rows",gradeList);

        ObjectMapper mapper = new ObjectMapper();
        String pageJson = null;
        try {
            pageJson = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pageJson;
    }
}
