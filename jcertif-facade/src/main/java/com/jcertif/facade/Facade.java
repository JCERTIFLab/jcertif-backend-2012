/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade;

/**
 *
 * @author rossi.oddet
 */
public abstract class Facade {

    protected static final String CREATE_SUFFIX = "/create";
    protected static final String FINDBYID_SUFFIX = "/{id}";
    protected static final String FINDALL_SUFFIX = "/list";
    protected static final String UPDATE_SUFFIX = "/update";
    protected static final String DELETE_SUFFIX = "/delete";
}
