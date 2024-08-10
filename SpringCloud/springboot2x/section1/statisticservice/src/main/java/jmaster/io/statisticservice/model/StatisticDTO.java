package jmaster.io.statisticservice.model;

import java.util.Date;

import lombok.Data;

@Data
public class StatisticDTO {
    private Long id;
    private String message;
    private Date createdDate;
}
