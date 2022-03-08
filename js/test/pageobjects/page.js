
module.exports = class Page {

    open(path) {
        browser.maximizeWindow();
        return browser.url(`https://www.automationexercise.com/${path}`)
    }

    async attachFile(xpath) {
        const p = require('path');
        const filePath = p.join(__dirname, 'test\pageobjects\page.js');

        const remoteFilePath = browser.uploadFile(filePath);
        $(xpath).setValue(remoteFilePath);
    }

    async visibility(xpath) {
        let elem = $(xpath);
        return elem.isDisplayed();
    }

    async text(xpath, txt) {
        $(xpath).setValue(txt)
    }

    async click(xpath) {
        $(xpath).click();
    }

    async acceptAlert() {
        browser.acceptAlert();
    }
}
