package me.loyio.studentgpaviewer.mapper;

import me.loyio.studentgpaviewer.model.Grades;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Project: student-gpa-viewer
 * Package: me.loyio.studentgpaviewer.mapper
 * User: loyio
 * Date: 5/30/21
 */

@Mapper
public interface GradesMapper {

    @Select("SELECT * FROM s_c")
    List<Grades> findAll();

    @Select("SELECT * FROM s_c LIMIT #{params.pageStart},#{params.pageSize}")
    List<Grades> getGradePage(@Param("params") Map<String, Object> map);

    @Select("SELECT COUNT(1) FROM s_c")
    Integer getTotalCount();
}
