package com.aries.scloud.common.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author aries
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pr<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private long total;
    private List<T> rows;
}

