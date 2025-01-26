package xyz.victorl.scrontch.common.dto;

import lombok.Value;

import java.io.Serializable;


@Value
public class StatusDto implements Serializable {
    Integer id;
    String name;
}