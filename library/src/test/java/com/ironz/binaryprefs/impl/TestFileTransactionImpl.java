package com.ironz.binaryprefs.impl;

import com.ironz.binaryprefs.exception.ExceptionHandler;
import com.ironz.binaryprefs.file.adapter.FileAdapter;
import com.ironz.binaryprefs.file.transaction.FileTransaction;
import com.ironz.binaryprefs.file.transaction.TransactionElement;

public class TestFileTransactionImpl implements FileTransaction {

    private static final String COMMIT = "commit";

    private final String baseDir;
    private final FileAdapter fileAdapter;
    private final ExceptionHandler exceptionHandler;

    public TestFileTransactionImpl(String baseDir, FileAdapter fileAdapter, ExceptionHandler exceptionHandler) {
        this.baseDir = baseDir;
        this.fileAdapter = fileAdapter;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public TransactionElement[] fetch() {
        String[] names = fileAdapter.names(baseDir);
        TransactionElement[] elements = new TransactionElement[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int action = TransactionElement.ACTION_FETCH;
            byte[] bytes = fileAdapter.fetch(name);
            elements[i] = new TransactionElement(action, name, bytes);
        }
        return elements;
    }

    @Override
    public boolean commit(TransactionElement[] elements) {
        try {
            for (TransactionElement element : elements) {

                int action = element.getAction();
                String name = element.getName();
                byte[] content = element.getContent();

                if (action == TransactionElement.ACTION_UPDATE) {
                    fileAdapter.save(name, content);
                }

                if (action == TransactionElement.ACTION_REMOVE) {
                    fileAdapter.remove(name);
                }
            }
            return true;
        } catch (Exception e) {
            exceptionHandler.handle(COMMIT, e);
        }
        return false;
    }
}