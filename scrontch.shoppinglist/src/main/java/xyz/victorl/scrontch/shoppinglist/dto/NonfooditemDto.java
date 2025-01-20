package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.shoppinglist.entity.Nonfooditem}
 */
@Data
public class NonfooditemDto implements Serializable {
    Integer id;
    String nonfooditemname;
    String nonfooditemdescription;
    private Integer shoppinglistid;
}