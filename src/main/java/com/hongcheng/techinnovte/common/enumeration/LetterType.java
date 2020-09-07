package com.hongcheng.techinnovte.common.enumeration;

public enum LetterType {

    VALID("JSM41810-0017"), ALLOW("JSM41810-0018"), REFUSE("JSM41810-0019");

    private String template;

    private LetterType(String template) {
        this.template = template;
    }
    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }
}