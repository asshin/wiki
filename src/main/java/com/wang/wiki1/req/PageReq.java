package com.wang.wiki1.req;

/**
 * @author zsw
 * @create 2022-02-10 13:18
 */
public class PageReq {
    private int page;
    private int size;

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }

    public PageReq(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageReq() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}