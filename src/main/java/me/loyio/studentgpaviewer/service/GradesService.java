package me.loyio.studentgpaviewer.service;

import me.loyio.studentgpaviewer.mapper.GradesMapper;
import me.loyio.studentgpaviewer.model.Grades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Project: student-gpa-viewer
 * Package: me.loyio.studentgpaviewer.service
 * User: loyio
 * Date: 5/30/21
 */
@Service
public class GradesService {
    @Autowired
    private GradesMapper gradesMapper;

    public List<Grades> findAll(){
        return gradesMapper.findAll();
    }

    public List<Grades> getGradePage(Map<String, Object> map){
        return gradesMapper.getGradePage(map);
    }

    public Integer getTotalCount(){
        return gradesMapper.getTotalCount();
    }
}
