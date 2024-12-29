package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.shoppinglist.entity.Nonfooditem}
 */
@Value
public class NonfooditemDto implements Serializable {
    Integer id;
    String nonfooditemname;
    String nonfooditemdescription;
}