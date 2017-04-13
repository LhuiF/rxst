package com.unionx.core.file;

import lombok.Data;

/**
 * @author jayson
 */
@Data
public class FileMeta {
    private String id;
    private String filename;
    private String aliases;
    private String contentType;
    private byte[] data;
    private String catetory;
    private String sizeCode;
}
