package com.formattextcli.app;

public class Line {
    String lineText = "";
    boolean isDivider = false;

    public Line() { }
    public Line(boolean isDivider) {
        this.isDivider = isDivider;
    }

    public boolean canAddLine(String text) {
        return text.length() + this.lineText.length() < 80 && !this.isDivider;
    }

    public void addText(String text) {
        if (this.lineText.length() > 0) {
            this._insertIntoLine(" ");
        }

        this._insertIntoLine(text);
    }

    public void printLine() {
        System.out.println(this.lineText);
    }

    private void _insertIntoLine(String text) {
        this.lineText += text;
    }
}
