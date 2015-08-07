package ru.demi.webapp.utils;

/**
 * Created by demi
 * on 07.08.15.
 */
public class Pager
{
    private int page;
    private int numItems = 5;

    public Pager(String page)
    {
        try {
            this.page = Integer.parseInt(page);
            if (this.page < 0) {
                this.page = 1;
            }
        } catch (Exception e) {
            this.page = 1;
        }
    }

    public String getLimit()
    {
        int num = this.page - 1;
        return String.format("LIMIT %d, %d", num * numItems, numItems);
    }

    public String buildHtml(int count, String paramsString)
    {
        String html = "";
        html += "<ul class=\"pagination\">";
        if (this.page == 1) {
            html += "<li class=\"disabled\"><a href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&lt;&lt;</span></a></li>";
        } else {
            html += String.format("<li><a href=\"?page=%d%s\" aria-label=\"Previous\"><span aria-hidden=\"true\">&lt;&lt;</span></a></li>", this.page - 1, paramsString);
        }
        float nums = (float) count / numItems;
        int totalPages = (int) Math.ceil(nums);
        System.out.println("total pages - " + totalPages);
        for (int i = 1; i <= totalPages; i++) {
            if (i != this.page) {
                html += String.format("<li><a href=\"?page=%d%s\">%d</a></li>", i, paramsString, i);
            } else {
                html += String.format("<li class=\"active\"><a href=\"#\">%d <span class=\"sr-only\">(current)</span></a></li>", i);
            }
        }

        if (this.page == totalPages || totalPages == 0) {
            html += "<li class=\"disabled\"><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&gt;&gt;</span></a></li>";
        } else {
            html += String.format("<li><a href=\"?page=%d%s\" aria-label=\"Next\"><span aria-hidden=\"true\">&gt;&gt;</span></a></li>", this.page + 1, paramsString);
        }
        html += "</ul>";
        return html;
    }
}
