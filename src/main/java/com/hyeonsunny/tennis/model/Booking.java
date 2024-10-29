package com.hyeonsunny.tennis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Booking {
    @JsonProperty("GUBUN")
    private String gubun;       //서비스구분
    @JsonProperty("SVCID")
    private String svcid;       //서비스ID
    @JsonProperty("MAXCLASSNM")
    private String maxclassnm;  //대분류명
    @JsonProperty("MINCLASSNM")
    private String minclassnm;  //소분류명
    @JsonProperty("SVCSTATNM")
    private String svcstatnm;   //서비스상태
    @JsonProperty("SVCNM")
    private String svcnm;       //서비스명
    @JsonProperty("PAYATNM")
    private String payatnm;     //결제방법
    @JsonProperty("PLACENM")
    private String placenm;     //장소명
    @JsonProperty("USETGTINFO")
    private String usetgtinfo;  //서비스대상
    @JsonProperty("SVCURL")
    private String svcurl;      //바로가기URL
    @JsonProperty("X")
    private String x;           //장소X좌표
    @JsonProperty("Y")
    private String y;           //장소Y좌표
    @JsonProperty("SVCOPNBGNDT")
    private String svcopnbgndt; //서비스개시시작일시
    @JsonProperty("SVCOPNENDDT")
    private String svcopnenddt; //서비스개시종료일시
    @JsonProperty("RCPTBGNDT")
    private String rcptbgndt;   //접수시작일시
    @JsonProperty("RCPTENDDT")
    private String rcptenddt;   //접수종료일시
    @JsonProperty("AREANM")
    private String areanm;      //지역명
    @JsonProperty("IMGURL")
    private String imgurl;      //이미지경로
    @JsonProperty("DTLCONT")
    private String dtlcont;     //상세정보
    @JsonProperty("TELNO")
    private String telno;       //전화번호
    @JsonProperty("V_MIN")
    private String vMin;       //서비스이용 시작시간
    @JsonProperty("V_MAX")
    private String vMax;       //서비스이용 종료시간
    @JsonProperty("REVSTDDAYNM")
    private String revstddaynm; //취소기간 기준정보
    @JsonProperty("REVSTDDAY")
    private String revstdday;   //취소기간 기준일까지
}
