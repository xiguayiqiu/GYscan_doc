package com.gyscan_doc.Linux;

public class CommandDetail {
    private String description;
    private String usage;
    private String examples;
    private String options;

    public CommandDetail() {
    }

    public CommandDetail(String description, String usage, String examples, String options) {
        this.description = description;
        this.usage = usage;
        this.examples = examples;
        this.options = options;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getExamples() {
        return examples;
    }

    public void setExamples(String examples) {
        this.examples = examples;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}