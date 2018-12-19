package com.knowledge.accumulation.utils;

/**
 * Created by wangyafei on 17-8-6.
 */
public class PageUtil {

    /**
     * 更加总条数和每页显示条数计算总页数
     * @param totalCount
     * @param pageSize
     * @return
     */
    public static int calTotalPage(long totalCount, int pageSize){
        if (pageSize <= 0 || totalCount==0){
            return 1;
        }
        int totalPage  = (int) ((totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1));
        if(0 == totalPage){
            return 1;
        }
        return totalPage;
    }

}
