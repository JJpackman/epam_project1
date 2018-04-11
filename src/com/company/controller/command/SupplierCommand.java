package com.company.controller.command;

public interface SupplierCommand<T> {
    T execute() throws Exception;
}
