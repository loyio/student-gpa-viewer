package me.loyio.studentgpaviewer.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: student-gpa-viewer
 * Package: me.loyio.studentgpaviewer.utils
 * User: loyio
 * Date: 5/30/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUtils<T> {
    private Integer pageIndex;//当前页码
    private Integer pageSize; //页码大小
    private Integer totalCount; //总条数
    private Integer pageCount; //总页数(计算出来)
    private List<T> records; //每页数据

    private List<Integer> numbers=new ArrayList<Integer>();

    private Integer numberStart=1;
    private Integer numberEnd;

    public PageUtils(Integer pageIndex, Integer pageSize, Integer totalCount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.records = records;
        this.pageCount=(this.totalCount%this.pageSize==0)?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1);


        this.numberStart=1;
        this.numberEnd=this.pageCount;

        if(this.pageCount<=10){
            this.numberStart=1;
            this.numberEnd=this.pageCount;
        }else{
            this.numberStart=this.pageIndex-4;
            this.numberEnd=this.pageIndex+5;
            if(this.numberStart<1){
                this.numberStart=1;
                this.numberEnd=10;
            }else if(this.numberEnd>this.pageCount){
                this.numberEnd=this.getPageCount();
                this.numberStart=this.pageCount-9;
            }
        }

        for(int i=this.numberStart;i<=this.numberEnd;i++){
            numbers.add(i);
        }

    }
}
