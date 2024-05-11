package com.example.duantn.config;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateEditor extends PropertyEditorSupport {

    private final SimpleDateFormat dateFormat;

    public CustomDateEditor(String format) {
        this.dateFormat = new SimpleDateFormat(format);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date = dateFormat.parse(text);
            setValue(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? dateFormat.format(value) : "");
    }
}
