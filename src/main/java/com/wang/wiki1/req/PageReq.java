package com.wang.wiki1.req;

/**
 * @author zsw
 * @create 2022-02-10 13:18
 */
public class PageReq {
    private int start;
    private int size;

    @Override
    public String toString() {
        return "PageReq{" +
                "start=" + start +
                ", size=" + size +
                '}';
    }

    public PageReq() {
    }

    public PageReq(int start, int size) {
        this.start = start;
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
