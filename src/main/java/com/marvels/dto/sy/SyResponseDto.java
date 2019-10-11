package com.marvels.dto.sy;


public class SyResponseDto {
    /**结果代码（必返回），返回0或者0000表示正常，其他为错误代码**/
    private String ec;
    //显示给用户的错误信息
    private String em;
    //参见具体交易接口
    private String body;

    public SyResponseDto(String ec,String em,String body) {
        this.ec = ec;
        this.em = em;
        this.body = body;
    }

    public SyResponseDto(String ec,String em) {
        this.ec = ec;
        this.em = em;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
