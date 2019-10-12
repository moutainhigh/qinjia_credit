package com.marvels.dto.sy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SyResponseDto {
    /**结果代码（必返回），返回0或者0000表示正常，其他为错误代码**/
    private String ec;
    /**显示给用户的错误信息 */
    private String em;
    /**参见具体交易接口*/
    private String body;

    public SyResponseDto() {

    }

    public SyResponseDto(String ec,String em,String body) {
        this.ec = ec;
        this.em = em;
        this.body = body;
    }

    public SyResponseDto(String ec,String em) {
        this.ec = ec;
        this.em = em;
    }

    @Override
    public String toString() {
        return "ReqToHaierResultDto [ec=" + ec + ", em=" + em
                + ", body=" + body + "]";
    }
}
