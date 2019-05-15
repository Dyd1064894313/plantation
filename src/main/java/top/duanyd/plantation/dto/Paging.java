package top.duanyd.plantation.dto;

public class Paging {
    //当前页码
    private int currentPage;
    //每页条数
    private int pageSize;
    //总条数
    private int totle;
    //页数
    private int pages;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotle() {
        return totle;
    }

    public void setTotle(int totle) {
        this.totle = totle;
        if(totle % pageSize != 0){
            pages = totle / pageSize + 1;
        }else {
            pages = totle / pageSize;
        }
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
