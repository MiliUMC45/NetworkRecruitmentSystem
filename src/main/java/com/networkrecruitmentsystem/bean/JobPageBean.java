package com.networkrecruitmentsystem.bean;

import java.util.ArrayList;

public class JobPageBean {
    private String keyword;
    private int curPage;
    private int jobsAPage = 10;
    private int totalJobs;
    private int totalPages;
    private int pagesForNavigation = 5; //导航栏上最多显示页数
    private int cycleForNavigation; //导航栏切换周期
    private int firstPageForNavigation; //记录导航栏的第一个页码 cycleForNavigation * pagesForNavigation + 1
    private int lastPageForNavigation;  //记录导航栏的最后一个页码totalPages和cycleForNavigation * pagesForNavigation + 5的最小值

    private ArrayList<JobPageItemBean> jobList;

    public JobPageBean() {
    }

    public JobPageBean(String keyword, int curPage) {
        this.keyword = keyword;
        this.curPage = curPage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getJobsAPage() {
        return jobsAPage;
    }

    public void setJobsAPage(int jobsAPage) {
        this.jobsAPage = jobsAPage;
    }

    public int getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(int totalJobs) {
        this.totalJobs = totalJobs;
        setTotalPages((totalJobs - 1) / jobsAPage + 1);  //
        setFirstPageForNavigation(cycleForNavigation * pagesForNavigation + 1);
        setLastPageForNavigation(Math.min(totalPages, cycleForNavigation * pagesForNavigation + 5));
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPagesForNavigation() {
        return pagesForNavigation;
    }

    public void setPagesForNavigation(int pagesForNavigation) {
        this.pagesForNavigation = pagesForNavigation;
    }

    public int getCycleForNavigation() {
        return cycleForNavigation;
    }

    public void setCycleForNavigation(int cycleForNavigation) {
        this.cycleForNavigation = cycleForNavigation;
    }

    public int getFirstPageForNavigation() {
        return firstPageForNavigation;
    }

    public void setFirstPageForNavigation(int firstPageForNavigation) {
        this.firstPageForNavigation = firstPageForNavigation;
    }

    public int getLastPageForNavigation() {
        return lastPageForNavigation;
    }

    public void setLastPageForNavigation(int lastPageForNavigation) {
        this.lastPageForNavigation = lastPageForNavigation;
    }

    public ArrayList<JobPageItemBean> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<JobPageItemBean> jobList) {
        this.jobList = jobList;
    }
}
