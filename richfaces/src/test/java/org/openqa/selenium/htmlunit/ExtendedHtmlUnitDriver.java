package org.openqa.selenium.htmlunit;

public class ExtendedHtmlUnitDriver extends HtmlUnitDriver {

    public void setHeader(String name, String value) {
        this.getWebClient().addRequestHeader(name, value);
    }
}
